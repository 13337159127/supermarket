package com.kexin.userservlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.userservice.UserService;
import com.kexin.userservice.UserServiceImpl;

/**
 * Servlet implementation class GetIdFondUser
 */
@WebServlet("/GetIdFondUser")
public class GetIdFondUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetIdFondUser() {
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
		try {
			String userId = request.getParameter("userId");
			UserService userservice = new UserServiceImpl();
			List<Map<String, String>> list = userservice.getIdFondUser(userId);
			request.setAttribute("list", list);
			RequestDispatcher re = request.getRequestDispatcher("username/updateuser.jsp");
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
