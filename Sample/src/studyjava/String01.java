package studyjava;

import java.util.Scanner;

public class String01 {
/*
next() : 사용자가 입력한값을 문자열로 (엔터치기 전까지 && 공백은 포함되지 않는다.)
nextInt() : 사용자가 입력한값을 정수로
nextLine() : 사용자가 입력한값을 문자열로 (엔터치기 전까지 && 공백 포함)
*/
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
    	
		  
        int n=scan.nextInt();
     	 String s=scan.next();
    	int num[]=new int[n];
    	int result=0;
        
      
       
       
       for(int i=0;i<s.length();i++) {
    	   
    	   num[i]=s.charAt(i)-48;
    	   result+=num[i];
       }
       System.out.println(result);
	}

}
