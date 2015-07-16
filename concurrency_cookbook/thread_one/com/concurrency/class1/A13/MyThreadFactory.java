package com.concurrency.class1.A13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
/**
 * 使用工厂类创建线程
 * 使用工厂类，可以将对象的创建集中化，这样做有以下的好处
 * 1、更容易修改类，或者改变创建对象的方式
 * 2、更容易为有限资源限制创建对象的数目。例如我们可以限制一个类型的对象不能多于n个
 * 3、更容易为创建的对象生产统计数据
 * @author qpx
 *
 */
public class MyThreadFactory implements ThreadFactory {
	private int counter;//存储线程对象的数量
	private String name;//存放每个线程的名称
	private List<String> stats;//存放线程对象的统计数据
	public MyThreadFactory(String name){
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t  = new Thread(r,name+"-Thread_"+counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(),t.getName(),new Date()));
		
		return t;
	}
	/**
	 * 
	 * @return
	 */
	public String getStats() {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while(it.hasNext()){
			buffer.append(it.next());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}
