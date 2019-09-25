package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCar;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * 创建购物车对象 
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	//Session创建的时候，一并创建购物车对象，并放在session范围中
    	ShoppingCar car = new ShoppingCar();
    	se.getSession().setAttribute("car", car);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
