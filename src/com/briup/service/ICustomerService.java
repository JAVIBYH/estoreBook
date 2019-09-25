package com.briup.service;

import java.util.List;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.bean.ShipAddress;
import com.briup.exception.CustomerException;

/**
 * 与customer相关的业务逻辑处理接口
 * @author hjw
 *
 */
public interface ICustomerService {
	 /**
	  * 登录
	  * @param name
	  * @param password
	  * @return
	  * @throws CustomerException
	  */
	 public Customer login(String name,String password) throws CustomerException;
	 
	 /**
	  * 注册
	  * @param customer
	  * @throws CustomerException
	  */
	 public void register(Customer customer) throws CustomerException;
	 
	 
	 
	 
	 
	 /**
	 * 根据用户ID查找收货地址列表
	 * */
	 List<ShipAddress> findShipAddress(int customerId) throws CustomerException;
	 /**
	 * 根据收货地址ID查找收货地址
	 * */
	 ShipAddress findShipAddressById(int shipId) throws CustomerException;
	 /**
	 * 保存收货地址
	 * */
	 void saveShipAddress(ShipAddress shipAddress) throws CustomerException;
	 /**
	 * 保存订单，订单入库，包括订单中的订单项的集合 也要入库
	 * */
	 void saveOrder(Order orderForm) throws CustomerException;
	 /**
	 * 根据顾客ID查找所有订单
	 * */
	 List<Order> findAllOrderForm(int customerId) throws CustomerException;
	 /**
	 * 根据订单ID查找所有订单
	 * */
	 Order findOrderFormById(int orderFormId) throws CustomerException;
	 /**
	 * 根据订单ID删除订单
	 * */
	 void deleteOrderForm(int orderFormId) throws CustomerException;
}
