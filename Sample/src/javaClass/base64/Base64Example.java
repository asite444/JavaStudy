package javaClass.base64;

import java.util.Base64;

public class Base64Example {

	public static void main(String[] args) throws Exception {
		
		String pwd="950821-123456";
		
		//해당 방식은 최저수준의 암호화 방식임
		
		//패스워드 암호화
		String encoded=Base64.getEncoder().encodeToString(pwd.getBytes("utf-8"));
		System.out.println(encoded);
		
		//패스워드 복호화
	    byte[] decoded=Base64.getDecoder().decode(encoded);
	    
	    //String ->byte[]
	    String str="nihao";
	    byte[] bytes=str.getBytes();
	    
	    
	    //decoded 을 utf-8로 변경
	    String decodedPwd=new String(decoded,"utf-8");
		System.out.println(decodedPwd);
		
	}

}
