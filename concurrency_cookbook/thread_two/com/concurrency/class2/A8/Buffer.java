package com.concurrency.class2.A8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	
	LinkedList<String> buffer;
	int maxSize;
	ReentrantLock lock;//�������޸�buffer�Ĵ������п���
	private Condition lines;
	private Condition sqace;
	private boolean pendingLines;
	public Buffer(int maxSize) {
		this.buffer = new LinkedList<String>();
		this.maxSize = maxSize;
		this.lock = new ReentrantLock();
		this.lines = lock.newCondition();
		this.sqace = lock.newCondition();
		this.pendingLines = true;
	} 
	/**
	 * ��������ַ���д�뵽�������С�����insert ��ȡ����Ȼ��������������Ƿ��п�λ
	 * ������������ˣ�������������space ��await�����ȴ���λ���֡��������߳���ٸ������soace ��
	 * signal ���� signalAll ����ʱ������߳̽������ѡ��п�λ���߳̽��������б��浽�������У�
	 * ���ҵ�������lines ��signallAll������һ�����ǻῴ������lines ���������еȴ������������е�����
	 * @param line
	 */
	public void insert(String line){
		lock.lock();
		while(buffer.size() == maxSize){
			try {
				sqace.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer.offer(line);
		System.out.printf("%s : Inserted Line: %d \n",Thread.currentThread().getName(),buffer.size());
		lines.signalAll();
		lock.unlock();
	}
	public String get(){
		String line = null;
		lock.lock();
		try{
			while((buffer.size()==0)&&hasPendingLines()){
				lines.await();
			}
			if(hasPendingLines()){
				line = buffer.poll();
				System.out.printf("%s : Line Reader : %d \n",Thread.currentThread().getName(),buffer.size());
				sqace.signalAll();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
		return line;
		
	}
	/**
	 * �������߲�����н��������ʱ���߳̽�������
	 * @param pendingLines
	 */
	public void setPendingLines(boolean pendingLines){
		this.pendingLines = pendingLines;
	}
	
	
	/**
	 * ����������п��Դ���Ļ�������true�����򷵻�false
	 * @return
	 */
	public boolean hasPendingLines() {
		return pendingLines || buffer.size()>0;
	}
	
}
