package com.briup.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.BookDaoMapper;
import com.briup.exception.BookException;
import com.briup.service.IBookService;

/**
 * 商品逻辑处理实现类
 * @author hjw
 *
 */
public class BookServiceImpl implements IBookService {
	
	/**
	 * 获取所有一级菜单
	 * */
	@Override
	public List<Category> listAllOneCategory() throws BookException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		List<Category> list = null;
		try {
			 list = bookDaoMapper.findAllOneCategory();
			 if(list==null){
				 throw new Exception("没有一级菜单项");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException(e.getMessage());
		}
		return list;
	}

	/**
	 * 获取所有二级菜单
	 * Map<Category, List<Category>>存储key为一级菜单，value为对应的二级菜单
	 */
	@Override
	public Map<Category, List<Category>> listAllTwoCategory() throws BookException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		List<Category> list1 = null;
		try {
			list1 = bookDaoMapper.findAllOneCategory();
			if(list1==null){
				throw new Exception("没有一级菜单");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<Category, List<Category>> map = new HashMap<Category, List<Category>>();
		List<Category> list2 = null;
		for(Category cate:list1){
			try {
				list2 = bookDaoMapper.findAllTwoCategory(cate.getId());
				if(list2==null){
					throw new Exception("没有二级菜单");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put(cate, list2);
		}
		return map;
	}
	
	//获取所有图书
	@Override
	public List<Book> listAllBook() throws BookException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		List<Book> books = null;
		try {
			 books = bookDaoMapper.findAllBook();
			if(books==null||books.equals("")){
				throw new Exception("数据库中没有书籍");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException(e.getMessage());
		}
		
		return books;
	}
	
	/**
	 * 根据图书id获取图书信息
	 */
	@Override
	public Book getBookById(int id) throws BookException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		Book book = null;
		try {
			book = bookDaoMapper.findBookById(id);
			if(book==null){
				throw new Exception("没有此图书");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException(e.getMessage());
		}
		return book;
	}

	
	
	
	
	
	//找到所有一级菜单
	@Override
	public List<Category> findCategoryList() throws BookException {
		/*SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		List<Category> list = bookDaoMapper.findAllCategory();
		List<Category> list1 = null;
		for(Category cate:list){
			list1 = bookDaoMapper.findSubCategorys(cate.getId());
			cate.setCategory_detail(list1);
			list.add(cate);
		}
		System.out.println("一二级菜单......");
		for(Category category:list){
			System.out.println(category);
		}
		return list;*/
		return null;
	}

	//找到所有二级菜单
	@Override
	public Category findCategoryById(int CategoryId) throws BookException {
		/*SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookDaoMapper bookDaoMapper = sqlSession.getMapper(BookDaoMapper.class);
		List<Category> list = bookDaoMapper.findSubCategorys(CategoryId);
		Category category = new Category();
		category.setId(CategoryId);
		category.setCategory_detail(list);
		return category;*/
		return null;
	}

	@Override
	public List<Book> findNewBooks(int num) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookByID(int bookId) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAllBooks() throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBookByCategoryId(int CategoryId, int mark)
			throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
