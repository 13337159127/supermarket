package com.kexin.commodityservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.commodityservice.CommodityService;
import com.kexin.commodityservice.CommodityServiceImpl;

/**
 * Servlet implementation class UpdateCommodity
 */
@WebServlet("/UpdateCommodity")
public class UpdateCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCommodity() {
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
			String commodityId = request.getParameter("commodityId");
			String commodityName = request.getParameter("commodityName");
			String commodityPrice = request.getParameter("commodityPrice");
			String commodityMuch = request.getParameter("commodityMuch");
			String commodityPeriod = request.getParameter("commodityPeriod");
			String commodityYiedly = request.getParameter("commodityYiedly");
			String categoryId = request.getParameter("categoryId");
			// 实列化类 创建对象 修改商品
			CommodityService commodityservice = new CommodityServiceImpl();
			commodityservice.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
					commodityYiedly, categoryId);
			RequestDispatcher re = request.getRequestDispatcher("FondCommodity");
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
