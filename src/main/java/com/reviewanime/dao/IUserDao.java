package com.reviewanime.dao;

import java.util.List;

import com.reviewanime.model.UserModel;

public interface IUserDao extends GenericDao<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long save(UserModel userModel);
	void update(UserModel userModel);
	void delete(Long id);
	List<UserModel> findAll();
	UserModel findOne(Long id);
}
