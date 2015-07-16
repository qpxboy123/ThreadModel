package com.concurrency.class1.A13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
/**
 * ʹ�ù����ഴ���߳�
 * ʹ�ù����࣬���Խ�����Ĵ������л��������������µĺô�
 * 1���������޸��࣬���߸ı䴴������ķ�ʽ
 * 2��������Ϊ������Դ���ƴ����������Ŀ���������ǿ�������һ�����͵Ķ����ܶ���n��
 * 3��������Ϊ�����Ķ�������ͳ������
 * @author qpx
 *
 */
public class MyThreadFactory implements ThreadFactory {
	private int counter;//�洢�̶߳��������
	private String name;//���ÿ���̵߳�����
	private List<String> stats;//����̶߳����ͳ������
	public MyThreadFactory(String name){
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t  = new Thread(r,name+"-Thread_"+counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(),t.getName(),new Date()));
		
		return t;
	}
	/**
	 * 
	 * @return
	 */
	public String getStats() {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while(it.hasNext()){
			buffer.append(it.next());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}
