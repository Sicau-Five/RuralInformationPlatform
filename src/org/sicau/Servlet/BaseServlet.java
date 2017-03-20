package org.sicau.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ����һ����Servlet��װ�����Ĺ���servlet
	 * ����java���似����servlet��װ����!
	 * */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String v = request.getParameter("v");//����Ϊһ����������ķ�����
		Method method = null;
		try {
			method = getClass().getMethod(v, HttpServletRequest.class, HttpServletResponse.class);
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			System.out.println("��ȡ����������");
			return;
		}
		try {
			//ִ�з���
			String result = (String) method.invoke(this, request,response);
			if(result != null && !result.trim().isEmpty()){
				int index = result.indexOf(":");
				//��ȡǰ���ǰ׺�ͺ���Ĳ���
				String param = result.substring(0, index);
				String path = result.substring(index+1);
				//�ж����ض�����ת��
				if(param.equals("r")){//�ض���
					response.sendRedirect(path);
				}else if(param.equals("f")){
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
