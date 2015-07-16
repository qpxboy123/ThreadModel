package com.concurrency.class2.A8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	
	LinkedList<String> buffer;
	int maxSize;
	ReentrantLock lock;//用来对修改buffer的代码快进行控制
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
	 * 将传入的字符串写入到缓冲区中。首先insert 获取锁，然后检查这个缓冲区是否还有空位
	 * 如果缓冲区满了，他将调用条件space 的await方法等待空位出现。当其他线程笤俑条件的soace 的
	 * signal 或者 signalAll 方法时，这个线程将被唤醒。有空位后，线程将会数据行保存到缓冲区中，
	 * 并且调用条件lines 的signallAll方法。一会我们会看到条件lines 将唤醒所有等待缓冲区中所有的数据
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
	 * 当生产者不产生薪的数据行时，线程将调用它
	 * @param pendingLines
	 */
	public void setPendingLines(boolean pendingLines){
		this.pendingLines = pendingLines;
	}
	
	
	/**
	 * 如果有数据行可以处理的话，返回true，否则返回false
	 * @return
	 */
	public boolean hasPendingLines() {
		return pendingLines || buffer.size()>0;
	}
	
}
