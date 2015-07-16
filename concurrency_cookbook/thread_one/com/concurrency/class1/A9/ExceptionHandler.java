package com.concurrency.class1.A9;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * java ���������쳣
 * ������ʱ�쳣�������쳣�����ڷ���������throws �����ָ���������ڷ������ڲ���
 * ���磺IOException ��ClassNotFoundException
 * ����ʱ�쳣�������쳣�����ٷ���������ָ����Ҳ����Ҫ�ٷ����в������磺NumberFormatException��
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
