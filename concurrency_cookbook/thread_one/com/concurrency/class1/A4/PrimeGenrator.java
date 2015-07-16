package com.concurrency.class1.A4;
/**
 * 1.4 �̵߳��ж�
 * @author qpx
 *
 */
public class PrimeGenrator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while(true){
			if(isPrime(number)){
				System.out.printf("Number %d is Prime\n",(int)number);
			}
			if(isInterrupted()){//����߳��Ƿ��жϣ�true ��ʾδ���ж� = Thread.isInterrupted() ���Ըı�interruted Ϊfalse��ǰ�߲��ܸı��Ƽ���ǰ��
				System.out.printf("The Prime Generator has been Interrrupted\n");
				return;
			}
			number ++;
		}
	}
	/**
	 * �ж��Ƿ�������
	 * @param number
	 * @return
	 */
	private boolean isPrime(long number) {
		if(number <=2 ){
			return true;
		}
		for(long i =2;i<number;i++){
			if((number % i) == 0){
				return false;
			}
			
		}
		return true;
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread task = new PrimeGenrator();
		task.start();
		Thread.sleep(5000);
		task.interrupt();
	}

}
