package com.concurrency.class2.A6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		Iterator<String> its = a.iterator();
		while(its.hasNext()){
			if(its.next().equals("1")){
				its.remove();
			}
			
		}

		
		
		Map<String,String> maps = new HashMap<String,String>();
		maps.put("1", "1");
		maps.put("2", "2");
		Iterator<String> it = maps.keySet().iterator();
		while(it.hasNext()){
			System.out.println("key:"+it.next());		
			
		}
//		for(Object obj:maps.keySet()){
//			System.out.println("key:"+obj);		
//			System.out.println("value:"+maps.get(obj));
//		}
		
	}

}
