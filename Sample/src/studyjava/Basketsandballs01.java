package studyjava;

import java.util.Scanner;

public class Basketsandballs01 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();//바구니의 수
		int m=scan.nextInt();//m번에 걸쳐 공을 넣을 방법의 수
		int i;int j;int k;//i번 바구니부터 j번 바구니까지에 k번 번호가 적혀져 있는 공을 넣는다
		int num[]=new int[n];// 각 바구니에 무슨 공이 들어가 있는가
		
		for(int x=0;x<m;x++) {
			i=scan.nextInt()-1;
			j=scan.nextInt()-1;
			k=scan.nextInt();
			for(int y=0;y<num.length;y++) {
				
			if(y>=i && y<=j) {
				  num[y]=k;
				}
				
			}
			
		}
	
		for(int x=0;x<n;x++) {
			System.out.print(num[x]+" ");
		}

	}

}
