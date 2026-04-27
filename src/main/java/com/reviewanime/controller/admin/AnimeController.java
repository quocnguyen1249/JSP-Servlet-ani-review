package com.reviewanime.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reviewanime.constant.SystemConstant;
import com.reviewanime.model.AnimeModel;
import com.reviewanime.paging.PageRequest;
import com.reviewanime.paging.Pageble;
import com.reviewanime.service.IAnimeService;
import com.reviewanime.service.ICategoryService;
import com.reviewanime.sort.Sorter;
import com.reviewanime.utils.FormUtil;
import com.reviewanime.utils.MessageUtil;
@WebServlet(urlPatterns = {"/admin-anime"})
public class AnimeController extends HttpServlet {
	private static final long serialVersionUID = 3509891424897399542L;
	@Inject
	private IAnimeService animeService; 
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AnimeModel model = FormUtil.toModel(AnimeModel.class, req);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), new Sorter(model.getSortName(), model.getSortBy()), model.getMaxPageItem());
			model.setListResult(animeService.findAll(pageble));
			model.setTotalItem(animeService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/anime/list.jsp";
		} else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = animeService.findOne(model.getId());
			}
			req.setAttribute(SystemConstant.CATEGORIES , categoryService.findAll());
			view = "/views/admin/anime/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
