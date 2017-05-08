package com.kexin.classify.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.classify.service.ClassifyService;
import com.kexin.classify.service.ClassifyServiceImpl;

/**
 * Servlet implementation class GetIdUpdateClassify
 */
@WebServlet("/GetIdUpdateClassify")
public class GetIdUpdateClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetIdUpdateClassify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编码
		request.setCharacterEncoding("UTF-8");
		try {
			String categoryid = request.getParameter("categoryId");
			// 实列化类 创建对象
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<Map<String, String>> list = classifyservice.getIdUpdateClassify(categoryid);
			request.setAttribute("list", list);
			RequestDispatcher re = request.getRequestDispatcher("classify/update.jsp");
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
