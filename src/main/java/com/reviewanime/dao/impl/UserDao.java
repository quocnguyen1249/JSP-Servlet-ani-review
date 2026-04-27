package com.reviewanime.dao.impl;

import java.util.List;

import com.reviewanime.dao.IUserDao;
import com.reviewanime.mapper.UserMapper;
import com.reviewanime.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> userModels = query(sql.toString(), new UserMapper(), userName, password, status);
		return userModels.isEmpty() ? null : userModels.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (username, password, fullname, status");
		sql.append(", roleid, createddate, createdby)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(),
									userModel.getUserName(),
									userModel.getPassword(),
									userModel.getFullName(),
									userModel.getStatus(),
									userModel.getRoleId(),
									userModel.getCreatedDate(),
									userModel.getCreatedBy()
										);
	}

	@Override
	public void update(UserModel userModel) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ?, fullname = ?,");
		sql.append(" status = ?, roleid = ?, modifieddate = ?, modifiedby = ? ");
		sql.append(" WHERE id = ?");
		update(sql.toString(),
							userModel.getUserName(),
							userModel.getPassword(),
							userModel.getFullName(),
							userModel.getStatus(),
							userModel.getRoleId(),
							userModel.getModifiedDate(),
							userModel.getModifiedBy(),
							userModel.getId()
				);
	}

	@Override
	public void delete(Long id) {
        String sqlAnime = "DELETE FROM user WHERE id = ?";
        update(sqlAnime, id);
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user ORDER BY createddate DESC";
		List<UserModel> userList = query(sql,new UserMapper());
		return userList;
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> userList = query(sql,new UserMapper(), id);
		return userList.isEmpty() ? null : userList.get(0);
	}
}
