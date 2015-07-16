package com.concurrency.class1.A10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程局部变量的使用
 * @author qpx
 *
 */
public class UnsafeTask implements Runnable {
	private Date startDate;
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread %s:%s\n",Thread.currentThread().getId(),startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.random()*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Thread Finished:%s:%s\n",Thread.currentThread().getId(),startDate);
		
	}
	public static void main(String[] args) {
		UnsafeTask task = new UnsafeTask();
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
