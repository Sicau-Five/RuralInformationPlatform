package org.sicau.dao;

import java.sql.SQLException;

import org.sicau.entities.User;

public interface UserDao {
	public int FindUser(String userid, String userpwd) throws SQLException;

	public int AddUser(User user) throws SQLException;
}
