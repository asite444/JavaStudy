package studyjava;

import java.util.Scanner;

public class VerticallyRead {
	public static void main(String[] args)  {
		
		Scanner scan=new Scanner(System.in);
		char x[][]=new char[5][15];
		String s="";

		for(int i=0;i<5;i++) {
			s=scan.next();		
			for(int j=0;j<15;j++) {
				if(s.length()<=j) break;
				x[i][j]=s.charAt(j);
				
			}
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<5;j++) {
			 if(x[j][i]=='\u0000') continue;	
		     System.out.print(x[j][i]);
			}
		}	
		
	  scan.close();
		}
}
