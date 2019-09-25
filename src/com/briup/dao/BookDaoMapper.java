package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.exception.BookException;

/**
 * Dao层  商品
 * @author hjw
 *
 */
public interface BookDaoMapper {
	
	/**
	 * 查询所有一级菜单
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllOneCategory() throws Exception;
	
	/**
	 * 查询所有二级菜单
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllTwoCategory(int parentId) throws Exception;
	
	/**
	 * 查询所有图书
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAllBook() throws Exception;
	
	/**
	 * 根据图书id查询图书详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Book findBookById(int id) throws Exception;
	
	
	//查找所有的分类(一级分类)
	//List<Category> findAllCategory() throws BookException;
	
	//根据一级分类ID查找所有子分类
	//List<Category> findSubCategorys(int parentId) throws BookException;
	
	//根据分类ID查找此分类
	Category findCategoryById(int categoryId) throws BookException;
	//查找所有图书
	List<Book> findAllBooks() throws BookException;
	//查找一级分类下的图书
	List<Book> findBooksByCategoryOne(int categoryId) throws BookException;
	//查找二级分类下的图书
	List<Book> findBooksByCategoryTwo(int categoryId) throws BookException;
	//按照出版时间查询，查找前3名 可以变更查找条件
	List<Book> findNewBooks(int num) throws BookException;
	 
}
