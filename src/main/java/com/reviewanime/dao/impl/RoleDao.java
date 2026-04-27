package com.reviewanime.dao.impl;

import java.util.List;

import com.reviewanime.dao.IRoleDao;
import com.reviewanime.mapper.RoleMapper;
import com.reviewanime.model.RoleModel;

public class RoleDao extends AbstractDao<RoleModel> implements IRoleDao {

	@Override
	public RoleModel findByCode(String code) {
		String sql = "SELECT * FROM role WHERE code = ?";
	    List<RoleModel> roleList = query(sql, new RoleMapper(), code);
	    return roleList.isEmpty() ? null : roleList.get(0);
	}

}
