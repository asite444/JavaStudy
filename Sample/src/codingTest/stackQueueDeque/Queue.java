package codingTest.stackQueueDeque;
/*
 * https://www.acmicpc.net/problem/4949
 각 문자열은 마지막 글자를 제외하고 영문 알파벳,
  공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며, 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.

입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
출력
각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Queue {



	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

		String input="";
		while(true) {
			input=br.readLine();
			if(!input.equals(".")) {	
				sb.append(push(input)).append("\n");

			}	
			else break;

		}
		System.out.println(sb);


	}

	static String push(String input)  {
		Stack<Character> stack=new Stack<Character>();
		int i=0;
		char c;

		while(i<input.length()) {
			c=input.charAt(i);
			if(c=='(' || c=='[') {
				stack.add(input.charAt(i));
			}
			if(c==')'){
				if(stack.isEmpty() || stack.peek()!='(') return "no";
				else stack.pop();
			}
			else if(c==']') {
				if(stack.isEmpty() || stack.peek()!='[') return "no";
				else stack.pop();
			}

			i++;
		}



		if(stack.isEmpty()) return "yes";
		else return "no";
	}
}
