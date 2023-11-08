package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StarRightAlignment {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		int a=Integer.parseInt(br.readLine());
		for(int i=0;i<a;i++) {
			
			for(int j=1;j<=a;j++) {
				if(j>=a-i)bw.write("*");
				else bw.write(" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		
		
	}
}
