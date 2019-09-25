package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.exception.BookException;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ViewBookServlet
 * 商品详细信息显示
 */
@WebServlet("/viewBookServlet")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Integer id = Integer.parseInt(bookId);
		IBookService bookService = new BookServiceImpl();
		Book book = null;
		try {
			book = bookService.getBookById(id);
			request.getSession().setAttribute("bookInfoById", book);
			String path = request.getContextPath();
			response.sendRedirect(path+"/viewBook.jsp");
		} catch (BookException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
