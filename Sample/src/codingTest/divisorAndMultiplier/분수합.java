package codingTest.divisorAndMultiplier;
/*
분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 
그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int i=10;
		int number[]=new int[4];
		int gcdNumb=1;
		st=new StringTokenizer(br.readLine());
		number[0]=Integer.parseInt(st.nextToken());
		number[1]=Integer.parseInt(st.nextToken());		

		st=new StringTokenizer(br.readLine());
		number[2]=Integer.parseInt(st.nextToken());
		number[3]=Integer.parseInt(st.nextToken());

		int bunza=number[0]*number[3]+number[1]*number[2];
		int bunmo=number[1]*number[3];
		
		gcdNumb=gcd(bunza,bunmo);
		
		
		while(true) {
			if(bunza%gcdNumb!=0 || bunmo%gcdNumb!=0 || gcdNumb==1) break;
			bunza/=gcdNumb;
			bunmo/=gcdNumb;	
		}

	System.out.println(bunza+" "+bunmo);	
	}

	static int gcd(int a, int b) { 
		if(a%b ==0) {
			return b;
		}
		return gcd(b, a%b);
	}


}
