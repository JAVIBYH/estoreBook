package com.briup.exception;

/**
 * 自定义异常  顾客
 * @author hjw
 *
 */
public class CustomerException extends Exception {
	private static final long serialVersionUID = 3436322053486359031L;

	public CustomerException() {
		// TODO Auto-generated constructor stub
	}

	public CustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CustomerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
