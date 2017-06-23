package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = userService.login(username,password);
			if(user==null){
				request.setAttribute("result", "用户名和密码不匹配");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(username+":欢迎回来!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
