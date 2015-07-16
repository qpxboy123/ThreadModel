package com.concurrency.class4.A5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	
	private String name;//存储用户验证系统的名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean validate(String name,String password){
		//等待一段时间来模拟用户验证的过程
		Random random =new Random();
		long duration = (long)(Math.random()*10);
		System.out.printf("Validator %s:Validating a user during %d seconds\n",this.name,duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return false;
		}
		//返回随机的boolean 值。当用户通过验证时，这个方法返回true值，如果用户没有通过验证则返回false值
		return random.nextBoolean();
	}

	public UserValidator(String name) {
		super();
		this.name = name;
	}
	

}
