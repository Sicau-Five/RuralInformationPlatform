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
	 * 这是一个将Servlet封装起来的公共servlet
	 * 利用java反射技术将servlet封装起来!
	 * */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String v = request.getParameter("v");//定义为一个做出请求的方法名
		Method method = null;
		try {
			method = getClass().getMethod(v, HttpServletRequest.class, HttpServletResponse.class);
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			System.out.println("获取方法名出错");
			return;
		}
		try {
			//执行方法
			String result = (String) method.invoke(this, request,response);
			if(result != null && !result.trim().isEmpty()){
				int index = result.indexOf(":");
				//获取前面的前缀和后面的参数
				String param = result.substring(0, index);
				String path = result.substring(index+1);
				//判断是重定向还是转发
				if(param.equals("r")){//重定向
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
