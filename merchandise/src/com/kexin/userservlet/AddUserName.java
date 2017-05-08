package com.kexin.userservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kexin.userservice.UserService;
import com.kexin.userservice.UserServiceImpl;

/**
 * Servlet implementation class AddUserName
 */
@WebServlet("/AddUserName")
public class AddUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserName() {
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
			String loginName = request.getParameter("loginName");
			String passWord = request.getParameter("passWord");
			UserService userservice = new UserServiceImpl();
			userservice.addUserName(userId, loginName, passWord);
			RequestDispatcher re = request.getRequestDispatcher("FondUser");
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
