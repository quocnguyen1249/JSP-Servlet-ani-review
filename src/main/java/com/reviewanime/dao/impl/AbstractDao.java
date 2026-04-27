package com.reviewanime.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.reviewanime.dao.GenericDao;
import com.reviewanime.mapper.RowMapper;

public class AbstractDao<T> implements GenericDao<T> {

	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName());
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			LOGGER.severe("Lỗi kết nối DB: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			if (connection == null) {
				LOGGER.severe("Không thể update vì connection = null");
				return;
			}
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			LOGGER.severe("Lỗi update(): " + e.getMessage());
			e.printStackTrace();
			try {
				if (connection != null)
					connection.rollback();
			} catch (SQLException e2) {
				LOGGER.severe("Rollback thất bại: " + e2.getMessage());
			}
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.severe("Lỗi khi đóng kết nối update(): " + e.getMessage());
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			if (connection == null) {
				LOGGER.severe("Không thể insert vì connection = null");
				return null;
			}
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			LOGGER.severe("Lỗi insert(): " + e.getMessage());
			e.printStackTrace();
			try {
				if (connection != null)
					connection.rollback();
			} catch (SQLException e2) {
				LOGGER.severe("Rollback thất bại: " + e2.getMessage());
			}
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.severe("Lỗi khi đóng kết nối insert(): " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		int count = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			if (connection == null) {
				LOGGER.severe("Không thể count vì connection = null");
				return 0;
			}
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			LOGGER.severe("Lỗi count(): " + e.getMessage());
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.severe("Lỗi khi đóng kết nối count(): " + e.getMessage());
			}
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			if (connection == null) {
				LOGGER.severe("Không thể query vì connection = null");
				return null;
			}
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(rowMapper.mapRow(resultSet));
			}
			return list;
		} catch (SQLException e) {
			LOGGER.severe("Lỗi query(): " + e.getMessage());
			e.printStackTrace();
			return null;

		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.severe("Lỗi khi đóng kết nối query(): " + e.getMessage());
			}
		}
	}

	private void setParameters(PreparedStatement statement, Object[] parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;

				if (parameter instanceof Long)
					statement.setLong(index, (Long) parameter);
				else if (parameter instanceof String)
					statement.setString(index, (String) parameter);
				else if (parameter instanceof Integer)
					statement.setInt(index, (Integer) parameter);
				else if (parameter instanceof Timestamp)
					statement.setTimestamp(index, (Timestamp) parameter);
				else if (parameter instanceof Float)
					statement.setFloat(index, (Float) parameter);
				else
					LOGGER.warning("Không hỗ trợ kiểu dữ liệu: " + parameter.getClass().getName());
			}

		} catch (SQLException e) {
			LOGGER.severe("Lỗi setParameters(): " + e.getMessage());
			e.printStackTrace();
		}
	}
}
