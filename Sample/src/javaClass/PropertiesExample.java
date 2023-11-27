package javaClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException { //파일 찾을수 없거나,입출력 에러시의 예외처리
		Properties prop=new Properties();
		//DB 접속정(해당 파일을 통해 DB접속하게 된다.보안상 숨겨야함(접속정보))
		//해당 파일에 한글 입력시,해당 유니코드 값으로 변경됨. 한글 쓰지 말것
		prop.load(new FileReader("db.properties"));
		
	   // prop.list(System.out);
	    
	   //key 값 1개씩 얻어옴
	    String driver=prop.getProperty("driver");
	    String url=prop.getProperty("url");
	    String username=prop.getProperty("username");
	    String password=prop.getProperty("password");
	    String sampleValue=prop.getProperty("sampleValue");
	    
	    System.out.println("--------DB연결 옵션------");
	    System.out.println("driver:"+driver);
	    System.out.println("url:"+url);
	    System.out.println("username:"+username);
	    System.out.println("password:"+password);
	    System.out.println("sampleValue:"+sampleValue);
	}

}

