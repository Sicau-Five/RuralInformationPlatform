package org.sicau.dao.Impl;

import java.sql.SQLException;

import org.sicau.dao.UserDao;
import org.sicau.entities.User;

public class UserDaoImpl extends jdbcBuild implements UserDao{

	@Override
	public int FindUser(String userid, String userpwd) throws SQLException {
		String sql = "select COUNT(userid) from user where userid = ? and userpwd = ?";
		Object[] params = {userid,userpwd};
		return findAllForInt(sql, params);
	}

	@Override
	public int AddUser(User user) throws SQLException {
		String userId = user.getUserId();
		String userPwd = user.getUserPwd();
		String userName = user.getUserName();
		String email = user.getEmail();
		String sql = "insert into user(userid,username,userpwd,email)values(?,?,?,?)";
		Object[] params = {userId,userName,userPwd,email};
		return addOneRow(sql, params);
	}

}
