package com.concurrency.class1.A9;

public class Task implements Runnable {

	@Override
	public void run() {
		int numnero = Integer.parseInt("TTT");
	}
	/**
	 * 1����һ���߳��׳����쳣����û�б𲶻�ʱ��jvm �������߳��Ƿ�Ԥ����δ�����쳣��������
	 * ������ҵ���jvm�������̶߳������������������̶߳�����쳣��Ϊ���������
	 * ����߳�û�б�Ԥ��δ�����쳣��������jvm ����ӡ��ջ��¼������̨�����˳�����
	 * 2��Thread �໹��һ���������Դ���Ϊ���񵽵��쳣������̬���� setDefaultUncaughtExceptionHandler().
	 * ���������Ӧ�ó�����Ϊ���е��̶߳��󴴽���һ���쳣��������
	 * ���߳��׳�һ��δ���񵽵��쳣ʱ��jvm ��Ϊ�쳣Ѱ��һ�����ֿ��ܵĴ�������
	 * ���ȣ��������̶߳����δ�����쳣������������Ҳ�����jvm���������̶߳������ڵ��߳����δ�����쳣���������⽫�� �߳����в��ɿ��쳣�Ĵ���
	 * һ���н��⣬��������Ҳ�������ͬ���������ģ�jvm����������Ĭ�ϵ�Ϊ�����쳣��������
	 * ���û��һ�����������ڣ�jvm�򽫶�ջ�쳣��¼��ӡ������̨�������˳�����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
