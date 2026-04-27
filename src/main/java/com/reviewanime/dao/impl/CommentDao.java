package com.reviewanime.dao.impl;

import java.util.List;

import com.reviewanime.dao.ICommentDao;
import com.reviewanime.mapper.CommentMapper;
import com.reviewanime.model.CommentModel;

public class CommentDao extends AbstractDao<CommentModel> implements ICommentDao {

	@Override
	public void deleteAllByAnimeId(Long animeId) {
		String sql = "DELETE FROM comment WHERE animeid = ?";
		update(sql, animeId);
	}

	@Override
	public Long save(CommentModel commentModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO comment (content, userid, animeid, createddate, createdby) VALUES (?, ?, ?, ?, ?)");
		return insert(sql.toString(),
					commentModel.getContent(),
					commentModel.getUserId(),
					commentModel.getAnimeId(),
					commentModel.getCreatedDate(),
					commentModel.getCreatedBy());
	}


	@Override
	public void update(CommentModel commentModel) {
		String sql = "UPDATE comment SET content = ?, userid = ?, animeid = ?, modifieddate = ?, modifiedby = ? WHERE id = ?";
		update(sql,
			   commentModel.getContent(),
			   commentModel.getUserId(),
			   commentModel.getAnimeId(),
			   commentModel.getModifiedDate(),
			   commentModel.getModifiedBy(),
			   commentModel.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM content WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<CommentModel> findAllByAnimeId(Long animeId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM comment WHERE animeid = ?");
		return query(sql.toString(), new CommentMapper(), animeId);
	}

	@Override
	public CommentModel findOne(Long id) {
		String sql = "SELECT * FROM comment WHERE id = ?";
		List<CommentModel>  CommentModels = query(sql, new CommentMapper(), id);
		return CommentModels.isEmpty() ? null : CommentModels.get(0);
	}

}
