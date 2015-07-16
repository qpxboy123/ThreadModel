package com.concurrency.class1.A12;
/**
 * �߳����в��ɿ��쳣�Ĵ���
 * @author qpx
 *
 */
public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}
	/**
	 * ԭ�����
	 * ���߳��׳��쳣ʱ��jvm��Ϊ����쳣Ѱ��3�п��ܵĴ�����
	 * ���ȣ�Ѱ���׳�����쳣���̵߳ķǲ����쳣����������UncaughtExceptionHandler�����������쳣�����������ڣ�jvm����Ѱ������߳����ڵ��߳���
	 * �ķǲ����쳣��������Ҳ������������Ĵ����������Ҳ������ jvm��Ѱ�ҷǲ����쳣��������
	 * �����Щ�������ڣ�jvm���Ѷ�ջ���쳣��Ϣ��ӡ������̨�������˳��������
	 * �ܽ���� �̶߳����쳣������--->�߳����쳣������--->jvmĬ���쳣
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n",t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}

	
}
