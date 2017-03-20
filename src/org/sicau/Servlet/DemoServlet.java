package org.sicau.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo.do")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先设置响应编码集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//使用Atribute进行信息传递
		request.setAttribute("info", "this is for responsing----get");
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("fuck1");
		list.add("fuck2");
		list.add("fuck3");
		list.add("fuck4");
		request.setAttribute("list", list);
		request.getRequestDispatcher("/Error.jsp").forward(request, response);

	}

}
