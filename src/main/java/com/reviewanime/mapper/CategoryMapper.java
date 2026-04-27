package com.reviewanime.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.reviewanime.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	private static final Logger logger = Logger.getLogger(AnimeMapper.class.getName());
	@Override
	public CategoryModel mapRow(ResultSet rs) throws SQLException {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(rs.getLong("id"));
			categoryModel.setName(rs.getString("name"));
			categoryModel.setCreatedDate(rs.getTimestamp("createddate"));
			categoryModel.setCreatedBy(rs.getString("createdby"));
			categoryModel.setCode(rs.getString("code")); 
			if (rs.getTimestamp("modifieddate") != null)
				categoryModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            if (rs.getString("modifiedby") != null)
            	categoryModel.setModifiedBy(rs.getString("modifiedby"));
			return categoryModel;
		} catch (SQLException e) {
			logger.severe("Lỗi map CategoryMapper: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
	
}
