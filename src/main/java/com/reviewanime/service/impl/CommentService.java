package com.reviewanime.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.reviewanime.dao.ICommentDao;
import com.reviewanime.dao.IUserDao;
import com.reviewanime.model.CommentModel;
import com.reviewanime.service.ICommentService;

public class CommentService implements ICommentService{
	@Inject
	private ICommentDao commentDao;
	@Inject
	private IUserDao userDao;

	
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			commentDao.delete(id);
		}
		
	}

	@Override
	public List<CommentModel> findAllWithUserFullNameByAnimeId(Long animeId) {
		List<CommentModel> list = commentDao.findAllByAnimeId(animeId);
		for (CommentModel commentModel : list) {
			commentModel.setUserFullName(userDao.findOne(commentModel.getUserId()).getFullName());
		}
		return list;
	}

	@Override
	public CommentModel save(CommentModel commentModel) {
		commentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return commentDao.findOne(commentDao.save(commentModel));
	}

	@Override
	public CommentModel update(CommentModel commentModel) {
		CommentModel commentModelOld = commentDao.findOne(commentModel.getId());
		commentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		commentModel.setCreatedDate(commentModelOld.getCreatedDate());
		commentModel.setCreatedBy(commentModelOld.getCreatedBy());
		commentDao.update(commentModel);
		return commentDao.findOne(commentModel.getId());
	}
}
