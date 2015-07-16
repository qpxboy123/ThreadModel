package com.concurrency.class2.A2;

import java.util.concurrent.TimeUnit;

/**
 * 账号类
 * @author qpx
 *
 */
public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 将传入的数量加入到余额balance 中，并且在同一时间
	 * 只允许一个线程改变这个值。
	 * @param amount
	 */
	public synchronized void addBalance(double amount){
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp+=amount;
		balance = tmp;
	}
	/**
	 * 扣除金额
	 * @param amount
	 */
	public synchronized void subtractAmount(double amount){
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}

}
