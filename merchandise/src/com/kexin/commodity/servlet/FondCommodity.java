package com.kexin.commodity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kexin.commodity.CommodityEntity;
import com.kexin.commodity.service.CommodityService;
import com.kexin.commodity.service.CommodityServiceImpl;

/**
 * Servlet implementation class fondCommodity
 */
@WebServlet("/FondCommodity")
public class FondCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FondCommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 接收参数
		try {
			String classify = request.getParameter("classify");
			String sort = request.getParameter("sort");
			String designation = request.getParameter("designation");
			// session接收用户名
			HttpSession session = request.getSession();
			String loginname = (String) session.getAttribute("name");
			// 实列化类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<CommodityEntity> list = commodityservice.fondCommodity(loginname, classify, designation, sort);
			// 向前台传值
			request.setAttribute("re", list);
			RequestDispatcher re = request.getRequestDispatcher("show/show.jsp");
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
