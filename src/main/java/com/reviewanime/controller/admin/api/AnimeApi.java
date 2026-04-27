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
import com.reviewanime.model.AnimeModel;
import com.reviewanime.model.UserModel;
import com.reviewanime.service.IAnimeService;
import com.reviewanime.utils.HttpUtil;
import com.reviewanime.utils.SessionUtil;
@WebServlet(urlPatterns = {"/api-admin-anime"})
public class AnimeApi extends HttpServlet{
	private static final long serialVersionUID = -7816841200226146256L;
	@Inject
	IAnimeService animeService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		AnimeModel animeModel = HttpUtil.of(req.getReader()).toModel(AnimeModel.class);
		animeModel.setCreatedBy(((UserModel)SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL)).getUserName());
		animeModel = animeService.save(animeModel);
		mapper.writeValue(resp.getOutputStream(), animeModel);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		AnimeModel animeModel = HttpUtil.of(req.getReader()).toModel(AnimeModel.class);
		animeModel.setModifiedBy(((UserModel)SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL)).getUserName());
		animeModel = animeService.update(animeModel);
		mapper.writeValue(resp.getOutputStream(), animeModel);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		AnimeModel animeModel = HttpUtil.of(req.getReader()).toModel(AnimeModel.class);
		animeService.delete(animeModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
