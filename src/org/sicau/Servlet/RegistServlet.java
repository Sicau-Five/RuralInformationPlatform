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
		//��һ��������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//���Ƚ��ܴ�ע��ҳ�洫����������
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userPwdCon = request.getParameter("userPwdCon");
		String email = request.getParameter("email");
		User user = new User(userId,userName,Tools.MD5Encode(userPwd,""),email);
		UserService us = new UserService();
		int status = 0;//ע���Ƿ�ɹ��ı�־
		//��ȡ��ֵ��һ��Ӧ���ж��Ƿ������������벻��
		if(!userPwd.equals(userPwdCon)){
			request.setAttribute("registInfo", "�����������벻һ��!");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else{//��������ǶԵ�
			try {
				status = us.regist(user);
				if(status != 0){
					//ע��ɹ�,������¼ҳ��!
					request.setAttribute("registInfo", "ע��ɹ����¼!");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
				}else{
					request.setAttribute("registInfo", "ע��ʧ��");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}/*else*/
	}

}
