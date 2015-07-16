package com.concurrency.class1.A10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	/**
	 * 线程局部变量为每个线程存储了各自的属性值，并提供给每个线程使用。
	 * 如果线程是第一次访问线程局部变量，线程局部变量可能还没有为他存储值，这个时候initailValue 方法就会被调用，并且返回当前的时间值。
	 */
	private  ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	@Override
	public void run() {
		System.out.printf("Starting Thread:%s:%s\n",Thread.currentThread().getId(),startDate.get());
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Starting Thread:%s:%s\n",Thread.currentThread().getId(),startDate.get());

	}
	public static void main(String[] args) {
		SafeTask task = new SafeTask();
		for(int i = 0;i<10;i++){
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
