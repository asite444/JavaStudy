package studyjava;

import java.util.Scanner;

public class PrimeNumberCount {
	 public static void main(String args[]) {
			
			Scanner scan=new Scanner(System.in);
			
			int c=scan.nextInt();
			int[] n=new int[c];
			int count=0;
			for(int i=0;i<n.length;i++) {
				n[i]=scan.nextInt();
			    for(int j=2;j<=n[i];j++) {
			    		    	
			    	if(n[i]%j==0) {
			    		if(j==n[i])count++;
			    		break;
			    		}	
			    }	
			}
			System.out.println(count);
			
	    }
}
