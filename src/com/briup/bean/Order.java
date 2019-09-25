package com.briup.bean;

import java.util.Date;
import java.util.List;


//订单类
public class Order {
	private Integer id;
	private Double cost;//订单金额
	private Date orderDate;
	private Customer customer;
	private List<OrderLine> orderLines;
	
	public Order() {}
	public Order(Double cost, Date orderDate, Customer customer) {
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Order(Integer id, Double cost, Date orderDate, Customer customer) {
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}
