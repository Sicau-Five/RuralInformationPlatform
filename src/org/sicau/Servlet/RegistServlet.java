package org.sicau.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sicau.Service.UserService;
import org.sicau.entities.User;
import org.sicau.util.Tools;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一步设置响应类型
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//首先接受从注册页面传过来的数据
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userPwdCon = request.getParameter("userPwdCon");
		String email = request.getParameter("email");
		User user = new User(userId,userName,Tools.MD5Encode(userPwd,""),email);
		UserService us = new UserService();
		int status = 0;//注册是否成功的标志
		//获取到值第一个应该判断是否密码两次输入不对
		if(!userPwd.equals(userPwdCon)){
			request.setAttribute("registInfo", "两次密码输入不一致!");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else{//如果密码是对的
			try {
				status = us.regist(user);
				if(status != 0){
					//注册成功,跳到登录页面!
					request.setAttribute("registInfo", "注册成功请登录!");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
				}else{
					request.setAttribute("registInfo", "注册失败");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}/*else*/
	}

}
