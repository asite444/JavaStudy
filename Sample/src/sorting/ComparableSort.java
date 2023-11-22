package sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;

public class ComparableSort {

	public static void main(String[] args) throws IOException {
		BufferedWriter br=new BufferedWriter(new OutputStreamWriter(System.out));
		MyInteger[] arr=new MyInteger[10];
		Random random=new Random();
		for(int i=0;i<arr.length;i++) {
			arr[i]=new MyInteger(random.nextInt(100));
		}

		//정렬 전
		for(int i=0;i<arr.length;i++) {
			br.write(arr[i].number+" ");
		}
		br.write("\n");
		br.flush();
		Arrays.sort(arr);

		//정렬 후
		for(int i=0;i<arr.length;i++) {
			br.write(arr[i].number+" ");
		}

		br.write("\n");
		br.flush();

	}
}

class MyInteger implements Comparable<MyInteger>{
	int number;

	public MyInteger(int number) {
		this.number=number;
	}
	@Override
	public int compareTo(MyInteger o) {

		return this.number-o.number;
	}
}