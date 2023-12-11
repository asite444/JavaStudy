package codingTest.stackQueueDeque;

//https://www.acmicpc.net/problem/12789

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class 간식드리미 {

	
	static Queue<Integer> queue=new LinkedList<Integer>();
	static Stack<Integer> stack=new Stack<Integer>();


	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	

		int frontnumb=Integer.parseInt(br.readLine());
		String numb=br.readLine();

		push(numb,frontnumb);
	}






	private static void push(String numb,int frontnumb) {
		int seq=1;
		StringTokenizer st=new StringTokenizer(numb);
		for(int i=0;i<frontnumb;i++) {

			int number=Integer.parseInt(st.nextToken());


			if(i==0 && number==1) {
				seq++;
				continue;
			}

			queue.add(number);	

			//스택 대기줄에 가장 위의 데이터가 queue에서 꺼낸 값보다 작은 경우
			if(!stack.isEmpty()&&number>stack.peek())
			{
				System.out.println("Sad");
				return;
			}else {


				//가장 앞에있는 순번을 stack에 push
				stack.push(queue.poll());

				//상품을 받을 순서가 된 경우
				//상품을 받고 나간 다음 순번이 다음 순서인 경우
				while(!stack.isEmpty()&&stack.peek()==seq) {				
						
						//다음 순번
						seq++;
						
						//스택 대기줄에서 가장 윗 값 빼내기
						stack.pop();
					
				}
			}

		}

		if(stack.isEmpty() && queue.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}

}
