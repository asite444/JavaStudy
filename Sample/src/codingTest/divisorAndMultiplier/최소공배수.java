package codingTest.divisorAndMultiplier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//유클리드 호제법
public class 최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
			st=new StringTokenizer(br.readLine());
			long numbera=Integer.parseInt(st.nextToken());
			long numberb=Integer.parseInt(st.nextToken());		
		System.out.println(lcm(numbera,numberb));
		
	}
	static long gcd(long a, long b) { 
		if(a%b ==0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
	static long lcm(long a, long b)
	{
	    return a * b / gcd(a,b);
	}

}
