package com.kexin.classifyservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.classifyservice.ClassifyService;
import com.kexin.classifyservice.ClassifyServiceImpl;

/**
 * Servlet implementation class AddClassify
 */
@WebServlet("/AddClassify")
public class AddClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClassify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编吗
		request.setCharacterEncoding("UTF-8");
		// 接收参数
		try{
		String category = request.getParameter("category");
		String categoryId = request.getParameter("categoryId");
		ClassifyService classifyservice = new ClassifyServiceImpl();
		classifyservice.addClassify(category, categoryId);
		RequestDispatcher re = request.getRequestDispatcher("FondClassify");
		re.forward(request, response);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
