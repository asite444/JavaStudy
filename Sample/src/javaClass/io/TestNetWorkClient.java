package javaClass.io;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TestNetWorkClient {

	public static void main(String[] args) throws Exception {
		//localhost:자기 자신의 주소
		//                        IP PORT
		//InputStream:수신,outputStream:송신 모두 가지고 있다.
		//Socket client=new Socket("192.168.0.49",5000);//강사님 pc ip
		Socket client=new Socket("192.168.0.78",5000);//내 노트북 ip
		OutputStream os=client.getOutputStream();
		String nick_name="你好";
		String msg="这是什么意思？ ";
	
		String sendMessage=String.format("[%s]:%s",nick_name,msg);
		//PrintStream out=new PrintStream(os,true);
		
		//전송
		os.write(sendMessage.getBytes());
		//out.printf("%s]:%s", nick_name,msg);
		//out.flush();
	}

}
