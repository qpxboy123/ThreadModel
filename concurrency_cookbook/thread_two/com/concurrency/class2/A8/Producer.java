package com.concurrency.class2.A8;
/**
 * 生产者类Producer
 * @author qpx
 *
 */
public class Producer implements Runnable {
	private FileMock mock;
	private Buffer buff;
	
	
	
	public Producer(FileMock mock, Buffer buff) {
		super();
		this.mock = mock;
		this.buff = buff;
	}



	@Override
	public void run() {
		buff.setPendingLines(true);
		while(mock.hasMoreLines()){
			String line = mock.getLine();
			buff.insert(line);
		}
		buff.setPendingLines(false);
	}

}
