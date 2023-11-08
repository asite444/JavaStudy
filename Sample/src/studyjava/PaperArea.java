package studyjava;

import java.util.Scanner;

public class PaperArea {
	public static void main(String[] args)  {
		
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	boolean c[][]=new boolean[101][101];
	int cnt=0;
	for(int i=0;i<n;i++) {
		int a=scan.nextInt();
		int b=scan.nextInt();
		
		for(int x=a;x<a+10;x++) {
			for(int y=b;y<b+10;y++) {
				if(!c[x][y]) {
					c[x][y]=true;
					cnt++;
				}
			}
		}
		
	}
	System.out.println(cnt);
	

	
	
  scan.close();
}
}