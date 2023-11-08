package timeComplexity;

import java.util.Scanner;
//시간복잡도 O(2n) 걸리는 피보나치 수열.(무한대에 가까움.n의 크기에 따라 처리 시간은 기하급수적으로 증가하게 된다.)
public class FibonacciSequence {
static int func(int numb) {
		
		if(numb<=1) {
			return 1;
		}
		return func(numb-1)+func(numb-2);
	};
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println(func(scanner.nextInt()));
		scanner.close();

	}
}
