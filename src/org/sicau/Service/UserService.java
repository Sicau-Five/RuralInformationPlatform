package org.sicau.Service;

import java.sql.SQLException;

import org.sicau.dao.UserDao;
import org.sicau.dao.Impl.UserDaoImpl;
import org.sicau.entities.User;

public class UserService {
	
		UserDao u = new UserDaoImpl();
	/*
	 * �û���¼
	 * @param userid
	 * @param userpwd
	 * @return int 0--ʧ��  1--�ɹ�
	 * 
	 * */
	public int login(String userid, String userpwd) throws SQLException{
		return u.FindUser(userid, userpwd);
	}
	public int regist(User user) throws SQLException {
		
		return u.AddUser(user);
	}
}
