package javaClass;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		//모든 유형의 객체 저장 가능하나,권장되지 않는 방법
		ArrayList<Object> list=new ArrayList<Object>();
		
		//수동
		list.add(String.valueOf("가나다"));
		list.add(Integer.valueOf(3));
		
		//오토박싱
		list.add(3.14);
		
		
		//자동 형변환 불가,수동으로 해줘야 함
		int a=(int)list.get(1);
		String str=(String)list.get(0);
		Double b=(Double)list.get(2);
		
		//String 객체만 저장되는 권장되는 방법.
		List<String> stringlist=new ArrayList<String>();
		

		stringlist.add("충칭");
		String city=stringlist.get(0);
	}

}
