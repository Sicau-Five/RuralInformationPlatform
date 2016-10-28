package org.sicau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sicau.Service.UserService;
import org.sicau.util.Tools;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	UserService us = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		/*设置响应编码*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("username");
		String userpwd = request.getParameter("userpassword");
		
		int status=0;
		try {
			status = us.login(userid,Tools.MD5Encode(userpwd, ""));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.setHeader("content-type", "text/html;charset=utf-8");
		if(status == 0){
			PrintWriter out = response.getWriter();
			out.print("请检查用户名和密码是否正确!");
		}else{
			PrintWriter out = response.getWriter();
			out.print("登陆成功");
		}
	}

}








