package com.reviewanime.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewanime.constant.SystemConstant;
import com.reviewanime.model.CategoryModel;
import com.reviewanime.model.UserModel;
import com.reviewanime.service.impl.CategoryService;
import com.reviewanime.utils.HttpUtil;
import com.reviewanime.utils.SessionUtil;
@WebServlet(urlPatterns = {"/api-admin-category"})
public class CategoryApi extends HttpServlet{
	@Inject
	private CategoryService categoryService;
	private static final long serialVersionUID = 2617220828574617246L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryModel.setCreatedBy(((UserModel)SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL)).getUserName());
		categoryModel = categoryService.save(categoryModel);
		mapper.writeValue(resp.getOutputStream(), categoryModel);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryModel.setModifiedBy(((UserModel)SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL)).getUserName());
		categoryModel = categoryService.update(categoryModel);
		mapper.writeValue(resp.getOutputStream(), categoryModel);
		
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.delete(categoryModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
