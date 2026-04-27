package com.reviewanime.dao;

import java.util.List;

import com.reviewanime.model.CommentModel;

public interface ICommentDao extends GenericDao<CommentModel> {
	void deleteAllByAnimeId(Long animeId);
	Long save(CommentModel commentModel);
	void update(CommentModel commentModel);
	void delete(Long id);
	List<CommentModel> findAllByAnimeId(Long animeId);
	CommentModel findOne(Long id);
}
