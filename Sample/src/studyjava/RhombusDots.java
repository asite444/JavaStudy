package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 
        *
       ***
      *****
     *******
    *********
   ***********
  *************
 ***************
*****************
 ***************
  *************
   ***********
    *********
     *******
      *****
       ***
        *
 
 */
public class RhombusDots {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		for(int i=1;i<=(2*n-1);i++) {
			for(int j=1;j<=(2*n-1);j++) {
				
			if(j>n-i && j< n+i && 0<=n-i||0>n-i && 3*n-i-1>=j && -n+i+1<=j) {
				
				bw.write("*");
				}
			else if (j>=n+i && 0<=n-i || 0>n-i && 3*n-i-1<j)break;
			else bw.write(" ");
			
			}
			bw.newLine();
		} 
		bw.flush();
	}
}
