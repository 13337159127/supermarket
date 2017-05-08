package com.kexin.commodityservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kexin.commodityservice.CommodityService;
import com.kexin.commodityservice.CommodityServiceImpl;
import com.kexin.userservice.UserService;
import com.kexin.userservice.UserServiceImpl;

/**
 * Servlet implementation class AddCommodity
 */
@WebServlet("/AddCommodity")
public class AddCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCommodity() {
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
		// 接收参数
		try {
			String commodityId = request.getParameter("commodityId");
			String commodityName = request.getParameter("commodityName");
			String commodityPrice = request.getParameter("commodityPrice");
			String commodityMuch = request.getParameter("commodityMuch");
			String commodityPeriod = request.getParameter("commodityPeriod");
			String commodityYiedly = request.getParameter("commodityYiedly");
			String categoryId = request.getParameter("categoryId");
			// 接收用户名
			HttpSession session = request.getSession();
			String loginName = (String) session.getAttribute("name");
			// 实列化类 创建对象 返回用户ID
			UserService userservice = new UserServiceImpl();
			String userId = userservice.getUserId(loginName);
			// 实列化类 创建对象 添加商品
			CommodityService commodityservice = new CommodityServiceImpl();
			commodityservice.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
					commodityYiedly, categoryId, userId);
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
