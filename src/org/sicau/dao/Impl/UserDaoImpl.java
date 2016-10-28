package org.sicau.dao.Impl;

import java.sql.SQLException;

import org.sicau.dao.UserDao;

public class UserDaoImpl extends jdbcBuild implements UserDao{

	@Override
	public int FindUser(String userid, String userpwd) throws SQLException {
		String sql = "select COUNT(userid) from user where userid = ? and userpwd = ?";
		Object[] params = {userid,userpwd};
		return findAllForInt(sql, params);
	}

}
