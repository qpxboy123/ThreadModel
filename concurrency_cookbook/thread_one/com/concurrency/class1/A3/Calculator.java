package com.concurrency.class1.A3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
/**
 * �߳���Ϣ�Ļ�ȡ������
 * @author qpx
 * �߳���6��״̬
 * ID�� �����Ա�ʾÿ���̵߳�Ψһ��ʶ��
 * Name�� �����Դ洢ÿ���̵߳����ƣ�
 * Priority�� �����Դ洢ÿ��Thread��������ȼ����߳����ȼ���1��10ʮ������1��ʾ������ȼ���10��ʾ������ȼ��������Ƽ��޸��̵߳����ȼ����������ȷʵ���ⷽ�������Ҳ���Գ���һ�¡�
 * Status: �����Դ洢�̵߳�״̬���̹߳������ֲ�ͬ��״̬���½���new�������У�runnable����������blocked�����ȴ���waiting������ʱ�ȴ���time waiting��������ֹ��terminated�����̵߳�״̬�ض�������һ�֡�
 * �ڱ�С�ڣ����ǽ�����һ�����򣬳������½�ʮ���̣߳������趨ÿ���̵߳����ƺ����ȼ���Ȼ��ִ���̣߳��۲��̵߳�״̬��Ϣ��ֱ���߳�ִ�н�������˵��һ�㣬��Щ�̻߳��Ǽ���һ�����ĳ˷���
 *
 */
public class Calculator implements Runnable {
	private int number;
	
	public Calculator(int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		for(int i =1;i<=10;i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		for(int i = 0;i<10;i++){
			threads[i] = new Thread(new Calculator(i));
			if((i%2 == 0)){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
		}
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			 file = new FileWriter("E:\\data\\log.txt");
			 pw = new PrintWriter(file);
			for(int i = 0;i<10;i++){
				pw.printf("Main:Status of Thread %d : %s\n",i,threads[i].getState());
				status[i] = threads[i].getState();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.printf("***********************************************\n");

		for(int i = 0;i<10;i++){
			threads[i].start();
		}
		
		boolean finish = false;
		while(!finish){
			for(int i =0;i<10;i++){
				if(threads[i].getState()!=status[i]){
					writeThreadInfo(pw,threads[i],status[i]);
					status[i] = threads[i].getState();
					
				}
			}
			finish = true;
			for(int i = 0;i<10;i++){
				
				finish = finish && (threads[i].getState() == State.TERMINATED);
			}
			try {
				pw.close();
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private  static void writeThreadInfo(PrintWriter pw,Thread thread,State state){
		
		pw.printf("Main: Id %d - %s\n",thread.getId(),thread.getName());
		pw.printf("Main:Prioity: %d\n",thread.getPriority());
		pw.printf("Main:Old state:%s\n",state);
		pw.printf("Main:New state:%s\n",thread.getState());
		pw.printf("Main:***********************************\n");

		
	}
	
}
