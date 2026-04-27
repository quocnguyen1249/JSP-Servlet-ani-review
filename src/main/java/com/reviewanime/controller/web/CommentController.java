package com.reviewanime.controller.web;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reviewanime.constant.SystemConstant;
import com.reviewanime.model.CommentModel;
import com.reviewanime.model.UserModel;
import com.reviewanime.service.ICommentService;
import com.reviewanime.utils.FormUtil;
import com.reviewanime.utils.SessionUtil;

@WebServlet(urlPatterns = {"/comment-add"})
public class CommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ICommentService commentService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL);
        if (userModel == null) {
            resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
            return;
        }
        CommentModel commentModel = FormUtil.toModel(CommentModel.class, req);
        commentModel.setUserId(userModel.getId());
        commentModel.setCreatedBy(userModel.getUserName());
        String animeIdParam = req.getParameter("animeId");
        if (animeIdParam != null) {
            commentModel.setAnimeId(Long.parseLong(animeIdParam));
        }
        commentService.save(commentModel);
        resp.sendRedirect(req.getContextPath() + "/item-anime?id=" + commentModel.getAnimeId());

    }
}
