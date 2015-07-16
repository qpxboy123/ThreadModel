package com.concurrency.class4.A5;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

	private UserValidator userValidator;
	
	private String user;//用户名
	private String password;//密码
	
	
	
	public TaskValidator(UserValidator userValidator, String user,String password) {
		super();
		this.userValidator = userValidator;
		this.user = user;
		this.password = password;
	}



	@Override
	public String call() throws Exception {

		//如果用户没有通过UserValidator 对象的验证，就在控制台输出没有找到这个用户，表明该用户为通过验证
		// 并抛出 Exception
		
		if(!userValidator.validate(user, password)){
			System.out.printf("%s:The user has not been found\n",userValidator.getName());
			throw new Exception("Error validating user");
		}
		
		System.out.printf("%s:The user has been found\n",userValidator.getName());
		return userValidator.getName();
	}

}
