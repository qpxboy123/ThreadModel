package com.concurrency.class2.A6;

public class Write implements Runnable {
	
	private PricesInfo pricesInfo;
	
	
	public Write(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}


	@Override
	public void run() {
		for(int i = 0;i<3;i++){
			System.out.printf("%s Writer:Attempt to modify the prices.\n",Thread.currentThread().getName()+"_"+i);
			pricesInfo.setPrices(Math.random()*10, Math.random()*8);
			System.out.printf("%s Writer:prices have been modified.\n",Thread.currentThread().getName()+"_"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
