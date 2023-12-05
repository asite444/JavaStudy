package mymain.server;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Data;

public class MultiChatServer extends JFrame {

	JTextArea     jta_display;   //출력창
	JList<String> jlist_user;    //유저목록창
	JTextField    jtf_count;     //접속자수
	
	Font font = new Font("굴림체", Font.BOLD, 18);
	
	
	//네트워크 기능
	ServerSocket  server;
	
	//접속자 소켓목록
	List<ReadThread> socketList = new ArrayList<ReadThread>();
    
	//접속자 이름목록
	List<String>     userList = new ArrayList<String>();
	
	//Thread동기화 객체
	Object syncObject = new Object();
	
	public MultiChatServer() {
		// TODO Auto-generated constructor stub
		super("채팅서버");

		//출력창초기화
		init_display();
		
		//유저목록창 초기화
		init_user_list();
		
		//접속자수출력창 초기화
	    init_user_count();
			    
	    //서버소켓 초기화
	    init_server();
		
		//위치
		this.setLocation(200, 80);

		//크기
		//this.setSize(400, 400);
		this.pack();
		

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			server = new ServerSocket(6000);
			//서버의 수신 쓰레드
			new Thread() {
				public void run() {
					
					while(true) {
					
						try {
							
							Socket child = server.accept();
							//입장
							synchronized (syncObject) 
							{
								
								
								ReadThread rt = new ReadThread(child);
								
								socketList.add(rt);
								
								rt.start();//수신쓰레드 동작
								
								//접속자수 갱신
								display_user_count();
								//jtf_count.setText(socketList.size()+"");
								
							}
							
							
														
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}//end:while
				}
			}.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void init_user_count() {
		// TODO Auto-generated method stub
		
		JPanel p  = new JPanel(new GridLayout(1, 3));
		JLabel jlb1	= new JLabel("접속자수:", JLabel.RIGHT);
		jtf_count	= new JTextField("0");
		JLabel jlb2 = new JLabel("(명)");
		
		jlb1.setFont(font);
		jtf_count.setFont(font);
		jlb2.setFont(font);
		
		//JTextField 중앙정렬
		jtf_count.setHorizontalAlignment(JTextField.CENTER);
		
		//읽기전용
		jtf_count.setEditable(false);
		
		
		p.add(jlb1);
		p.add(jtf_count);
		p.add(jlb2);
		
		this.add(p,"South");
		
	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		
		JScrollPane jsp = new JScrollPane(jlist_user);
		
		jsp.setPreferredSize(new Dimension(120, 0));
		
		this.add(jsp,"East");
		
		jlist_user.setFont(font);
		
		//Test
//		String [] user_array = {"고길동","나길동","다길동"};
//		jlist_user.setListData(user_array);
	}

	private void init_display() {
		// TODO Auto-generated method stub
		
		jta_display = new JTextArea();
		
		JScrollPane jsp = new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp,"Center");
		
		//읽기전용
		jta_display.setEditable(false);
		//폰트적용
		jta_display.setFont(font);
		
		jta_display.append("서버 대기중....\r\n");
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatServer();
	}
	
//--[ReadThread:Start]-------------------------------------------------------
	class ReadThread extends Thread
	{
		Socket child;
		ObjectInputStream   ois;//수신
		ObjectOutputStream  oos;//송신
		
	    public ReadThread(Socket child) throws IOException {
			super();
			this.child = child;
			
			//생성순서는 클라이언트측과 Cross로 생서
			ois = new ObjectInputStream(child.getInputStream());
			oos = new ObjectOutputStream(child.getOutputStream());
		}



		@Override
	    public void run() {
	    	// TODO Auto-generated method stub
	    	while(true) {
	    		
	    		try {
					Data data = (Data) ois.readObject();
					
					//상대소켓이 닫히면 끝내라
					if(data==null)break;
					
					//입장
					if(data.protocal == Data.IN) {
						
						synchronized (syncObject) 
						{
							//입장자의 이름등록
							userList.add(data.nick_name);
							
							//접속자 목록을 화면 우측에 표시
							display_user_list();
							
							//현재 접속자 목록을 모든사용자에게 전송
							send_user_list_all();
							
							//현재 접속자에게 입장 정보를 전송
							send_message_all(data);
							
						}
						
					}else if(data.protocal==Data.CHAT) {
						
						synchronized (syncObject) 
						{
							//서버 모니터링(예전방식)
							String read_message=String.format("[%s] : %s\r\n", data.nick_name,data.message);
							display_message(read_message);
							send_message_all(data);
						}
						
					}else if(data.protocal==Data.GRIM) {
						
						synchronized (syncObject) 
						{
							send_message_all(data);
						}
						
					}
								
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					
					break;
				}
	    		
	    	}//end:while
	    	
	    	
	    	synchronized (syncObject) 
	    	{
		    	//상대방소켓이 끊어졌을때...
		    	//현재 socketList의 index구하기
		    	int index = socketList.indexOf(this);
		    	//소켓목록삭제
		    	socketList.remove(index);
		    	display_user_count();
		    	
		    	//퇴장자이름
		    	String del_name = userList.get(index);
		    	
		    	//퇴장자이름 삭제
		    	userList.remove(index);
		    	    	
		    	
		    	//현재 접속자목록 갱신
		    	display_user_list();
		    	
		    	
		    	
		    	//갱신된 유저목록을 모든사용자에게 전송
		    	send_user_list_all();
		    	
		    	//퇴장정보 전송
		    	Data data = new Data();
		    	data.protocal = Data.OUT;//퇴장
		    	data.nick_name= del_name;
		    	
		    	//모든 접속자에게 퇴장정보 전송

		    	send_message_all(data);
	    	}
	    	
	    }	
	}

	
	public void display_user_list() {
		// TODO Auto-generated method stub
		//ArrayList -> Array
		String [] user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		jlist_user.setListData(user_array);
		
		
	}

	public void display_message(String read_message) {
		
		int position=jta_display.getDocument().getLength();
		
		
	}

	//모든 클라이언트에게 전송때리겠노라!
	public void send_message_all(Data data) {
		
		for(ReadThread rt : socketList) {
			
			try {
				rt.oos.writeObject(data);
			} catch (IOException e) {
			
			}
			
		}
	}

	public void display_user_count() {
		// TODO Auto-generated method stub
		jtf_count.setText(socketList.size()+"");
	}

	public void send_user_list_all() {
		// TODO Auto-generated method stub
		Data data = new Data();
		data.protocal   = Data.USERLIST;
		data.userList	= new ArrayList<String>(userList);
		
		for(ReadThread rt : socketList) {
			
			try {
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		
		
		
	}
	
//--[ReadThread:End]---------------------------------------------------------	

}
