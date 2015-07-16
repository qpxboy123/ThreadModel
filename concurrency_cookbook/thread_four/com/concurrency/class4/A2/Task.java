package com.concurrency.class4.A2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	private Date initDate;//�洢����Ĵ���ʱ��
	private String name;//�洢���������
	
	
	public Task(String name) {
		this.initDate = new Date();
		this.name = name;
	}


	@Override
	public void run() {
		
		//�ڿ���̨�� ��� initDate ���Ժ�ʵ��ʱ�䣬������Ŀ�ʼʱ��
		System.out.printf("%s:Task %s:Created on :%s\n",Thread.currentThread().getName(),name,initDate);
		System.out.printf("%s��Task %s:Started on:%s\n",Thread.currentThread().getName(),name,new Date());
		//����������һ�����ʱ��
		try {
			Long duration = (long)(Math.random()*10);
			System.out.printf("%s:Task %s:Doing a task during %s seconds\n",Thread.currentThread().getName(),name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�ڿ���̨������������ʱ��
		System.out.printf("%s:task %s : Finished on :%s\n",Thread.currentThread().getName(),name,new Date());
		
		
		
}
}