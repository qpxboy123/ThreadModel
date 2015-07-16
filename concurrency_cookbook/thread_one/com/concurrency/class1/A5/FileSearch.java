package com.concurrency.class1.A5;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 线程中断的控制
 * @author qpx
 *
 */
public class FileSearch implements Runnable{
	private String initPath;
	private String fileName;
	
	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	public void run(){
		try {
			File file = new File(initPath);
			if(file.isDirectory()){
				directoryProcess(file);
				
				
			}
//			//jdk 7 写法
//			Path path = Paths.get(initPath);
//			if(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)){
//				directoryProcess(path);
//			}
		}catch(InterruptedException e){
			System.out.printf("%s:The search has been interrupted,",Thread.currentThread().getName());
		}
		
	}

//	private void directoryProcess(Path path) {
//		
//	}

	private void directoryProcess(File file) throws InterruptedException {
		File[] list = file.listFiles();
		if(list != null){
			for(int i = 0;i<list.length;i++){
				if(list[i].isDirectory()){
					directoryProcess(list[i]);
				}else{
					fileProcess(list[i]);
				}
			}
		}
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {
		if(file.getName().equals(fileName)){
			System.out.printf("%s : %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}
	public static void main(String[] args) {
		FileSearch searcher = new FileSearch("F:\\","catalina.properties");
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
