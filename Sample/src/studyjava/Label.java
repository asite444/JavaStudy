package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Label {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] s = new int[10];
		int count = 0;
		for(int i=0; i<10; i++) {
			s[i] = Integer.parseInt(br.readLine())%42;
			Label : while(true) {
				for(int j=0; j<i; j++) {
					if(s[i]==s[j]) break Label;
				}
				count ++;
				break Label;
			}
		}
		bw.write(String.valueOf(count));
		
		bw.flush();
		bw.close();
		br.close();
		
	}	
}
