package javaClass;

import java.util.Arrays;

public class Sample {

	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50,60};
		int arra[]=Arrays.copyOfRange(arr, 0, 3);
		int arrb[]=Arrays.copyOfRange(arr, 3, arr.length);
		
		for(int i:arra) System.out.print(i+" ");
		System.out.println();
		for(int i:arrb) System.out.print(i+" ");
		
		
		

	}

}
