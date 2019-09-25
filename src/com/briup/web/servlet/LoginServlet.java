package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

/**
 * 登录servlet
 * @author hjw
 *
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ICustomerService customerService = new CustomerServiceImpl();
		Customer customer = null;
		try {
			customer = customerService.login(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("loginCustomer", customer);
			//跳转登录之后成功界面
			response.sendRedirect("main.jsp");
		} catch (CustomerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			request.setAttribute("errorMsg", e.getMessage());   
			//这里不能使用重定向
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
