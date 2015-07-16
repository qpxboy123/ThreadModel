package com.concurrency.class1.A11;

import java.util.concurrent.TimeUnit;
/**
 * java ����API �ṩ��һ����Ȥ�Ĺ��ܣ����ܹ����̷߳��顣���������ǰ�һ������߳�
 * ����һ����һ�ĵ�Ԫ���������̶߳�����з��ʲ��Ҳ������ǣ����磬����һЩִ��ͬ��������̣߳������������
 * ,���ܶ����߳������У�ֻ��Ҫһ����һ�ĵ��ã�������Щ�̵߳����ж��ᱻ�жϡ�
 *  @author qpx
 *
 */
public class Main {
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for(int i = 0;i<5;i++){
			Thread thread = new Thread(threadGroup,searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Number of Threads:%d\n",threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		/*ͨ��activeCount()������ȡ�߳���������߳���Ŀ��ͨ��enumerate()������ȡ�߳���������߳��б�*/
		threadGroup.list();//list������������Լ�ÿ���̶߳����״̬
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for(int i = 0;i<threadGroup.activeCount();i++){
			System.out.printf("Thread %s:%s\n",threads[i].getName(),threads[i].getState());
		}
		try {
			waitFinish(threadGroup);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) throws InterruptedException {
		while(threadGroup.activeCount()>9){//activeCount ��������Ƿ����߳����н���.
			TimeUnit.SECONDS.sleep(1);
		}
	}

}
