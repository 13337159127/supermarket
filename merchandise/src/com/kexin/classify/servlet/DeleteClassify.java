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
 * Servlet implementation class DeleteClassify
 */
@WebServlet("/DeleteClassify")
public class DeleteClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteClassify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 接收参数
		try {
			String categoryId = request.getParameter("categoryId");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			classifyservice.deleteClassify(categoryId);
			RequestDispatcher re = request.getRequestDispatcher("FondClassify");
			re.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
