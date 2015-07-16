package com.concurrency.class2.A8;
/**
 * 在锁中使用多条件
 * 一个锁可能关联一个或者多个条件，这些条件通过Condition接口声明。目的就是允许
 * 线程获取锁并且查看等待的某一个条件是否满足，如果不满足就挂起直到某个线程唤醒他们。
 * Condition接口提供了挂起和唤醒线程的机制
 * 并发编程中的一个典型问题是生产者-消费者 问题。
 * @author qpx
 *
 */
public class Main {
	
	public static void main(String[] args) {
		//创建文件类
		FileMock fileMock = new FileMock(100, 10);
		//创建缓冲区
		Buffer buffer =new Buffer(20);
		//创建一个生产者对象Produceer 。并将他作为传入参数创建线程
		Producer producer = new Producer(fileMock, buffer);
		Thread threadProducer = new Thread(producer,"Producer");
		
		//创建一个消费者对象Consumer ,并将它作为传入参数创建线程
		Consumer consumer[] = new Consumer[3];
		Thread threadConsumer[] = new Thread[3];
		for(int i = 0;i<3;i++){
			consumer[i] = new Consumer(buffer);
			threadConsumer[i] = new Thread(consumer[i],"Consumer"+i);
		}
		threadProducer.start();
		for(int i = 0;i<3;i++){
			threadConsumer[i].start();
			
		}
		
	}

}
