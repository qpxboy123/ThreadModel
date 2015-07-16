package com.concurrency.class1.A13;

public class Main {

	/**
	 * ����ԭ��
	 * ThreadFactory �ӿ�ֻ��һ����������newThread������Runnable �ӿڶ�����Ϊ����
	 * �������ҷ���һ���̶߳��󡣵�ʵ��ThreadDFactory�ӿ�ʱ������ʵ�ָ��������������������̹߳�����ֻ��һ�У���return new Thread��r��
	 * ��������һЩ�仯ǿ��ʵ�ַ�������
	 * �������Ի��߳�
	 * �����´������̵߳�ͳ������
	 * ���ƴ����̵߳�����
	 * �����ɵ��߳̽�����֤
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread = null;
		System.out.println("Starting the Threads");
		for(int i = 0;i<10;i++){
			thread = threadFactory.newThread(task);
			thread.start();
		}
		System.out.println("Factory stats:");
		System.out.printf("%s\n",threadFactory.getStats());
	}

}
