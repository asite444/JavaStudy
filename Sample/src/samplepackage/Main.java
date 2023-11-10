package samplepackage;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//  long n = Long.parseLong(br.readLine());
		long n[]=new long[10];
		for(int i=0;i<10;i++) n[i]=i;

		br.close();

		int count = 0; //수행 홧수 저장하는 변수
		for(int x=0;x<10;x++) {
			for(int i  = 1; i <= n[x]-2; i++){
				for(int j = i+1; j <= n[x]-1; j++){
					for(int k = j+1; k <= n[x]; k++){
						count++;
					}
				}
			}
			System.out.println(count);
			count=0;
			
		}
		//System.out.println(count);
	}
}