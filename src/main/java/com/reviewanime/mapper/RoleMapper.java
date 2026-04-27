package com.reviewanime.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.reviewanime.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{
	private static final Logger LOGGER = Logger.getLogger(RoleMapper.class.getName());
	@Override
	public RoleModel mapRow(ResultSet rs) throws SQLException {
		try {
			RoleModel roleModel = new RoleModel();
			roleModel.setId(rs.getLong("id"));
			roleModel.setCode(rs.getString("code"));
			roleModel.setCreatedDate(rs.getTimestamp("createddate"));
			roleModel.setCreatedBy(rs.getString("createdby"));
			if(rs.getTimestamp("modifieddate") != null) 
				roleModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			if(rs.getString("modifiedby") != null)
				roleModel.setModifiedBy(rs.getString("modifiedby"));
			return roleModel;
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			return null;
		}
	}

}
