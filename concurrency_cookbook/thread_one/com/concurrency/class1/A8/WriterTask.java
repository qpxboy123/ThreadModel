package com.concurrency.class1.A8;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * �ػ����̵Ĵ���������
 * java ����һ��������߳̽����ػ� daemon�̣߳������̵߳����ȼ��ܵͣ�ͨ����˵����ͬһ��Ӧ�ó�����û���������߳����е�ʱ���ػ��̲߳����У����ػ��߳�
 * ���߳���Ψһ���е��߳�ʱ���ػ��߳�ִ�н�����j.v.m Ҳ�ͽ��������������
 * ��Ϊ�������ԣ��ػ��߳�ͨ����������Ϊͬһ��������ͨ�̵߳ķ����ṩ�ߣ�����ͨ��������ѭ���ģ��Եȴ������������ִ���̵߳��������ǲ���������Ҫ�Ĺ�����
 * ��Ϊ���ǲ�����֪���ػ��߳�ʲôʱ���ܻ�ȡc.p.uʱ�ӣ����ң���û�������߳����е�ʱ���ػ��߳���ʱ���ܽ�����һ�����͵��ػ��߳���java ������������
 * Garbage Collector
 * @author q.p.x
 *
 */
public class WriterTask implements Runnable {
	
	private Deque<Event> deque;
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}
	@Override
	public void run() {
		
		for(int i = 0;i<100;i++){
			Event evnet = new Event();
			evnet.setDate(new Date());
			evnet.setEvent(String.format("The thread %s has generated anevent", Thread.currentThread().getId()));
			deque.addFirst(evnet);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
