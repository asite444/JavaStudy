package javaClass;

import myutill.MyArrayList;

public class MyArrayListExample {

	public static void main(String[] args) {
		MyArrayList<String> contryArray=new MyArrayList<String>();
		
		contryArray.add("한국");
		contryArray.add("중국");
		contryArray.add("일본");
		contryArray.add("미국");
		contryArray.add("러시아");
		contryArray.add("우크라이나");
		contryArray.add("베트남");
		contryArray.add("태국");
		System.out.println(contryArray.get(0));
		System.out.println(contryArray.size());
		String city=contryArray.get(1);
		System.out.println(city);
		contryArray.remove(0);
		System.out.println(contryArray.get(0));
	}

}
