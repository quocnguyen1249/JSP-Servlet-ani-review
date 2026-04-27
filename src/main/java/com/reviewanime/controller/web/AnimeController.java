package com.reviewanime.controller.web;

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
import com.reviewanime.service.impl.AnimeService;
import com.reviewanime.service.impl.CommentService;
import com.reviewanime.sort.Sorter;
import com.reviewanime.utils.FormUtil;
@WebServlet(urlPatterns = {"/item-anime"})
public class AnimeController extends HttpServlet{
	@Inject
	private AnimeService animeService;
	@Inject
	private CommentService commentService;
	private static final long serialVersionUID = -6075147317427493617L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AnimeModel animeModel = FormUtil.toModel(AnimeModel.class, req);
		if(animeModel.getId() != null) {
			animeModel = animeService.findOne(animeModel.getId());
		}
		animeModel.setListResult(animeService.findAll(new PageRequest(1, new Sorter("RAND()" , ""), 3)));
		req.setAttribute(SystemConstant.MODEL, animeModel);
		req.setAttribute(SystemConstant.COMMENTMODELS, commentService.findAllWithUserFullNameByAnimeId(animeModel.getId()));
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/item.jsp");
		rd.forward(req, resp);
	}
}
