package network.data;
/*

 */

import java.io.Serializable;
import java.util.ArrayList;
//여기 수정 신중히 할것
public class Data implements Serializable{

	public static final int IN			=1;		// 채팅방 입장
	public static final int OUT			=2;		// 채팅방 퇴장
	public static final int CHAT		=3;		// 채팅
	public static final int USERLIST	=4;		// 유저목록
	
	public int protocal;
	//해당 객체가 Serializable을 상속받고 있어야 직렬화가 가능함
	public String nick_name;					//대화명
	public String message;  					//대화 내용
	
	public ArrayList<String> userList; 			//유저 리스트
	
	
}
