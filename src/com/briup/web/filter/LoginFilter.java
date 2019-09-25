package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns={"*.jsp"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		Customer customer = (Customer)req.getSession().getAttribute("loginCustomer");
		if(customer==null){
			String uri = req.getRequestURI();
			System.out.println("uri==========="+uri);  //     /estoreBookAll/main.jsp
			String contextPath = req.getContextPath();
			System.out.println("contextPath------------"+contextPath);   //   /estoreBookAll
			String path = uri.substring(contextPath.length());
			System.out.println("path---------------"+path);    //    /main.jsp
			if("/register.jsp".equalsIgnoreCase(path)){
				chain.doFilter(request, response);
				return;
			}
			if(!("/login.jsp".equalsIgnoreCase(path))){
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			} 
		}  
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
