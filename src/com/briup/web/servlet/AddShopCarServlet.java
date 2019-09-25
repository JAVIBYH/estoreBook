package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.exception.BookException;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AddShopCarServlet
 * 购物车
 */
@WebServlet("/addShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受书籍的ID
		String bookId = request.getParameter("bookId");
		Integer id = null;
		if(bookId!=null)
			id = Integer.parseInt(bookId);
		HttpSession session = request.getSession();
		//获取购物车的对象
		ShoppingCar car = (ShoppingCar)session.getAttribute("car");
		if(car==null){
			car = new ShoppingCar();
			request.getSession().setAttribute("car",car);
		}
		OrderLine line = new OrderLine();
		IBookService service = new BookServiceImpl();
		try {
			line.setBook(service.getBookById(id));
			line.setNum(1);
			car.add(line);
			System.out.println(request.getContextPath()+"---------------");
			response.sendRedirect(request.getContextPath()+"/shopCart.jsp");
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
