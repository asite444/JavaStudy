package samplepackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//합병정렬 
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numberCount=Integer.parseInt(br.readLine());
		int array[]=new int[numberCount];
		for(int i=0;i<array.length;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		array=marge_Sort(array,1);
		
		for(int i:array) {
			System.out.print(i);
		}
		
	}
	
	
	public static int[] marge_Sort(int[] arr,int count) {
		System.out.println(count+"회 실행-----------------------------------------------");
		for(int i:arr) System.out.println(i);
        if (arr.length < 2) return arr;

        int mid = arr.length / 2;
        int[] low_arr = marge_Sort(Arrays.copyOfRange(arr, 0, mid),count+1);
        
        for(int i:low_arr) System.out.print("low_arr:"+i+"어디로 갈까요");
        
        System.out.println();
        
        int[] high_arr = marge_Sort(Arrays.copyOfRange(arr, mid, arr.length),count+1);
        System.out.println();
        for(int i:high_arr) System.out.print("high_arr:"+i+"이놈은 으데로 가는가!");
        System.out.println();
        System.out.println("------------------------------");
        
        int[] mergedArr = new int[arr.length];
        System.out.println("arr.length:"+arr.length);
        int m = 0, l = 0, h = 0;
        System.out.println("첫번째 while문 실행-------------------");
        while (l < low_arr.length && h < high_arr.length) {
        	
            if (low_arr[l] < high_arr[h])
            	{
            	System.out.println("true");
            	System.out.println("mergedArr["+m+"]:"+mergedArr[m]+" 의 값은 low_arr["+l+"]:"+low_arr[l]+"이다.");
            	mergedArr[m++] = low_arr[l++];
            	}
            else {
            	System.out.println("false");
            	System.out.println("mergedArr["+m+"]:"+mergedArr[m]+" 의 값은 low_arr["+h+"]:"+high_arr[h]+"이다.");
                mergedArr[m++] = high_arr[h++];
            }
            
        
        }
        System.out.println("첫번째 while문 종료-------------------");
        System.out.println();
        System.out.println("l:"+l);
        System.out.println("h:"+h);
        System.out.println();
        System.out.println("두번째 while문 시작-------------------");
        while (l < low_arr.length) {
        	System.out.println("mergedArr["+m+"]:"+mergedArr[m]+" 의 값은 low_arr["+l+"]:"+low_arr[l]+"이다.");
        	System.out.println();
            mergedArr[m++] = low_arr[l++];
        }
        System.out.println();
        System.out.println("두번째 while문  종료-------------------");
        System.out.println();
        System.out.println("세번째 while문 시작-------------------");
        System.out.println();
        while (h < high_arr.length) {
        	System.out.println();
        	System.out.println("mergedArr["+m+"]:"+mergedArr[m]+" 의 값은 high_arr["+h+"]:"+high_arr[h]+"이다.");
            mergedArr[m++] = high_arr[h++];
        }
        System.out.println();
        System.out.println("세번째 while문 종료-------------------");
        System.out.println();
        System.out.println(count+"회 메서드 종료--------------------------------------------------");
        System.out.println();
        
        System.out.println("최종 리턴값---------------------");
        for(int i=0;i<mergedArr.length;i++) System.out.println("mergedArr["+i+"]="+mergedArr[i]);
        return mergedArr;
    }
}