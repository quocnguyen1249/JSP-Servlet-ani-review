package com.reviewanime.service;

import com.reviewanime.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	UserModel save(UserModel userModel);
	UserModel update(UserModel userModel);
	void delete(long[] ids);
	
}
