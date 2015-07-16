package com.concurrency.class1.A6;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * �̵߳����ߺͻָ�
 * yield ����֪ͨjvm ����̶߳�������ͷ�cpu��jvm ����֤��ѭ���Ҫ��
 * ͨ����˵��yield ����ֻ������ʹ��
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
