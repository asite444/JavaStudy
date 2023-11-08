package codingTest;

import java.util.Scanner;

//버블 정렬
public class SortBubbles {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int numberCount=scanner.nextInt();
		
		int numbers[] = new int[numberCount];
	
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=scanner.nextInt();
		}
		
		bubbles_Sorts(numbers);
		for(int i=0;i<numbers.length;i++) {
		System.out.println(numbers[i]);	
		}

	}

	
	static public int[] bubbles_Sorts(int numbers[]) {
		int changeNumber=0;
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i]>numbers[j]) {
					changeNumber=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=changeNumber;
				}
			}
		}
		
		return numbers;
	}
}
