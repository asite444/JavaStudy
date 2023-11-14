package samplepackage;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		char c='1';
		String s="1234";
		char c2='□';
		int arr[]= {1,5,3,8,4,9,6};
		
		/*
		 * 1:★ 
		 * 2:◆ 
		 * 3:■
		 * 4:▼
		 * 5:♥
		 */
		
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		System.out.println("0 ■□□□□□□□□□");
		System.out.println("1 ■□□□★□□□□□");
		System.out.println("2 ■□□□□□□□□□");
		System.out.println("3 □□□□□□□♥□□");
		System.out.println("4 □□□□◆□□♥□□");
		System.out.println("5 □□□□◆□□♥□□");
		System.out.println("6 □□□□□□□♥□□");
		System.out.println("7 ▼▼▼▼□□□♥□□");
		System.out.println("8 □□□□□□□□□□");
		System.out.println("9 □□□□□□□□□□");
		
		
		
		//System.out.println(s.charAt(2)>'2');
		

	}
}