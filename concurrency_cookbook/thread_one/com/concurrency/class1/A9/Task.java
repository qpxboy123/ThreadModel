package com.concurrency.class1.A9;

public class Task implements Runnable {

	@Override
	public void run() {
		int numnero = Integer.parseInt("TTT");
	}
	/**
	 * 1、当一个线程抛出了异常并且没有别捕获时，jvm 检查这个线程是否被预置了未捕获异常处理器。
	 * 如果能找到，jvm姜调用线程对象的这个方法，并将线程对象和异常作为传入参数。
	 * 如果线程没有被预置未捕获异常处理器，jvm 姜打印堆栈记录到控制台，并退出程序。
	 * 2、Thread 类还有一个方法可以处理为捕获到的异常，即静态方法 setDefaultUncaughtExceptionHandler().
	 * 这个方法在应用程序中为所有的线程对象创建了一个异常处理器。
	 * 当线程抛出一个未捕获到的异常时，jvm 将为异常寻找一下三种可能的处理器。
	 * 首先，它查找线程对象的未捕获异常处理器。如果找不到，jvm继续查找线程对象所在的线程组的未捕获异常处理器，这将在 线程组中不可控异常的处理
	 * 一节中讲解，如果还是找不到，如同本节所讲的，jvm将继续查找默认的为捕获异常处理器。
	 * 如果没有一个处理器存在，jvm则将堆栈异常记录打印到控制台，并且退出程序。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
