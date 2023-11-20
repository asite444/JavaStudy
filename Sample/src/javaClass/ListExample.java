package javaClass;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		//리스트는 Integer,Double,Float 등의 객체만을 저장함. 원칙상 기본자료형(int,long,char 등)은 리스트에 저장 안됨
		List<String> arrylist=new ArrayList<String>();
		int n=3;
		String a=(Integer.toString(n));
		String str="가나다라마바사";
		char c=str.charAt(0);
		
		
		
	
		
		System.out.println(arrylist.contains("3"));
		

	}

}
