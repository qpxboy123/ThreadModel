package com.concurrency.class6.A3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author zj
 *
 */
public class Client implements Runnable {
	private LinkedBlockingDeque<String> requestList;
	
	
	public Client(LinkedBlockingDeque<String> requestList) {
		super();
		this.requestList = requestList;
	}


	@Override
	public void run() {
		for(int i = 0;i<3;i++){
			for(int j = 0;j<5;j++){
				StringBuffer request = new StringBuffer();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestList.put(request.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Clieent:%s at %s.\n",request,new Date());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.printf("Client:End.\n");
	}

}
