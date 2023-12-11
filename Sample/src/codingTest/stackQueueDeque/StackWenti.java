package codingTest.stackQueueDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)

이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 
정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.

출력
재민이가 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 231-1보다 작거나 같은 정수이다.
 */
public class StackWenti{

	static List<Integer> list=new ArrayList<Integer>();

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

		int count=Integer.parseInt(br.readLine());
		int numb;
		int sum=0;
		for(int i=0;i<count;i++) {
			numb=Integer.parseInt(br.readLine());	
			if(numb!=0) push(numb);
			else pop();

		}
		
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i);
		}
		
		System.out.println(sum);

	}


	static void push(int numb) {
		list.add(numb);		
	}

	static void pop() {
		list.remove(list.size()-1);
	}
}


