package org.sicau.entities;

public class User {
	
	//用户的四个属性
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	
	//构造方法
	public User(String userId, String userName, String userPwd, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
	}
	public User() {
		super();
	}
	
	//setter and getter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
