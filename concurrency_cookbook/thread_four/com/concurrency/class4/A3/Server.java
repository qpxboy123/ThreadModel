package com.concurrency.class4.A3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * ��server �� �Ĺ������д���ThreadPoolExecutor ����ThreadPoolExexutor �����ĸ���ͬ�Ĺ�����
 * ������������Щ��������ʹ���ϵĸ����ԣ�java ����Api ͨ��Executors ������������ִ������������۵Ķ�����Ȼ����ֱ��ͨ��
 * ThreadPoolExecutor ����֮һ�Ĺ�����������ThreadPoolExecutor ���󣬵����Ƽ�ʹ�� Excutors ����������������
 * @author qpx
 *
 */
public class Server {
	private ThreadPoolExecutor execitor;
	
	//ʵ����Ĺ�������ͨ��Executors ������ʼ��ThreadPoolExecutor
	/**
	 * �����������һ��ExecutorService �������������ǿ��ת��ΪThreadPoolExcutor ���Ͳ�
	 * ӵ�����еķ����������Ҫִ�������񣬻����̳߳ؾͻᴴ�����̣߳�����߳������е�����������ɺ�������߳̿��ã�
	 * ��ô�����̳߳ػ�������Щ�̡߳��߳����õ��е���Ǽ����˴������߳������ѵ�ʱ�䣬Ȼ����������̶��������߳���ִ�У���˻����̳߳�Ҳ��ȷ����������͹���������ִ������
	 * ϵͳ�ĸ��ɽ�����ء�
	 * 
	 * �����̵߳������Ǻ���Ļ����߳�ֻ�����к̵ܶ�ʱ�䣬�ʺϲ���Excutors �������newCachedThreadPool() ����
	 * ������ִ����
	 * 
	 * һ��������ִ�������Ϳ���ʹ��ִ������execute��������������Runnable ���� Callable ���͵�����
	 * getPoolSize() ����ִ�����̳߳���ʵ�ʵ��߳���
	 * getActiveCount() ����ִ����������ִ��������߳���
	 * getCompletedTaskCount() ����ִ�����Ѿ���ɵ�������
	 * 
	 */
	public Server() {
		this.execitor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	
	public void executeTask(Task task){
		System.out.printf("Server:A new task has arrived\n");
		execitor.execute(task);
		System.out.printf("Server:pool Size:%d\n",execitor.getPoolSize());
		System.out.printf("Server:Active count :%d\n",execitor.getActiveCount());
		System.out.printf("Server:Complted Tasks:%s\n",execitor.getCompletedTaskCount());
		System.out.printf("Server:Task Count:%d\n",execitor.getTaskCount());
		
		
		
	}
	
	/**
	 * ��ִ����ִ��������д����е��������������ִ�С�����shutDown ����֮����������ڷ�����һ�������ִ���������񽫱��ܾ�������ִ����Ҳ���׳�rejectedExecutionException
	 * �쳣
	 */
	public void endServer(){
		execitor.shutdown();
	}
	
	
	
	

}
