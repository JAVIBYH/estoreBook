package com.briup.dao;

import java.util.List;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.ShipAddress;
 
/**
 * Dao层 顾客
 * @author hjw
 *
 */
public interface CustomerDaoMapper {
	    //所有查找订单的方法，要求查出来的订单的订单项集合属性，与收货地址属性都被赋值
		//所有查找订单项的方法，要求查出来的订单项的书籍属性被赋值
		/**
		 * 按照姓名查找顾客
		 * @param String name：顾客登录名
		 * @return Customer customer：查找到的顾客
		 * */
		public Customer findCustomerByName(String name) throws Exception;
		
		/**
		 * 添加用户
		 * @param user
		 * @throws Exception
		 */
		public void addCustomer(Customer user) throws Exception;
		
		
		//修改用户信息
		public void updateCustomer(Customer user) throws Exception;
		
		
		/**
		 * 保存顾客
		 * @param Customer customer:要保存的顾客对象
		 * */
		public void saveCustomer(Customer customer);
		/**
		 * 根据用户ID查找收货地址列表
		 * */
		public List<ShipAddress> findShipAddress(int customerId);
		/**
		 * 根据收货地址ID查找收货地址
		 * */
		public ShipAddress findShipAddressById(int shipId);
		/**
		 * 保存收货地址
		 * */
		public void saveShipAddress(ShipAddress shipAddress);
		/**
		 * 保存订单，订单入库
		 * */
		public void saveOrderForm(Order orderForm);
		/**
		 * 保存订单项
		 * */
		public void saveOrderLine(OrderLine orderLine);
		/**
		 * 根据用户ID查找用户所有订单,订单项与收获地址需要赋值
		 * */
		public List<Order> findAllOrderForm(int customerId);
		/**
		 * 根据订单编号查找订单项,书籍属性需要赋值
		 * */
		public List<OrderLine> findOrderLinesByOId(int orderFormId);
		/**
		 * 根据订单编号查找订单,订单项与收获地址需要赋值
		 * */
		public Order findOrderFormById(int orderFormId);
		/**
		 * 根据订单ID删除订单,同样对应的订单项也被删除
		 * */
		public void deleteOrderForm(int orderFormId);
		/**
		 * 根据订单Id删除订单项
		 * @param orderFormId
		 */
		public void deleteOrderLine(int orderFormId);
}
