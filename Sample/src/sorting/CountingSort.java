package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

		int number[]=new int[Integer.parseInt(br.readLine())];
		for(int i=0;i<number.length;i++)number[i]=Integer.parseInt(br.readLine());	  	  

		number=countSort(number);

		for(int i:number)sb.append(i).append("\n");  
		System.out.println(sb);

	}

	public static int[] countSort(int []number) {
        int max=Integer.MIN_VALUE;
        for(int i:number) if(i>max) max=i;
		int counting[]=new int[max+1];
		int []result=new int[number.length];

		//카운팅 배열에 넣기
		for(int i=0;i<number.length;i++) ++counting[number[i]];

		//카운팅배열에 누적합 집어넣기
		for(int i=0;i<counting.length-1;i++) counting[i+1]+=counting[i];

		// result 배열에 정렬시키기
		for(int i=number.length-1;i>=0;i--) result[--counting[number[i]]]=number[i];

		return result;
	}
}
