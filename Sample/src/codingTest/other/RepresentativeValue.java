package codingTest.other;

import java.util.Arrays;
import java.util.Scanner;
//평균, 중앙값
public class RepresentativeValue {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int numbers[] = new int[5];
		int sum=0;
	
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=scanner.nextInt();
		}
		
		Arrays.sort(numbers);
		
		for(int i=0;i<numbers.length;i++) {
			sum+=numbers[i];			
		}
		System.out.println((int)sum/5);
		System.out.println(numbers[2]);
		
		scanner.close();
	}

}
