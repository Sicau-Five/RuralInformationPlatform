package org.sicau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String verifycode = request.getParameter("verify");
		//先判断账号密码
		if (userid.equals("") || userpwd.equals("")) {
			request.setAttribute("info", "账号密码不能为空");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(verifycode.equals("")){//验证码不能为空
			request.setAttribute("info", "验证码不能为空");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{//以下是都不为空的情况
			
			//设置一个session
			HttpSession session = request.getSession();
			int status=0;
			try {
				status = us.login(userid,Tools.MD5Encode(userpwd, ""));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			response.setHeader("content-type", "text/html;charset=utf-8");
			//获取到status登录状态之后需要
			/*
			 * 1.登录成功,跳转到主页,并显示session
			 * 2.登录失败,js提示登录失败,不跳转
			 * */
			if(status == 1 && verifycode.equals(request.getSession().getAttribute("checkcode"))){
				session = request.getSession();
				session.setAttribute("userid", userid);
				response.sendRedirect("index.jsp");
			}else if(status == 0){//账号密码验证失败
				request.setAttribute("info", "账号密码错误,请重新输入");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{//验证码错误
				request.setAttribute("info", "验证码错误,请重新登录");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}/*doPost*/
	}/*class*/

}








