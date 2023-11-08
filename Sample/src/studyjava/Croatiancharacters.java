package studyjava;

import java.util.Scanner;

public class Croatiancharacters {

	public static void main(String[] args)   {
		
		Scanner sc=new Scanner(System.in);
		
		String str[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String st=sc.nextLine();
		
		for(int i=0;i<str.length;i++) {
			if(st.contains(str[i]))// 해당 문자열이 존재하는가?
				st=st.replace(str[i], "!"); //문자 치환
		}
		
		System.out.println(st.length());
		sc.close();
	}
}
