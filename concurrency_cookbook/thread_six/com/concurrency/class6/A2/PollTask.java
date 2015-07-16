package com.concurrency.class6.A2;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {

	private ConcurrentLinkedDeque<String> lists;
	public PollTask(ConcurrentLinkedDeque<String> lists) {
		super();
		this.lists = lists;
	}
	@Override
	public void run() {
		for(int i = 0;i<5000;i++){
			lists.pollFirst();
			lists.pollLast();
		}
	
}

}
