package com.concurrency.class2.A2;

import java.util.concurrent.TimeUnit;

/**
 * �˺���
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
	 * ��������������뵽���balance �У�������ͬһʱ��
	 * ֻ����һ���̸߳ı����ֵ��
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
	 * �۳����
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
