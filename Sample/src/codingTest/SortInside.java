package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortInside {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String number=br.readLine();
		int [] arr=new int[number.length()];		
		for(int i=0;i<arr.length;i++) arr[i]=number.charAt(i);
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;i--) sb.append(arr[i]-'0');
		System.out.println(sb);
		
	}

}
