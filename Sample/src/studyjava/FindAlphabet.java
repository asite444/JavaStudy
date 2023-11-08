package studyjava;

import java.util.Scanner;

public class FindAlphabet {
	public static void main(String[] args)  {
		
		Scanner scan=new Scanner(System.in);
		
		String s=scan.next();
		char arr[]=new char[26];
		
		
		for(int i=0;i<s.length();i++) {
			if('A'<= s.charAt(i) && s.charAt(i)<='Z') {				
				arr[s.charAt(i)-'A']++;
			}
			else
			{
				arr[s.charAt(i)-'a']++;
			}
		}
		
		int max=-1;
		char ch='?';
		
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max=arr[i];
				ch=(char)(i+'A');
			}else if(arr[i]==max) {
				ch='?';
			}
			
		}
		System.out.println(ch);
	}
}
