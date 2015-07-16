package com.concurrency.class4.A2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	private Date initDate;//存储任务的创建时间
	private String name;//存储任务的名称
	
	
	public Task(String name) {
		this.initDate = new Date();
		this.name = name;
	}


	@Override
	public void run() {
		
		//在控制台上 输出 initDate 属性和实际时间，即任务的开始时间
		System.out.printf("%s:Task %s:Created on :%s\n",Thread.currentThread().getName(),name,initDate);
		System.out.printf("%s：Task %s:Started on:%s\n",Thread.currentThread().getName(),name,new Date());
		//将任务休眠一段随机时间
		try {
			Long duration = (long)(Math.random()*10);
			System.out.printf("%s:Task %s:Doing a task during %s seconds\n",Thread.currentThread().getName(),name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//在控制台输入任务的完成时间
		System.out.printf("%s:task %s : Finished on :%s\n",Thread.currentThread().getName(),name,new Date());
		
		
		
}
}