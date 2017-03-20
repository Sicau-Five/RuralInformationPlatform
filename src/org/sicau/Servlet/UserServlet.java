package org.sicau.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sicau.Service.UserService;
import org.sicau.util.Tools;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
	
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//���Ȼ���˻�������
		String userid = request.getParameter("username");
		String userpwd = request.getParameter("userpassword");
		String verifycode = request.getParameter("verify");
		//���ж��˺�����
		if (userid.equals("") || userpwd.equals("")) {
			request.setAttribute("info", "�˺����벻��Ϊ��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(verifycode.equals("")){//��֤�벻��Ϊ��
			request.setAttribute("info", "��֤�벻��Ϊ��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{//�����Ƕ���Ϊ�յ����
			
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
			if(status == 1 && verifycode.equals(request.getSession().getAttribute("checkcode"))){
				session = request.getSession();
				session.setAttribute("userid", userid);
				response.sendRedirect("index.jsp");
			}else if(status == 0){//�˺�������֤ʧ��
				request.setAttribute("info", "�˺��������,����������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{//��֤�����
				request.setAttribute("info", "��֤�����,�����µ�¼");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}/*doPost*/
	}
	
	public void regist(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	public void query(HttpServletRequest request, HttpServletResponse response){
		
	}

}
