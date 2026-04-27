package com.reviewanime.dao;

import com.reviewanime.model.RoleModel;

public interface IRoleDao extends GenericDao<RoleModel>{
	RoleModel findByCode(String code);
}
