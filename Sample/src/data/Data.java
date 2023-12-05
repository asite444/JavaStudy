package data;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable{
	
	public static final int  IN   		= 1; //입장
	public static final int  OUT  		= 2; //퇴장
	public static final int  CHAT 		= 3; //채팅
	public static final int  USERLIST	= 4; //유저목록
	public static final int  GRIM 		= 5; //그리기
	public int protocal;
	
	public String nick_name;//대화명
	public String message;  //대화내용
	
	public ArrayList<String> userList;
	
	//그리기정보
	public Point pt;
	public Color line_color;
	public int line_thick;
	
}



