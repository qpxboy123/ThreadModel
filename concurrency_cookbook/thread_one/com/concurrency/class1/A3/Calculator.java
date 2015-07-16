package com.concurrency.class1.A3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
/**
 * 线程信息的获取和设置
 * @author qpx
 * 线程有6中状态
 * ID： 该属性表示每个线程的唯一标识；
 * Name： 该属性存储每个线程的名称；
 * Priority： 该属性存储每个Thread对象的优先级。线程优先级分1到10十个级别，1表示最低优先级，10表示最高优先级。并不推荐修改线程的优先级，但是如果确实有这方面的需求，也可以尝试一下。
 * Status: 该属性存储线程的状态。线程共有六种不同的状态：新建（new）、运行（runnable）、阻塞（blocked）、等待（waiting）、限时等待（time waiting）或者终止（terminated）。线程的状态必定是其中一种。
 * 在本小节，我们将开发一个程序，程序中新建十个线程，并且设定每个线程的名称和优先级。然后执行线程，观察线程的状态信息，直到线程执行结束。再说明一点，这些线程还是计算一个数的乘法表
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
