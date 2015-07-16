package com.concurrency.class1.A12;

import java.util.Random;

public class Task implements Runnable {

	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while(true){
			result = 1000/((int)(random.nextDouble()*1000));
			System.out.printf("%s:%d\n",Thread.currentThread().getId(),result);
			if(Thread.currentThread().isInterrupted()){
				System.out.printf("%d:Interrupted\n",Thread.currentThread().getId());
				return;
			}
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		Task task = new Task();
		for(int i = 0;i<2;i++){
			Thread t = new Thread(threadGroup,task);
			t.start();
		}
	}


}
