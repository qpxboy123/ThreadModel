package com.concurrency.class2.A8;
/**
 * �ı��ļ�ģ����
 * @author qpx
 *
 */
public class FileMock {
	private String content[];//�洢�ļ�������
	private int index;//��ʾҪ������ļ���ȡ�����ݵ��к�
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
	 * ����ļ��п��Դ�����������򷵻�true���������ģ���ļ��Ľ�β�򷵻�false
	 * @return
	 */
	public boolean hasMoreLines(){
		return index<content.length;
	}
	/**
	 * ��������index ָ���������ݣ����ҽ�index �Զ�����1.
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
