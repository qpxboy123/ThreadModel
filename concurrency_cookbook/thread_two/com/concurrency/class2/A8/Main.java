package com.concurrency.class2.A8;
/**
 * ������ʹ�ö�����
 * һ�������ܹ���һ�����߶����������Щ����ͨ��Condition�ӿ�������Ŀ�ľ�������
 * �̻߳�ȡ�����Ҳ鿴�ȴ���ĳһ�������Ƿ����㣬���������͹���ֱ��ĳ���̻߳������ǡ�
 * Condition�ӿ��ṩ�˹���ͻ����̵߳Ļ���
 * ��������е�һ������������������-������ ���⡣
 * @author qpx
 *
 */
public class Main {
	
	public static void main(String[] args) {
		//�����ļ���
		FileMock fileMock = new FileMock(100, 10);
		//����������
		Buffer buffer =new Buffer(20);
		//����һ�������߶���Produceer ����������Ϊ������������߳�
		Producer producer = new Producer(fileMock, buffer);
		Thread threadProducer = new Thread(producer,"Producer");
		
		//����һ�������߶���Consumer ,��������Ϊ������������߳�
		Consumer consumer[] = new Consumer[3];
		Thread threadConsumer[] = new Thread[3];
		for(int i = 0;i<3;i++){
			consumer[i] = new Consumer(buffer);
			threadConsumer[i] = new Thread(consumer[i],"Consumer"+i);
		}
		threadProducer.start();
		for(int i = 0;i<3;i++){
			threadConsumer[i].start();
			
		}
		
	}

}
