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
import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.PageRequest;
import com.reviewanime.paging.Pageble;
import com.reviewanime.service.impl.CategoryService;
import com.reviewanime.sort.Sorter;
import com.reviewanime.utils.FormUtil;
import com.reviewanime.utils.MessageUtil;
@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet{
	@Inject
	private CategoryService categoryService;
	private static final long serialVersionUID = 2503980567896692352L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel model = FormUtil.toModel(CategoryModel.class, req);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), new Sorter(model.getSortName(), model.getSortBy()), model.getMaxPageItem());
			model.setListResult(categoryService.findAll(pageble));
			model.setTotalItem(categoryService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/category/list.jsp";
		} else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = categoryService.findOne(model.getId());
			}
			view = "/views/admin/category/edit.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
