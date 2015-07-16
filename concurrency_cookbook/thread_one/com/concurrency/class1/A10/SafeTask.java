package com.concurrency.class1.A10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	/**
	 * �ֲ߳̾�����Ϊÿ���̴߳洢�˸��Ե�����ֵ�����ṩ��ÿ���߳�ʹ�á�
	 * ����߳��ǵ�һ�η����ֲ߳̾��������ֲ߳̾��������ܻ�û��Ϊ���洢ֵ�����ʱ��initailValue �����ͻᱻ���ã����ҷ��ص�ǰ��ʱ��ֵ��
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
