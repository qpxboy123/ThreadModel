package com.concurrency.class1.A13;

public class Main {

	/**
	 * 工作原理
	 * ThreadFactory 接口只有一个方法就是newThread，他以Runnable 接口对象作为传入
	 * 参数并且返回一个线程对象。当实现ThreadDFactory接口时，必须实现覆盖这个方法。大多数的线程工厂类只有一行，即return new Thread（r）
	 * 可以增加一些变化强化实现方法覆盖
	 * 创建个性化线程
	 * 保存新创建的线程的统计数据
	 * 限制创建线程的数量
	 * 对生成的线程进行验证
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread = null;
		System.out.println("Starting the Threads");
		for(int i = 0;i<10;i++){
			thread = threadFactory.newThread(task);
			thread.start();
		}
		System.out.println("Factory stats:");
		System.out.printf("%s\n",threadFactory.getStats());
	}

}
