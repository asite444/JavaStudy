package studyjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ComparatorSort {

	public static void main(String[] args) {


		MySecondInteger[] arr=new MySecondInteger[10];
		StringBuilder sb=new StringBuilder();
		Random random=new Random();

		//정렬 전
		for(int i=0;i<arr.length;i++) {
			arr[i]=new MySecondInteger(random.nextInt(100));
			sb.append(arr[i].number+" ");
		}
		sb.append("\n");
		Arrays.sort(arr,compAsc);
		//오름차순 정렬 후
		for(int i=0;i<arr.length;i++) sb.append(arr[i].number+" ");
	
		
		sb.append("\n");
		Arrays.sort(arr,compDesc);
		//내림차순 정렬 후
		for(int i=0;i<arr.length;i++) sb.append(arr[i].number+" ");
		System.out.println(sb);



	}

	//오름차순 정렬 익명 객체
	public static Comparator<MySecondInteger> compAsc=new Comparator<MySecondInteger>() {

		@Override
		public int compare(MySecondInteger o1, MySecondInteger o2) {
			return o1.number-o2.number;
		}
	};
	
	//내림차순 정렬 익명 객체
	public static Comparator<MySecondInteger> compDesc=new Comparator<MySecondInteger>() {

		@Override
		public int compare(MySecondInteger o1, MySecondInteger o2) {
			return -(o1.number-o2.number);
		}
	};

}

class MySecondInteger{
	int number;

	public MySecondInteger(int number) {
		this.number=number;
	}

}