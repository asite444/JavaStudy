package network.server;

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

//import network.data.Data;
import data.Data;
public class MultiChatServer extends JFrame {

	JTextArea 		jta_display;    	//출력창
	JList<String> 	jlist_user;		 	//유저 목록창
	JTextField 		jtf_count;     		//접속자수
	//                  폰트체      색    크기
	Font font=new Font("굴림체",Font.BOLD,18);

	//네트워크 기능
	ServerSocket server;
	//접속자 소켓목록
	List<ReadThread> socktList=new ArrayList<ReadThread>();//통신 가능한 소켓정보 

	//접속자 이름목록
	List<String> userList=new ArrayList<String>();

	//Thread 동기화 객체
	Object syncObject=new Object();

	public MultiChatServer() {
		super("WechatServer");

		System.out.println("서버측:프로그램 시작");
		System.out.println("서버측:출력창 초기화 시작");
		//출력창 초기화
		init_display();

		System.out.println("서버측:출력창 초기화 완료");
		//사용자 목록창 초기화
		init_user_list();

		
		//접속자 수 출력창 초기화
		System.out.println("서버측:접속자 수 출력창 초기화 시작");
		init_user_count();
		System.out.println("서버측:접속자 수 출력창 초기화 완료");

		System.out.println();
		//서버 소켓 초기화
		System.out.println("서버측:서버 소켓 초기화 시작");
		init_server();//메소드 내 주석처리된 코드를 쓰면 여기서 무한대기임(접속대기 중이기 때문)
		System.out.println("서버측:서버 소켓 초기화 완료");
		//위치
		this.setLocation(100, 200);

		//크기
		//this.setSize(400, 300);

		//자식 윈도우 크기 정해지면,부모 윈도우는 그 주변을 감싸라.
		this.pack();
		System.out.println("서버측:보여주맛!");
		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {

		//      이렇게 하면 안됨
		//		server =new ServerSocket(6000);
		//		Socket child=server.accept(); <--여기서 대기중....접속정보 대기(있어야만 진행되고 없으면 무한대기) 

		//class ListenThread extends Thread{......} <----- Thread() {.....}
		//class ListenThread extends Thread{run(){....}}
		//ListenThread sd=new ListenThread();
		//sd.start();

		try {//alt+shift+z:try-catch 블록 단축키 
			server =new ServerSocket(6000);
			//서버의 수신 쓰레드(작업자)
			new Thread() {
				public void run() {
					int i=1;
					while(true) {

						System.out.println("서버측:여기 무한 돌탕때림??");

						try {
							//들어올때 까지 접속 대기
							System.out.println("서버측:접속대기 시작");
							Socket child=server.accept();//자소켓

							System.out.println("서버측:누군가의 접속시작");
							
						if(i==1)System.out.println("서버측:시작");
						i++;
							//입장
							synchronized (syncObject) {
								System.out.println("서버측:입장 syncObject:"+syncObject);
								ReadThread rt=new ReadThread(child);//child객체 생성해서 넘김,여기서 에러 발생 시 해당 try catch문에게 감(throws)
								rt.child=child;
								//System.out.println("서버측:누군가 접속하였습니다!!");

								//소켓 목록에 저장
								System.out.println(rt.child);
								socktList.add(rt);//이게 실행된 거면 접속자수 한명 추가된것 

								//쓰레드 구동(수신쓰레드 동작)
								rt.start();


								//접속자 수 갱신
								display_user_count();
								//jtf_count.setText(socktList.size()+"");//강제 String 형변환,접속할 때마다 여기 값 추가됨 	
							}


						} catch (Exception e) {
							//accept 실패한 경우
							e.printStackTrace();
						}

					}
				};
			}.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void init_user_count() {


		JPanel p=new JPanel(new GridLayout(1,3));
		JLabel jlb1=new JLabel("접속자수",JLabel.RIGHT);
		jtf_count=new JTextField("3천만");
		JLabel jlb2=new JLabel("(명)");

		jlb1.setFont(font);
		jtf_count.setFont(font);
		jlb2.setFont(font);

		//JTextField 중앙 정렬
		jtf_count.setHorizontalAlignment(JTextField.CENTER);

		//읽기 전용
		jtf_count.setEditable(false);

		System.out.println(jtf_count);
		p.add(jlb1);
		p.add(jtf_count);
		p.add(jlb2);

		System.out.println("서버측:jlb1:"+jlb1);
		this.add(p,"South");

	}

	private void init_user_list() {
		System.out.println("서버측:유저 리스트 메소드 시작");
		jlist_user=new JList<String>();
		JScrollPane jsp=new JScrollPane(jlist_user);

		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp,"East");

		jlist_user.setFont(font);

		//Test(확인용임)
		//String[] user_array= {"안중근","윤봉길","유관순","나석주"};
		//jlist_user.setListData(user_array);
		System.out.println("서버측:유저 리스트 메소드 완료");
	}

	private void init_display() {
		jta_display=new JTextArea();
		try {
			Thread.sleep(100);
			System.out.println("서버측:init_display메소드 시작");


			//스크롤 기능(텍스창 옆 스크롤바 생성)
			JScrollPane jsp=new JScrollPane(jta_display);
			//최초 화면 크기 설정
			jsp.setPreferredSize(new Dimension(400,400));
			this.add(jsp,"Center");

			//읽기 전용,입력 불가,모니터링 목적
			jta_display.setEditable(false);

			//폰트적용
			jta_display.setFont(font);

			//서버 대기중... 문자 출력
			jta_display.append("服务器待机....\r\n");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MultiChatServer();

	}

	//---[ReadThread:Start]----------------------------------------------------------------------

	class ReadThread extends Thread
	{
		//자소켓
		Socket child;
		//응답
		ObjectInputStream 	ois;		//수신
		ObjectOutputStream 	oos;		//송신


		//ReadThread 생성될 때,값을 넘겨주기 위함
		public ReadThread(Socket child) throws Exception{//바깥의 try-catch문에 넘기기
			this.child = child;
			System.out.println("서버측:child:"+child);
			//클라이언트에서는 oos가 먼저 선언되고,ois가 선언된다(절대적 중요! 순서 개쳐중요함즉 클라이언트와 서버간 oos와 ois를 서로 크로스로 선언할 것!!!!!!!!!!!!!!!!!!!)
			//생성 순서는 클라이언트 측과 Cross로 생성
			ois=new ObjectInputStream(child.getInputStream());    //클라이언트 서버로부터 데이터 받고			
			oos=new ObjectOutputStream(child.getOutputStream());  
			
			System.out.println("서버측:ReadThread실행 싀캬");
		}


		//서보 동작 준비 완료 후
		@Override
		public void run() {//끝나면 자동소멸
			//데이타 처리준비
			System.out.println("서버측:데이터가 전송됨 스캬!");
			while(true) {
				//직렬화되어서 온 데이터, 역직렬화 후 Object ->Data 다운케스팅

				try {
					Data data=(Data)ois.readObject();

					//상대 소켓이 닫힌경우 끝내라!
					if(data==null) break; 

					//입장
					if(data.protocal==Data.IN) {

						synchronized (syncObject) {


							//입장자의 이름 등록
							userList.add(data.nick_name);//이녀석 때문에 동기화 시킨것임

							//접속자 목록을 화면 우측에 표시
							display_user_list();

							//현재 접속자 목록을 모든 접속자에게 전송
							send_user_list_all();
						}
						//채팅
					}else if(data.protocal==Data.CHAT) {
						synchronized (syncObject) {//데이터 전송과정에서 발생하는 에러방지
							System.out.println(data.message+"라는 메세지를 입력했다우");
							System.out.println(data.nick_name);
							send_message_all(data);
							
						}

					}
				} catch (Exception e) {

					System.out.println("서버측:누군가 접종함");
					//e.printStackTrace();
					break;//상대방 소켓 닫히면 break(상대방이 접속 해재하거나,강종하거나,비정상종료하거나 하면)
				}
			}//while 끝


			synchronized (syncObject) {


				//상대방 소켓이 끊어졌을 때.....
				//현재 socketList 의 intdex구하기 
				int index= socktList.indexOf(this);//현재 종료된 ReadThread객체정보,즉 쓰레드정보

				//퇴장자 이름(xx님이 퇴장함 ㅋ)
				String del_name=userList.get(index);

				//퇴장자이름 삭제
				userList.remove(index);

				//소켓목록삭제
				socktList.remove(index);

				//현재 접속자 목록 갱신
				display_user_list();

				//접속자 갱신(감소)
				display_user_count();

				//갱신된 유저 목록을 모든 사용자에게 전송
				send_user_list_all();

				//퇴장 정보 전송
				Data data=new Data();
				data.protocal=Data.OUT;//퇴장

				//퇴장자의 정보
				data.nick_name=del_name;
			}
		}

	}

	public void display_user_list() {
		//ArrayList ->Array
		String[] user_array=new String[userList.size()];
		userList.toArray(user_array);

		jlist_user.setListData(user_array);

	}

	public void send_message_all(Data data) {//현 접속자 모두에게 전송하기(각각 클라들에게)

		for(ReadThread rt:socktList) {
			try {
				rt.oos.writeObject(data); //첫번째 실패시 catch하고 다음으로(쓰레드와 oos 각각 하나씩 할당,for문 돌며 각각 접속자 클라이언트들,즉 전체에게 접속자리스트 전송)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	public void display_user_count() {

		jtf_count.setText(socktList.size()+"");

	}

	/**
	 * 현재 접속자 목록을 모든 접속자에게 전송
	 * */
	public void send_user_list_all() {

		Data data=new Data();
		data.protocal=Data.USERLIST; //유저 목록 클라이언트에게 전송
		data.userList=new ArrayList<String>(userList); 

		for(ReadThread rt:socktList) {
			try {
				System.out.println("서버측:접속 한 순간의 멤버는?!"+data.userList.get(0));
				rt.oos.writeObject(data); //첫번째 실패시 catch하고 다음으로(쓰레드와 oos 각각 하나씩 할당,for문 돌며 각각 접속자 클라이언트들,즉 전체에게 접속자리스트 전송)
			} catch (IOException e) {
				System.out.println("서버측:데이터 클라측 전송시패!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
				e.printStackTrace();
			}
		}
	}


	//---[ReadThread:End]----------------------------------------------------------------------
}

