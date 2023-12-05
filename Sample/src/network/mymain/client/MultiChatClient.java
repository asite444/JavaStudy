package network.mymain.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import network.data.Data;
import data.Data;
public class MultiChatClient extends JFrame {

	JTextArea 		jta_display;    	//출력창
	JList<String> 	jlist_user;		 	//유저 목록창

	//채팅 입력창
	JTextField 		jtf_message;
	JButton    		jbt_connect; 		//연결버튼
	boolean         bCconnect=false;    //연결상태여부

	String          nick_name="안중근";

	Socket 			client;				//클라이언트 소켓

	//직렬화를 위한 작업
	ObjectInputStream  ois;             //수신
	ObjectOutputStream oos;       		//전송


	//                  폰트체      색    크기
	Font font=new Font("굴림체",Font.BOLD,18);
	public MultiChatClient() {
		super("WechatClient");

		//출력창 초기화
		init_display();

		//사용자 목록창 초기화
		init_user_list();

		//채팅창 초기화
		init_message();

		//위치
		this.setLocation(700, 200);

		//크기
		//this.setSize(400, 300);

		//자식 윈도우 크기 정해지면,부모 윈도우는 그 주변을 감싸라.
		this.pack();
		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}



	private void init_message() {

		System.out.println("init_message 실행");
		JPanel p=new JPanel(new BorderLayout());

		jtf_message=new JTextField();
		jbt_connect=new JButton("연결");

		p.add(jtf_message,BorderLayout.CENTER);
		p.add(jbt_connect,BorderLayout.EAST);

		//버튼 크기 설정
		jbt_connect.setPreferredSize(new Dimension(120,0));

		//폰트 설정
		jtf_message.setFont(font);
		jbt_connect.setFont(font);

		this.add(p,BorderLayout.SOUTH);

		//버튼이벤트 등록
		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//토글처리:true<->false
				bCconnect =!bCconnect;
				jbt_connect.setText(bCconnect?"끊기":"연결");
				if(bCconnect) { //연결

					//on 키워드는 이벤트 관련 헨들러이다.
					on_connect();
				}else {//끊기
					on_disconnect();
				}


			}
		});//end:Button Event

		//jtf_message이벤트 등록,jtf_message에서 키 이벤트 발생->addKeyListener,동작 방식?->KeyAdapter
		jtf_message.addKeyListener(new KeyAdapter() {


			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("키가 입력되었다이새캬");

				int key=e.getKeyCode();

				if(key==KeyEvent.VK_ENTER) {
					System.out.println("메세지 전송되었다우!");
					on_send_message();
				}
			}
		});

	}



	protected void on_send_message() {

		System.out.println("on_send_message 실행");
		//
		if(bCconnect==false) return;
		//메시지 창에서 값 읽어오기(입력창),공백 제거
		String message =jtf_message.getText().trim();
		System.out.println(message);
		if(message.isEmpty()) {//입력된 메세지가 없을경우 종료
			jtf_message.setText("");//지우기
			return;
		}

		System.out.println("네트워크 전송중비");
		//네트워크 전송

		Data data=new Data();
		data.protocal=Data.CHAT;
		data.nick_name=nick_name;
		data.message=message;
		
		try {
			System.out.println("클라이언트 측에서 전송된 데이터:");
			System.out.println(data.toString());
			oos.writeObject(data);//전송
		} catch (Exception e) {
			System.out.println("수신 실패하였느니라!");
			e.printStackTrace();
		}
		
		
		
		
		//출력메시지(확인용)------------------------------------------------------------
		//		String display_message=String.format("[%s]님 말씀:\r\n %s\r\n",nick_name,message);
		//		jta_display.append(display_message);
		//		//문서 끝에 Caret(커서)을 위치시킨다.
		//		int position = jta_display.getDocument().getLength();
		//		jta_display.setCaretPosition(position);
		//------------------------------------------------------------------------------

		jtf_message.setText("");//지우기
	}



	/**
	 * 서버 연결 해재시의 메서드
	 * */
	protected void on_disconnect() {
		try {
			//반드시 역순 close(단,지금 밑에 close한정 순서무관)
			//ois.close();
			//oos.close();
			//소켓 close
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	/**
	 * 서버 연결시 메서드
	 */
	protected void on_connect() {
		try {
			//client=new Socket("localhost",6000); //접속하기,근데 여기서 실패하면 catch문
			client=new Socket("192.168.0.49",6000);//------------------------------------------------------------------------------------------

			//직렬화 기능의 객체생성 
			//소켓은 outStream,inputStream 기능 다 가지고 있다!
			oos =new ObjectOutputStream(client.getOutputStream());
			ois =new ObjectInputStream(client.getInputStream());

			//접속 성공 후 입장메시지 전송
			Data data=new Data();
			//서버에 전송할 입장데이터
			data.protocal=data.IN;    	//접속
			data.nick_name=nick_name; 	//닉네임
			oos.writeObject(data);		//데이타 직렬화하여 전송 상대방은 서버
			
			//여기 제대로 안되면 에러
			
			//데이터 수신
			read_message();



		} catch (Exception e) {
			//연결 실패시
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "연결 실패라우 동무!");//경고창 뜨게 하기
			bCconnect=false;
			jbt_connect.setText("연결");
		} 	
	}



	private void read_message() {
		
		//수신 대기(서버측에서 넘어올 데이터)<--근데 이거 서버측에서 단 하나라도 제대로 안되면 블락발생
		
		new Thread() {
			
			public void run() {
			while(true) {
				
				try {
					Data data=(Data) ois.readObject();
					if(data==null) break;
					
					//서버측에서 보내온 정보
					if(data.protocal==Data.USERLIST) {
						
						//유저정보 보여주기
						display_user_list(data);
					}else if(data.protocal==Data.CHAT) {
						System.out.println("눜은갘아 챝잉을 해딹!");
						String display_message=String.format("[%s]:%s\r\n",data.nick_name,data.message);
						
						jta_display.append(display_message);
						
						int posion=jta_display.getDocument().getLength();
						jta_display.setCaretPosition(posion);
					}
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println("어뚼 쇄끼가 서버 끄브릿나!");
					break;
				} 
			}//end:while
			System.out.println("반복문이 종료되었다오!!!");
			//종료상황
			bCconnect=false;
			jbt_connect.setText("연결");
			
			//접속자 목록 제거
			jlist_user.setListData(new String[0]);
			};
		}.start();
		
	}



	protected void display_user_list(Data data) {
		System.out.println("display_user_list가 실행 되었습니다!");
		String[] user_array=new String[data.userList.size()];
		data.userList.toArray(user_array);
		
		//유저목록 뜨게만들기
		jlist_user.setListData(user_array);
	}



	private void init_user_list() {
		jlist_user=new JList<String>();
		JScrollPane jsp=new JScrollPane(jlist_user);

		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp,"East");

		jlist_user.setFont(font);

		//Test(확인용임)
		//String[] user_array= {"안중근","윤봉길","유관순","나석주"};
		//jlist_user.setListData(user_array);
	}

	private void init_display() {
		jta_display=new JTextArea();

		//스크롤 기능(텍스창 옆 스크롤바 생성)
		JScrollPane jsp=new JScrollPane(jta_display);
		//최초 화면 크기 설정
		jsp.setPreferredSize(new Dimension(400,400));
		this.add(jsp,"Center");

		//읽기 전용,입력 불가,모니터링 목적
		jta_display.setEditable(false);

		//폰트적용
		jta_display.setFont(font);



	}

	public static void main(String[] args) {
		new MultiChatClient();

	}

}

