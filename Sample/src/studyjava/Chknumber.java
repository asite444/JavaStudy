package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Chknumber {
	public static void main(String[] args) throws  IOException  {
    	Scanner scan=new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numb[]=new int[28];
		
		for(int i=0;i<numb.length;i++) {
			numb[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=30;i++) {
			for(int j=0;j<numb.length;j++) {
				if(numb[j]==i) break;
				
				if(j==27)	bw.write(i+"\n");
			}
		}
		bw.flush();
		
    }
}
