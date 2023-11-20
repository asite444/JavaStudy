package javaClass;

import java.io.StringReader;

public class StringBufferAndBuilder {

	public static void main(String[] args) {
		StringBuffer sf=new StringBuffer();
		
		sf.append("你好！");
		sf.append("现在学的内容已经学了！");
		System.out.println(sf);
		
		StringBuilder sb=new StringBuilder(); //성능이 이게 더 좋다.
		
		
		sb.append("所以我现在学排序。");
		sb.append("继续努力学习JABA!");
	
		System.out.println(sb);
	}

}
