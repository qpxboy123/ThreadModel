package com.concurrency.class2.A6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 价格信息类PricesInfo
 * @author qpx
 *
 */
public class PricesInfo {
	private double price1;
	private double price2;
	
	private ReadWriteLock lock;

	public PricesInfo() {
		this.price1 = 1D;
		this.price2 = 2D;
		lock = new ReentrantReadWriteLock();
	}
	/**
	 * 使用读锁来获取对这个属性的访问
	 * @return
	 */
	public double getPrice1(){
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}
	
	public double getPrice2(){
		lock.readLock().lock();
		double value = price2;
		lock.readLock().unlock();
		return value;
	}
	
	public void setPrices(double price1,double price2){
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
		
	}
	
}
