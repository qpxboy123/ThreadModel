package com.concurrency.class2.A4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 在同步代码中使用条件
 * 生产者-消费者
 * 存储类
 * @author qpx
 *
 */
public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	public EventStorage() {
		this.maxSize = 10;
		this.storage = new LinkedList<>();
	}
	/**
	 * 
	 */
	public synchronized void set(){
		while(storage.size()==maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.printf("Set:%d\n",storage.size());
		notifyAll();
		
	}
	public synchronized void get(){
		while(storage.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get:%d:%s\n",storage.size(),((LinkedList<?>)storage).poll());
		notifyAll();
		
	}

}
