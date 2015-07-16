package com.concurrency.class1.A8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class Main {
//	public static void main(String[] args) throws InterruptedException {
//		Deque<Event> deque = new ArrayDeque<Event>();
//		WriterTask writer = new WriterTask(deque);
//		for(int i =0;i<3;i++){
//			Thread thread = new Thread(writer);
//			thread.start();
//		}
//		//Thread.sleep(10000);
//		System.out.println("deque size:"+deque.size());
//
//		CleanerTask cleanerTask = new CleanerTask(deque);
//		cleanerTask.start();
//	}
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));  
		Iterator<String> iter = list.iterator();  
		while (iter.hasNext()) {  
		    String s = iter.next();  
		   
		    if (s.equals("a")) {  
		        iter.remove();  
		    }  
		}  
		
		ArrayList<String> lis = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));  
		   
		for (String s : lis) {  
		    if (s.equals("a"))  
		        lis.remove(s);  
		}  
	}

}
