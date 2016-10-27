package org.sicau.Service;

import org.sicau.dao.UserDao;
import org.sicau.dao.Impl.UserDaoImpl;

public class UserService {
	
		UserDao u = new UserDaoImpl();
	/*
	 * 用户登录
	 * @param userid
	 * @param userpwd
	 * @return int 0--失败  1--成功
	 * 
	 * */
	public int login(String userid, String userpwd){
		return u.FindUser(userid, userpwd);
	}
}
