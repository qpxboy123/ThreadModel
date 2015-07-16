package com.concurrency.class2.A8;

import java.util.Random;

/**
 * 消费者类Consumer
 * @author qpx
 *
 */
public class Consumer implements Runnable {
	private Buffer buffer;
	
	
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}


	@Override
	public void run() {
		while(buffer.hasPendingLines()){
			String line = buffer.get();
			processLine(line);
		}
		
	}


	public void processLine(String line) {
		try{
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
