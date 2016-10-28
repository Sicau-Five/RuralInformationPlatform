package org.sicau.dao;

import java.sql.SQLException;

public interface UserDao {
	public int FindUser(String userid, String userpwd) throws SQLException;
}
