package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

/**
 * 顾客注册 servlet
 * @author hjw
 *
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String zipCode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Customer customer = new Customer();
		customer.setName(username);
		customer.setPassword(password);
		customer.setZip(zipCode);
		customer.setTelephone(telephone);
		customer.setEmail(email);
		ICustomerService  customerService = new CustomerServiceImpl();
		try {
			//这里只能try catch 不能抛给doGet方法,因为类继承httpservlet实现重写doGet方法，子类向父类抛异常异常不能被扩大
			customerService.register(customer);
			//注册成功
			response.sendRedirect("login.jsp");
		} catch (CustomerException e) {
			e.printStackTrace();
			//注册失败
			response.getWriter().println(e.getMessage());
		}
		
	}
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
