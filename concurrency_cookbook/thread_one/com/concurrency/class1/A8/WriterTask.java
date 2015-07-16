package com.concurrency.class1.A8;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 守护进程的创建和运行
 * java 里有一个特殊的线程叫做守护 daemon线程，种种线程的优先级很低，通常来说，当同一个应用程序留没有其他的线程运行的时候，守护线程才运行，当守护线程
 * 是线程中唯一运行的线程时，守护线程执行结束后，j.v.m 也就结束了了这个程序。
 * 因为这种特性，守护线程通常被用来作为同一程序中普通线程的服务提供者，他们通常是无限循环的，以等待服务请求或者执行线程的任务，他们不能做到重要的工作，
 * 因为我们不可能知道守护线程什么时候能获取c.p.u时钟，并且，在没有其他线程运行的时候，守护线程随时可能结束，一个典型的守护线程是java 的垃圾回收器
 * Garbage Collector
 * @author q.p.x
 *
 */
public class WriterTask implements Runnable {
	
	private Deque<Event> deque;
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}
	@Override
	public void run() {
		
		for(int i = 0;i<100;i++){
			Event evnet = new Event();
			evnet.setDate(new Date());
			evnet.setEvent(String.format("The thread %s has generated anevent", Thread.currentThread().getId()));
			deque.addFirst(evnet);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
