package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.bean.ShipAddress;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.CustomerDaoMapper;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;

/**
 * 业务处理service实现类
 * @author hjw
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	/**
	 * 登录
	 */
	@Override
	public Customer login(String name, String password) throws CustomerException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerDaoMapper customerDao = sqlSession.getMapper(CustomerDaoMapper.class);
		Customer customer = null;
		try {
			customer = customerDao.findCustomerByName(name);
			if(customer==null){
				throw new Exception("用户不存在");
			} else if (!password.equals(customer.getPassword())) {
				throw new Exception("用户名或密码不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		return customer;
	}

	/**
	 * 注册
	 */
	@Override
	public void register(Customer customer) throws CustomerException {
		customer.setDob(new Date());
		Customer c = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.openSession();
			CustomerDaoMapper customerDaoMapper = sqlSession.getMapper(CustomerDaoMapper.class);
			c = customerDaoMapper.findCustomerByName(customer.getName());
			if(c==null){
				customerDaoMapper.addCustomer(customer);
			} else {
				throw new Exception("用户名被占用!");
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new CustomerException(e.getMessage());
		}
		
		
	}

	@Override
	public List<ShipAddress> findShipAddress(int customerId)
			throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipAddress findShipAddressById(int shipId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveShipAddress(ShipAddress shipAddress)
			throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrder(Order orderForm) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findAllOrderForm(int customerId)
			throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderFormById(int orderFormId)
			throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrderForm(int orderFormId) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

}
