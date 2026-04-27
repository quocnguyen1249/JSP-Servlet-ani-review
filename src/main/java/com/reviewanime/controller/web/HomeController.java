package com.reviewanime.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reviewanime.constant.SystemConstant;
import com.reviewanime.model.AnimeModel;
import com.reviewanime.model.UserModel;
import com.reviewanime.paging.PageRequest;
import com.reviewanime.paging.Pageble;
import com.reviewanime.service.IAnimeService;
import com.reviewanime.service.ICategoryService;
import com.reviewanime.service.IUserService;
import com.reviewanime.sort.Sorter;
import com.reviewanime.utils.FormUtil;
import com.reviewanime.utils.MessageUtil;
import com.reviewanime.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/dang-ky","/thoat"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 6631592532104281748L;
	private static final String TRANGCHUMACDINH = "/trang-chu?page=1&maxPageItem=6&sortName=title&sortBy=desc&type=list";
	@Inject
	private IAnimeService animeService;
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	        throws ServletException, IOException {
	    String action = req.getParameter(SystemConstant.ACTION);
	    if(action != null && action.equals(SystemConstant.LOGIN)) {
	        MessageUtil.showMessage(req);
	        RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
	        rd.forward(req, resp);
	    } else if(action != null && action.equals(SystemConstant.LOGOUT)) {
	        SessionUtil.getInstance().removeValue(req, SystemConstant.USERMODEL);
	        resp.sendRedirect(req.getContextPath() + TRANGCHUMACDINH);
	    } else if (action != null && action.equals(SystemConstant.REGISTER)) {
	        MessageUtil.showMessage(req);
	        RequestDispatcher rd = req.getRequestDispatcher("/views/register.jsp");
	        rd.forward(req, resp);
	    } else {
	        AnimeModel animeModel = FormUtil.toModel(AnimeModel.class, req);
	        Pageble pageble = new PageRequest(animeModel.getPage(), new Sorter(animeModel.getSortName(),
	        		animeModel.getSortBy()), animeModel.getMaxPageItem());
	        String[] codes = animeModel.getCategoryCodes();
	        List<String> categoryCodes = codes != null ? Arrays.asList(codes) : new ArrayList<>();
	        if (categoryCodes.isEmpty()) {
	            animeModel.setListResult(animeService.findAll(pageble));
	            animeModel.setTotalItem(animeService.getTotalItem());
	        } else {
	            animeModel.setListResult(animeService.findByCategoryCodes(categoryCodes, pageble));
	            animeModel.setTotalItem(animeService.getTotalItemByCategoryCodes(categoryCodes));
	        }
	        animeModel.setTotalPage((int) Math.ceil((double) animeModel.getTotalItem() / animeModel.getMaxPageItem()));
	        req.setAttribute(SystemConstant.SELECTEDCATEGORIES, categoryCodes);
	        req.setAttribute(SystemConstant.CATEGORIES, categoryService.findAll());
	        req.setAttribute(SystemConstant.MODEL, animeModel);
	        RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
	        rd.forward(req, resp);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter(SystemConstant.ACTION);
		if(action != null && action.equals(SystemConstant.LOGIN)) {
			UserModel userModel = FormUtil.toModel(UserModel.class, req);
			userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);
			if(userModel != null) {
				SessionUtil.getInstance().putValue(req, SystemConstant.USERMODEL, userModel);
				if(userModel.getRoleModel().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + TRANGCHUMACDINH);
				} else if(userModel.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		} else{
			resp.sendRedirect(req.getContextPath() + TRANGCHUMACDINH);
		}
	}
}
