package com.concurrency.class1.A6;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 线程的休眠和恢复
 * yield 方法通知jvm 这个线程对象可以释放cpu，jvm 不保证遵循这个要求，
 * 通常来说，yield 方法只做调试使用
 * @author qpx
 *
 */
public class FileClock implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.printf("%s\n",new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("The FileClock has been interrupted");
			}
		}
	}
	public static void main(String[] args) {
		FileClock fileClock = new FileClock();
		Thread thread = new Thread(fileClock);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
