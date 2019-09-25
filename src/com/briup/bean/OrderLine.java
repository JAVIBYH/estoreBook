package com.briup.bean;

//订单明细类
public class OrderLine {
	private Integer id;
	private int num; //数量
	private Double cost;//金额
	private Book book;
	private Order order;
	
	public OrderLine() {}
	
	public OrderLine(int num, Double cost, Book book, Order order) {
		this.num = num;
		this.cost = cost;
		this.book = book;
		this.order = order;
	}
	
	public OrderLine(Integer id, int num, Double cost, Book book, Order order) {
		this.id = id;
		this.num = num;
		this.cost = cost;
		this.book = book;
		this.order = order;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}


 