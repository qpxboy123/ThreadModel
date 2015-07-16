package com.concurrency.class1.A12;
/**
 * 线程组中不可控异常的处理
 * @author qpx
 *
 */
public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}
	/**
	 * 原理解析
	 * 当线程抛出异常时，jvm将为这个异常寻找3中可能的处理器
	 * 首先，寻找抛出这个异常的线程的非捕获异常处理器，（UncaughtExceptionHandler）如果，这个异常处理器不存在，jvm继续寻找这个线程所在的线程组
	 * 的非捕获异常处理器，也就是这个方法的处理器，如果也不存在 jvm将寻找非捕获异常处理器。
	 * 如果这些都不存在，jvm将把堆栈中异常信息打印到控制台，并且退出这个程序。
	 * 总结就是 线程对象异常处理器--->线程组异常处理器--->jvm默认异常
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n",t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}

	
}
