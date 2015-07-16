package com.concurrency.class6.A2;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements  Runnable {
	
	private ConcurrentLinkedDeque<String> lists;
	
	
	public AddTask(ConcurrentLinkedDeque<String> lists) {
		this.lists = lists;
	}


	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i = 0;i<10000;i++){
			lists.add(name+":Element "+i);
		}
		
	}

}
