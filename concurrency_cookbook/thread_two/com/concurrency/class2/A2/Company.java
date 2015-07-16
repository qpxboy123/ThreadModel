package com.concurrency.class2.A2;
/**
 * 公司模拟类
 * @author qpx
 *
 */
public class Company implements Runnable {
	private Account account;
	public Company(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			account.addBalance(1000);
		}
	}

}
