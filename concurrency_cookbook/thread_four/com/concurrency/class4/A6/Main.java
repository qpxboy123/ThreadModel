package com.concurrency.class4.A6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 运行多个任务并处理所有结果
 * @author qpx
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Task> taskList = new ArrayList<>();
		for(int i=0;i<3;i++){
			Task task = new Task(i+"");
			taskList.add(task);
		}
		List<Future<Result>> resultList = null;
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main:Printing the results");
		for(int i=0;i<resultList.size();i++){
			Future<Result> futrue = resultList.get(i);
			Result result= futrue.get();
			System.out.println(result.getName()+": "+result.getValue()+"\n");
		}
	}
}
