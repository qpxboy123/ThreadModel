package com.concurrency.class1.A11;

import java.util.concurrent.TimeUnit;
/**
 * java 并发API 提供了一个有趣的功能，它能够把线程分组。这允许我们把一个组的线程
 * 当成一个单一的单元，对组内线程对象进行访问并且操作它们，例如，对于一些执行同样任务的线程，你想控制他们
 * ,不管多少线程在运行，只需要一个单一的调用，所有这些线程的运行都会被中断。
 *  @author qpx
 *
 */
public class Main {
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for(int i = 0;i<5;i++){
			Thread thread = new Thread(threadGroup,searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Number of Threads:%d\n",threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		/*通过activeCount()方法获取线程组包含的线程数目，通过enumerate()方法获取线程组包含的线程列表。*/
		threadGroup.list();//list方法的输出，以及每个线程对象的状态
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for(int i = 0;i<threadGroup.activeCount();i++){
			System.out.printf("Thread %s:%s\n",threads[i].getName(),threads[i].getState());
		}
		try {
			waitFinish(threadGroup);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) throws InterruptedException {
		while(threadGroup.activeCount()>9){//activeCount 用来检测是否有线程运行结束.
			TimeUnit.SECONDS.sleep(1);
		}
	}

}
