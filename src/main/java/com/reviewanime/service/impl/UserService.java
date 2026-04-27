package com.reviewanime.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.reviewanime.dao.IRoleDao;
import com.reviewanime.dao.IUserDao;
import com.reviewanime.model.RoleModel;
import com.reviewanime.model.UserModel;
import com.reviewanime.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDao userDao;
	@Inject
	private IRoleDao roleDao;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		RoleModel roleModel = roleDao.findByCode(userModel.getRoleCode());
		userModel.setRoleId(roleModel.getId());
		return userDao.findOne(userDao.save(userModel));
	}
	@Override
	public UserModel update(UserModel userModel) {
		UserModel userOld = userDao.findOne(userModel.getId());
		userModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		userModel.setCreatedDate(userOld.getCreatedDate());
		userModel.setCreatedBy(userOld.getCreatedBy());
		userModel.setRoleId(roleDao.findByCode(userModel.getRoleCode()).getId());
		userDao.update(userModel);
		return userDao.findOne(userModel.getId());
	}
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			userDao.delete(id);
		}
	}
	
}
