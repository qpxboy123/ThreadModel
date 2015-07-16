package com.concurrency.class4.A5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	
	private String name;//�洢�û���֤ϵͳ������

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean validate(String name,String password){
		//�ȴ�һ��ʱ����ģ���û���֤�Ĺ���
		Random random =new Random();
		long duration = (long)(Math.random()*10);
		System.out.printf("Validator %s:Validating a user during %d seconds\n",this.name,duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return false;
		}
		//���������boolean ֵ�����û�ͨ����֤ʱ�������������trueֵ������û�û��ͨ����֤�򷵻�falseֵ
		return random.nextBoolean();
	}

	public UserValidator(String name) {
		super();
		this.name = name;
	}
	

}
