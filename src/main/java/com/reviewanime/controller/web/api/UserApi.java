package com.reviewanime.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewanime.constant.SystemConstant;
import com.reviewanime.model.UserModel;
import com.reviewanime.service.IUserService;
import com.reviewanime.utils.HttpUtil;
@WebServlet(urlPatterns = {"/api-web-user"})
public class UserApi extends HttpServlet{
	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 4696615272134035365L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userModel.setCreatedBy(userModel.getUserName());
		userModel.setStatus(1);
		userModel.setRoleCode(SystemConstant.USER);
		userService.save(userModel);
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userModel.setModifiedBy(userModel.getUserName());
		userModel.setStatus(1);
		userModel.setRoleCode(SystemConstant.USER);
		userService.update(userModel);
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
}
