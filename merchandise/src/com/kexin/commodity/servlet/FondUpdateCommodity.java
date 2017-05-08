package com.kexin.commodityservlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.classifyservice.ClassifyService;
import com.kexin.classifyservice.ClassifyServiceImpl;
import com.kexin.commodityservice.CommodityService;
import com.kexin.commodityservice.CommodityServiceImpl;

/**
 * Servlet implementation class FondUpdateCommodity
 */
@WebServlet("/FondUpdateCommodity")
public class FondUpdateCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FondUpdateCommodity() {
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
		try {
			String commodityId = request.getParameter("commodityId");
			// 实列化查询商品的类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list1 = commodityservice.fondUpdateCommodity(commodityId);
			request.setAttribute("list", list1);
			// 实列化查询分类的的类 获取分类
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<Map<String, String>> list = classifyservice.getClassify();
			request.setAttribute("re", list);
			RequestDispatcher rr = request.getRequestDispatcher("show/update.jsp");
			rr.forward(request, response);
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
