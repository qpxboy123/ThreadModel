package com.concurrency.class6.A3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	public static void main(String[] args) {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>(3);
		
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		for(int i = 0;i<5;i++){
			
			String request="";
			try {
				request = list.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("Main: Request:%s at %s.Size:%d\n",request,new Date(),list.size());
		}
		System.out.printf("Main:End of the program.\n");
	}

}
