package com.reviewanime.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.reviewanime.model.RoleModel;
import com.reviewanime.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{
	private static final Logger LOGGER = Logger.getLogger(UserMapper.class.getName());
	@Override
	public UserModel mapRow(ResultSet rs) throws SQLException {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getLong("id"));
			user.setUserName(rs.getString("username"));
			user.setFullName(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setCreatedDate(rs.getTimestamp("createddate"));
			user.setCreatedBy(rs.getString("createdby"));
			if(rs.getTimestamp("modifieddate") != null) 
				user.setModifiedDate(rs.getTimestamp("modifieddate"));
			if(rs.getString("modifiedby") != null)
				user.setModifiedBy(rs.getString("modifiedby"));
			user.setStatus(rs.getInt("status"));
			user.setRoleId(rs.getLong("roleid"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				user.setRoleModel(role);
			} catch (Exception e) {
				LOGGER.severe(e.getMessage());
			}
			return user;
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			return null;
		}
	}

}
