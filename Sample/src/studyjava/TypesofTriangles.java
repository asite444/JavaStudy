package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class TypesofTriangles {

	/*
	Equilateral :  세 변의 길이가 모두 같은 경우
	Isosceles : 두 변의 길이만 같은 경우
	Scalene : 세 변의 길이가 모두 다른 경우
	
	단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다.
	가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
    세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
	 */
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n[]=new int[3];

	    String s;
		while(true) {
		
			s=br.readLine();
			if(s.equals("0 0 0")) break;
			
			n[0]= Integer.parseInt(s.split(" ")[0]);
			n[1]= Integer.parseInt(s.split(" ")[1]);
			n[2]= Integer.parseInt(s.split(" ")[2]);
			
			
			//1.첫번째 방법(정렬하지 않은 경우)
			/*
			if(n[0]+n[1]<=n[2] || n[1]+n[2]<=n[0] || n[0]+n[2]<=n[1]) bw.write("Invalid");
			else {
				if(n[0]==n[1] && n[1]==n[2]) bw.write("Equilateral");
				else if((n[0]==n[1])&& n[0]!=n[2] || (n[1]==n[2]) && n[0]!=n[2] || (n[0]==n[2])&& n[1]!=n[2] ) bw.write("Isosceles");	
				else bw.write("Scalene");
			}
			*/
			
			//2.두번째 방법 (정렬한 경우)
			Arrays.sort(n);
			if(n[0]+n[1]<=n[2]) bw.write("Invalid");
			else {
				if(n[0]==n[1] && n[1]==n[2]) bw.write("Equilateral");
				else if(n[0]==n[1] && n[1]!=n[2] || n[1]==n[2] && n[0]!=n[1]) bw.write("Isosceles");	
				else bw.write("Scalene");
			}
			
			
			
			
			bw.write("\n");
		}
		bw.flush();
		
	
	   
	}
}
