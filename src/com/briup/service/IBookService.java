package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.exception.BookException;

/**
 * 商品业务处理
 * @author hjw
 *
 */
public interface IBookService {
	
	/**
	 * 获取所有的一级菜单
	 * */
	public List<Category> listAllOneCategory() throws BookException;
	
	/**
	 * 获取所有的二级菜单
	 * */
	public Map<Category,List<Category>> listAllTwoCategory() throws BookException;
	
	/**
	 * 获取所有商品信息
	 * @return
	 * @throws BookException
	 */
	public List<Book> listAllBook() throws BookException;
	
	/**
	 * 根据图书id获取图书信息
	 * @param id
	 * @return
	 * @throws BookException
	 */
	public Book getBookById(int id) throws BookException;
	
	
	
	
	
	
	/**
	 * 查找所有一级分类及一级分类下的所有二级分类
	 * @return List:数据类型的集合
	 * */
	List<Category> findCategoryList() throws BookException;
	
	/**
	 * 查找二级分类
	 * */
	Category findCategoryById(int CategoryId) throws BookException;
	
	/**
	 * 查找最近出版的n本书
	 * */
	List<Book> findNewBooks(int num) throws BookException;
	/**
	 * 按照ID查找一本书
	 * */
	Book findBookByID(int bookId) throws BookException;
	/**
	 * 查找所有图书
	 * */
	List<Book> findAllBooks() throws BookException;
	/**
	 * 根据类型ID查找图书
	 * */
	List<Book> findBookByCategoryId(int CategoryId,int mark) throws BookException;
	
}
