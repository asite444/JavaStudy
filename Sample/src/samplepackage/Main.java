package samplepackage;

import java.util.ArrayList;
import java.util.List;

interface Inter{
	int a=3;
	void mathod01(int b);
	//void mathod02();
}
public class Main {
	


	
	public static void main(String[] args) {

		List<String> list=new ArrayList<String>();
		
	
		list.add("dd");
		list.add("ee");
		list.add("ff");
		list.add("ff");
		list.add("d");
		list.remove("ff");
		for(String i:list) {
			System.out.println(i);
		}
		//System.out.println(list.get(0));
		
	};
}


