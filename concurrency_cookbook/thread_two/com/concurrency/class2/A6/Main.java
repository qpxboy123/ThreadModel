package com.concurrency.class2.
A6;
/**
 * 使用读写锁显示同步数据访问 ReadWriteLock
 * @author qpx
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo();
		Reader reader[] = new Reader[5];
		Thread threadReader[] = new Thread[5];
		for(int i = 0;i<5;i++){
			reader[i] = new Reader(pricesInfo);
			threadReader[i] = new Thread(reader[i]);
		}
		
		Write write = new Write(pricesInfo);
		Thread threadWrite = new Thread(write);
		
		for(int i = 0;i<5;i++){
			threadReader[i].start();
		}
		threadWrite.start();
	}
	
}
