package studyjava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {

		LinkedList<String> linkedlist=new LinkedList<String>();
		
		
		List<String> arrayList=new ArrayList<String>();
		
		
		linkedlist.add("上海");
		linkedlist.add("北京");
		linkedlist.add("成都");
		linkedlist.add("西安");
		linkedlist.add("重庆");
		linkedlist.add("南京");
		linkedlist.add("哈尔滨");
		
	    System.out.println(linkedlist.get(0));
	    System.out.println(linkedlist.contains("南京"));
		
		linkedlist.add(0, "青岛");
		System.out.println(linkedlist.getFirst());

		arrayList.add("서울");
		arrayList.add("천안");
		arrayList.add("부산");
		arrayList.add("충주");
		arrayList.add("제주도");
		
		linkedlist.addAll(0, arrayList);
	

		System.out.println("-------------------------");
		
		for(int i=0;i<linkedlist.size();i++) {
			System.out.println(linkedlist.get(i));
		}
		
		linkedlist.set(5, "상하이");
		
		System.out.println(linkedlist.get(5));
		
		
		
		
		
	}
}
