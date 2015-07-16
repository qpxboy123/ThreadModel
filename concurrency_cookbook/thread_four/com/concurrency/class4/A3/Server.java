package com.concurrency.class4.A3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 在server 类 的构造器中创建ThreadPoolExecutor 对象。ThreadPoolExexutor 类有四个不同的构造器
 * ，但是由于这些构造器在使用上的复杂性，java 并发Api 通过Executors 工厂类来构造执行器和其他香港的对象，虽然可以直接通过
 * ThreadPoolExecutor 其中之一的构造器来创建ThreadPoolExecutor 对象，但是推荐使用 Excutors 工厂类来创建他。
 * @author qpx
 *
 */
public class Server {
	private ThreadPoolExecutor execitor;
	
	//实现类的构造器，通过Executors 类来初始化ThreadPoolExecutor
	/**
	 * 这个方法返回一个ExecutorService 对象，因此他将被强制转换为ThreadPoolExcutor 类型并
	 * 拥有所有的方法，如果需要执行新任务，缓冲线程池就会创建新线程，如果线程锁运行的任务心智完成后并且这个线程可用，
	 * 那么缓存线程池会重用这些线程。线程重用的有点就是减少了创建新线程锁话费的时间，然而，新任务固定会依赖线程来执行，因此缓存线程池也有确定，如果发送过多的任务给执行器，
	 * 系统的负荷将会过载。
	 * 
	 * 尽当线程的数量是合理的或者线程只会运行很短的时间，适合采用Excutors 工厂类的newCachedThreadPool() 方法
	 * 来创建执行器
	 * 
	 * 一旦创建了执行器，就可以使用执行器的execute（）方法来发送Runnable 或者 Callable 类型的任务。
	 * getPoolSize() 返回执行器线程池中实际的线程数
	 * getActiveCount() 返回执行器中正在执行任务的线程数
	 * getCompletedTaskCount() 返回执行器已经完成的任务数
	 * 
	 */
	public Server() {
		this.execitor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	
	public void executeTask(Task task){
		System.out.printf("Server:A new task has arrived\n");
		execitor.execute(task);
		System.out.printf("Server:pool Size:%d\n",execitor.getPoolSize());
		System.out.printf("Server:Active count :%d\n",execitor.getActiveCount());
		System.out.printf("Server:Complted Tasks:%s\n",execitor.getCompletedTaskCount());
		System.out.printf("Server:Task Count:%d\n",execitor.getTaskCount());
		
		
		
	}
	
	/**
	 * 当执行器执行完成所有待运行的任务后，他将结束执行。调用shutDown 方法之后，如果尝试在发送另一个任务给执行器，任务将被拒绝，并且执行器也将抛出rejectedExecutionException
	 * 异常
	 */
	public void endServer(){
		execitor.shutdown();
	}
	
	
	
	

}
