package com.reviewanime.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.reviewanime.model.CommentModel;

public class CommentMapper implements RowMapper<CommentModel>{
	private static final Logger logger = Logger.getLogger(AnimeMapper.class.getName());
	@Override
	public CommentModel mapRow(ResultSet rs) throws SQLException {
		try {
			CommentModel commentModel = new CommentModel();
			commentModel.setContent(rs.getString("content"));
			commentModel.setAnimeId(rs.getLong("animeid"));
			commentModel.setUserId(rs.getLong("userid"));
			commentModel.setCreatedDate(rs.getTimestamp("createddate"));
			commentModel.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate") != null)
				commentModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            if (rs.getString("modifiedby") != null)
            	commentModel.setModifiedBy(rs.getString("modifiedby"));
			return commentModel;
		} catch (Exception e) {
			logger.severe("Lỗi map CommentMapper: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
