package org.sicau.Service;

import org.sicau.dao.UserDao;
import org.sicau.dao.Impl.UserDaoImpl;

public class UserService {
	
		UserDao u = new UserDaoImpl();
	/*
	 * �û���¼
	 * @param userid
	 * @param userpwd
	 * @return int 0--ʧ��  1--�ɹ�
	 * 
	 * */
	public int login(String userid, String userpwd){
		return u.FindUser(userid, userpwd);
	}
}
