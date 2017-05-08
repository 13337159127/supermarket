package com.kexin.commodity.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kexin.commodity.service.CommodityService;
import com.kexin.commodity.service.CommodityServiceImpl;

/**
 * Servlet implementation class CommoditySum
 */
@WebServlet("/CommoditySum")
public class CommoditySum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommoditySum() {
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
		// session获取用户名
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("name");
			// 实列化类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list = commodityservice.commoditySum(username);
			request.setAttribute("list", list);
			RequestDispatcher re = request.getRequestDispatcher("show/sum.jsp");
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
