package com.concurrency.class1.A7;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 等待线程的终止
 * @author qpx
 *
 */
public class NetWorkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("NetWorkConnectionsLoader Beginning data sources loading %s\n",new Date());
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("NetWorkConnectionsLoader Data sources loading has finished:%s\n",new Date());
	}
	public static void main(String[] args) throws InterruptedException {
		DataSourcesLoader ds = new DataSourcesLoader();
		Thread thread1 = new Thread(ds,"DateSourceThread");
		NetWorkConnectionsLoader net = new NetWorkConnectionsLoader();
		Thread thread2 = new Thread(net,"NetWorkConnectionsLoader");
		thread1.start();
		thread2.start();
		System.out.println("***********");
		
//		thread1.join();
//		thread2.join();
		
		System.out.println("0000");
		
	}

}
