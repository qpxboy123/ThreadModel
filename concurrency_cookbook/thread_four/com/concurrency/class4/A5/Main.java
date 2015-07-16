package com.concurrency.class4.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ���ж�����񲢴����һ�����
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
			result = executor.invokeAny(taskList);//���յ���һ�������б�Ȼ���������񣬲�����һ�����������û���׳��쳣�������ִ�н��
			//����������ص��������������call() �������ص�������ͬ������������У���������String ����ֵ
			System.out.printf("Main:Result:%s\n",result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main:End of the Execution\n");
	}

}
