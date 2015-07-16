package com.concurrency.class2.A7;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 修改锁的公平性
 * ReentrantLock 和ReentrantReadWriteLock 类的构造器有一个boolean 类型的参数
 * fair 。他运行控制这两个类的行为。
 * @author qpx
 *
 */
public class PrintQueue {

	//声明锁对象
	private final Lock queueLock = new ReentrantLock(true);
	//实现打印方法 printJob()
	public void printJob(Object document){
		try {
			/*当线程A访问这个方法时，如果没有其他线程获取对这个锁的控制
			/*Lock方法将让线程A取得锁并且允许立刻执行临界区代码，否则，如果
			 * 其他线程B正在执行这个锁保护的临界区代码，lock方法将让线程A休眠知道线程B
			 * 执行完临界区的代码
			 */
			queueLock.lock();//获取对锁的控制
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during "+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*
			 * 线程离开临界区的时候，我们必须使用unLock()方法来释放他所持有的锁，以让其他线程来访问临界区。
			 * 否则将会出现死锁
			 */
			queueLock.unlock();
		}
		
		try {
			/*当线程A访问这个方法时，如果没有其他线程获取对这个锁的控制
			/*Lock方法将让线程A取得锁并且允许立刻执行临界区代码，否则，如果
			 * 其他线程B正在执行这个锁保护的临界区代码，lock方法将让线程A休眠知道线程B
			 * 执行完临界区的代码
			 */
			queueLock.lock();//获取对锁的控制
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during  "+(duration/1000)+"  seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*
			 * 线程离开临界区的时候，我们必须使用unLock()方法来释放他所持有的锁，以让其他线程来访问临界区。
			 * 否则将会出现死锁
			 */
			queueLock.unlock();
		}
	}
	/**
	 * ReentrantLock 提供了另外一个方法来获取锁，是tryLock()
	 */


}
