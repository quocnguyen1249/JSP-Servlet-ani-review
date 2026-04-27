package com.reviewanime.service;

import java.util.List;

import com.reviewanime.model.CommentModel;

public interface ICommentService {
	CommentModel save(CommentModel commentModel);
	CommentModel update(CommentModel commentModel);
	void delete(long[] ids);
	List<CommentModel> findAllWithUserFullNameByAnimeId(Long animeId);
}
