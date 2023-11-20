package javaClass;

import java.util.StringTokenizer;

public class StringTokenizerEample {

	public static void main(String[] args) {
		String str="wo!bu!zhi!!dao,ni,ye,bu,zhi,dao";
		//문자열을 '!'과 ',' 를 구분자로 나누는데 기준값도 출력함,그러나, 구분자 사이에 아무것도 없으면 무시
		//slit은 빈값이 있어도 포함
		StringTokenizer st=new StringTokenizer(str,"!,",true); 

		while(st.hasMoreTokens()) {
			String token=st.nextToken();
			System.out.println(token);
		}
		System.out.println("--------------------------------------");
		String[] arr=str.split("!");
		for(String i:arr) System.out.println(i);
		//System.out.println(str);


	}

}
