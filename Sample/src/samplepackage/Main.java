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

		List<Integer> list=new ArrayList<Integer>();
		list.add(3);
		
		System.out.println(list.contains(3));
		System.out.println(list.get(0));
		
	};
}


