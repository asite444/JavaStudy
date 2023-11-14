package samplepackage;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		
		int arr[]=new int[5];
		
		
		for(int i=0;i<arr.length;) {
			arr[i++]=1;
			System.out.println(arr[i-1]);
		}

	}
}