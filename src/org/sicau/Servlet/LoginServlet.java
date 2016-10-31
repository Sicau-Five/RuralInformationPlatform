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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*������Ӧ����*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("username");
		String userpwd = request.getParameter("userpassword");
		//����һ��session
		HttpSession session = request.getSession();
		int status=0;
		try {
			status = us.login(userid,Tools.MD5Encode(userpwd, ""));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.setHeader("content-type", "text/html;charset=utf-8");
		//��ȡ��status��¼״̬֮����Ҫ
		/*
		 * 1.��¼�ɹ�,��ת����ҳ,����ʾsession
		 * 2.��¼ʧ��,js��ʾ��¼ʧ��,����ת
		 * */
		if(status == 1){
			session = request.getSession();
			session.setAttribute("userid", userid);
			response.sendRedirect("index.jsp");
			
		}else{
			session.setAttribute("userid", "error");
			response.sendRedirect("login.jsp");
		}
		
	}

}








