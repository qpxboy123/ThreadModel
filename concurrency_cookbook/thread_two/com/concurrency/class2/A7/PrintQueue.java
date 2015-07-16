package com.concurrency.class2.A7;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �޸����Ĺ�ƽ��
 * ReentrantLock ��ReentrantReadWriteLock ��Ĺ�������һ��boolean ���͵Ĳ���
 * fair �������п��������������Ϊ��
 * @author qpx
 *
 */
public class PrintQueue {

	//����������
	private final Lock queueLock = new ReentrantLock(true);
	//ʵ�ִ�ӡ���� printJob()
	public void printJob(Object document){
		try {
			/*���߳�A�����������ʱ�����û�������̻߳�ȡ��������Ŀ���
			/*Lock���������߳�Aȡ����������������ִ���ٽ������룬�������
			 * �����߳�B����ִ��������������ٽ������룬lock���������߳�A����֪���߳�B
			 * ִ�����ٽ����Ĵ���
			 */
			queueLock.lock();//��ȡ�����Ŀ���
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during "+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*
			 * �߳��뿪�ٽ�����ʱ�����Ǳ���ʹ��unLock()�������ͷ��������е��������������߳��������ٽ�����
			 * ���򽫻��������
			 */
			queueLock.unlock();
		}
		
		try {
			/*���߳�A�����������ʱ�����û�������̻߳�ȡ��������Ŀ���
			/*Lock���������߳�Aȡ����������������ִ���ٽ������룬�������
			 * �����߳�B����ִ��������������ٽ������룬lock���������߳�A����֪���߳�B
			 * ִ�����ٽ����Ĵ���
			 */
			queueLock.lock();//��ȡ�����Ŀ���
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during  "+(duration/1000)+"  seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*
			 * �߳��뿪�ٽ�����ʱ�����Ǳ���ʹ��unLock()�������ͷ��������е��������������߳��������ٽ�����
			 * ���򽫻��������
			 */
			queueLock.unlock();
		}
	}
	/**
	 * ReentrantLock �ṩ������һ����������ȡ������tryLock()
	 */


}
