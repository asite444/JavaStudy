package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EndOfFile {

	  public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s="";
			
			while((s = br.readLine()) != null && !s.isEmpty()) {
				int a = Integer.parseInt(s.split(" ")[0]);
				int b = Integer.parseInt(s.split(" ")[1]);
				bw.write(a + b + "\n");
				
			
			}
			bw.flush();	
		}
}
