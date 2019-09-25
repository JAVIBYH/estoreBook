package com.briup.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @ClassName: ShoppingCar	购物车类 （订单项）
 *
 */
public class ShoppingCar {
	// key=商品id value=订单项（商品，数量）
	private Map<Integer, OrderLine> map = new HashMap<Integer, OrderLine>();
	
	/**
	 * 向购物车中添加产品
	 * 先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	 * 如果没有向map中添加
	 * @param line
	 */
	public void add(OrderLine line){
		if(map.containsKey(line.getBook().getId())){
			OrderLine oldline = map.get(line.getBook().getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getId(), line);
		}
	}
	/**
	 * 删除订单
	 */
	public void delete(Long bookId){
		map.remove(bookId);
	}
	/**
	 * 获取价钱
	 */
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			OrderLine value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	/**
	 * 获取购物车中所有订单项
	 * List<Line>
	 */
	public Map<Integer, OrderLine> getLines(){
		return map;
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * 修改指定line中的数量
	 */
	public void update(long key,int num){
		OrderLine line = map.get(key);
		if(line!=null){
			line.setNum(num);
		}
	}
	//获取购物车中一共有多少个物品
	public int getNum(){
		int num = 0;
		for(OrderLine line:map.values()) {
			num += line.getNum();
		}
		return num;
	}
	
}
