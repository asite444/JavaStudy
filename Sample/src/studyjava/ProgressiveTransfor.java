package studyjava;

import java.util.Scanner;

public class ProgressiveTransfor {
	public static void main(String[] args)  {
		
		Scanner scan=new Scanner(System.in);
		String N=scan.next();
		int B=scan.nextInt();
		
	    
		int x=1;
		int i;
		int result=0;
		for(i=N.length()-1;0<=i;i--) {
			
			char c=N.charAt(i);
			
			
			if('A'<=c && c<='Z') {
				result+=(c-'A'+10)*x;
			}else
			{
				result+=(c-'0')*x;
			}
			x*=B;
			
		}
		System.out.println(result);
	  scan.close();
		}
}
