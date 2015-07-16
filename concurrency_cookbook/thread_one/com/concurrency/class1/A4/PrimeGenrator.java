package com.concurrency.class1.A4;
/**
 * 1.4 线程的中断
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
			if(isInterrupted()){//检查线程是否被中断，true 表示未被中断 = Thread.isInterrupted() 可以改变interruted 为false，前者不能改变推荐用前者
				System.out.printf("The Prime Generator has been Interrrupted\n");
				return;
			}
			number ++;
		}
	}
	/**
	 * 判断是否是质数
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
