package com.kexin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FirstFilter
 */
//@WebFilter("/FirstFilter")
public class FirstFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public FirstFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器销毁了");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置字符集编码
		request.setCharacterEncoding("UTF-8");
		// 强转request
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取登录用户名
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("name");
		// 接收访问的URL地址
		StringBuffer re = req.getRequestURL();
		System.out.println("URL输出的地址:" + re);
		System.out.println("输出访问用户名:" + username);
		// 定义一个校验的地址
		String url = "http://localhost:8080/merchandise/RegisterUser";
		String requestUrl = re.toString();
		// 如果用户名不为空 与 用户名不等于空 也可以访问后台
		if (username != null && !"".equals(username)) {
			chain.doFilter(request, response);
			// 判断是否是登录地址 如果是登录地址 可以访问后台 tostring是转换类型
		} else if (url.equals(re.toString())) {
			chain.doFilter(request, response);
			// 访问地址不为空（与）如果文件是以.js或.css结尾的 也可以访问
		} else if (requestUrl != null && (requestUrl.endsWith(".js") || requestUrl.endsWith(".css"))) {
			chain.doFilter(request, response);
			// 否则 跳转登录页面
		} else {
			RequestDispatcher rw = request.getRequestDispatcher("show/register.jsp");
			rw.forward(req, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器执行了");
	}

}
