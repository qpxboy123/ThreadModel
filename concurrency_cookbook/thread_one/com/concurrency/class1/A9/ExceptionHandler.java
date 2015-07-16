package com.concurrency.class1.A9;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * java 中有两种异常
 * 非运行时异常：这种异常必须在方法声明的throws 语句中指定，或者在方法体内捕获。
 * 例如：IOException 和ClassNotFoundException
 * 运行时异常：这种异常不必再方法声明中指定，也不需要再方法中捕获例如：NumberFormatException。
 * @author qpx
 *
 */
public class ExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread:%s\n",t.getId());
		System.out.printf("Exception:%s%s\n",e.getClass().getName(),e.getMessage());
		System.out.printf("stack Trace:\n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status:%s\n",t.getState());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
