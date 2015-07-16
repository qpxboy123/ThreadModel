package com.concurrency.class4.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 运行多个任务并处理第一个结果
 * @author qpx
 *
 */
public class Main {
	public static void main(String[] args) {
		String userName = "test";
		String password ="test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator,userName,password);
		TaskValidator dbTask = new TaskValidator(dbValidator,userName,password);
		
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		String result=null;
		
		try {
			result = executor.invokeAny(taskList);//接收到那一个任务列表，然后运行任务，并返回一个完成任务并且没有抛出异常的任务的执行结果
			//这个方法返回的类型与任务里的call() 方法返回的类型相同，在这个范例中，他将返回String 类型值
			System.out.printf("Main:Result:%s\n",result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main:End of the Execution\n");
	}

}
