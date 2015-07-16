package com.concurrency.class6.A2;

import java.util.concurrent.ConcurrentLinkedDeque;
/**
 * 使用非堵塞式线程安全列表
 * @author zj
 *
 */
public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();
		Thread threads[] = new Thread[100];
		for(int i = 0;i<threads.length;i++){
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main:%d AddTask threads have been Launched\n",threads.length);
		
		for(int i = 0;i<threads.length;i++){
			
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main:size of the List :%d\n",list.size());
		
		
		for(int i=0;i<threads.length;i++){
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		System.out.printf("Main:%d PollTask threads have beean lunched\n",threads.length);
		
		for(int i=0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Main:size of the size %d\n",list.size());
	}

}
