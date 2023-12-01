package javaClass.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
//art+shift+z: try 감싸기
public class TestNetWorkSever {

	public static void main(String[] args) throws IOException {
		
        //                                 Port Number
		
		ServerSocket server=new ServerSocket(5000);
		
		System.out.println("---[Server Listening....]---");
		
		/**/
		
		//서버로부터 데이터를 받아오기 위한 준비(서버 가동)
		while(true) {
			try {
				//서버가 요청 대기->상대방 소켓과 연결
				Socket socket=server.accept();
				
				//상대방 ip주소 출력
				String ip=socket.getInetAddress().getHostAddress();
				//데이터 수신
				byte[] readbuff=new byte[255];
				//보낸 정보 읽기
				InputStream is= socket.getInputStream();
				int len=is.read(readbuff);
				
				String redStr=new String(readbuff,0,len);
				
				System.out.println("["+ip+"]"+redStr);
			} catch (IOException e) {
				
			}
			
		}
		
	}

}
