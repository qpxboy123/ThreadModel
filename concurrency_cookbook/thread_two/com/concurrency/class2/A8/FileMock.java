package com.concurrency.class2.A8;
/**
 * 文本文件模拟类
 * @author qpx
 *
 */
public class FileMock {
	private String content[];//存储文件的内容
	private int index;//表示要从这个文件读取的内容的行号
	public FileMock(int size, int length) {
		content = new String[size];
		for(int i = 0;i<length;i++){
			StringBuilder buffer = new StringBuilder();
			for(int j = 0;j<length;j++){
				
				int indice = (int)(Math.random()*255);
				buffer.append((char)indice);
				content[i] = buffer.toString();
			}
		}
		index=0;

	}
	
	/**
	 * 如果文件有可以处理的数据行则返回true，如果到达模拟文件的结尾则返回false
	 * @return
	 */
	public boolean hasMoreLines(){
		return index<content.length;
	}
	/**
	 * 返回属性index 指定的行内容，并且将index 自动增加1.
	 * @return
	 */
	public String getLine(){
		if(this.hasMoreLines()){
			System.out.printf("Mock:"+(content.length-index));
			return content[index++];
			
		}
		return null;
	}
}
