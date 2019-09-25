package com.briup.web.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.exception.BookException;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 * 项目启动时就能够显示主界面
 * 把一级菜单，二级菜单，商品信息查出来显示
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("tomcat destory--------");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("tomcat init()......");
        ServletContext application = sce.getServletContext();
        
        //查询所有一级菜单
        IBookService bookService = new BookServiceImpl();
        List<Category> list1 = null;
        try {
			list1 = bookService.listAllOneCategory();
			System.out.println("所有一级菜单已经找到");
		} catch (BookException e) {
			e.printStackTrace();
		}
        application.setAttribute("oneCategory", list1);
        
        //查询所有二级菜单   key=一级菜单，value=对应的二级菜单
        Map<Category, List<Category>> map = null;
        try {
			map = bookService.listAllTwoCategory();
			System.out.println("所有二级菜单已经找到");
		} catch (BookException e) {
			e.printStackTrace();
		}
        //将所有二级菜单保存到application中
        application.setAttribute("twoCategory", map);
        
        //查询所有商品信息
        List<Book> list2 = null;
        try {
			list2 = bookService.listAllBook();
			System.out.println("所有图书已经放进application中");
		} catch (BookException e) {
			e.printStackTrace();
		}
        application.setAttribute("allBook", list2);
    }
	
}
