package mymain.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import data.Data;

public class MultiChatClient extends JFrame {

	JTextArea     jta_display;   //출력창
	JList<String> jlist_user;    //유저목록창
	
	//채팅입력창
	JTextField    jtf_message;
	JButton       jbt_connect;//연결버튼
	boolean       bConnect=false;//연결상태냐?
	
	String        nick_name = "대한제국";
	
	Socket        client;
	ObjectInputStream  ois;//수신
	ObjectOutputStream oos;//전송
	
	
	Font font = new Font("굴림체", Font.BOLD, 18);
	
	
	
	JPanel  grimPan;
	int     line_thick = 5;
	Color   line_color = Color.red;
	
	Image   memPan;//메모리의 그림판
	
	
	
	
	public MultiChatClient() {
		// TODO Auto-generated constructor stub
		super("채팅 클라이언트");

		//출력창초기화
		init_display();
		
		//그림판초기화
		init_grimpan();
		
		//유저목록창 초기화
		init_user_list();
		
		//채팅창 초기화
	    init_message();
		
	    //마우스이벤트 초기화
	    init_mouse_event();
	    		
		//위치
		this.setLocation(700, 80);

		//크기
		//this.setSize(400, 400);
		this.pack();
		
		//크기변경불가
		this.setResizable(false);
		

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//화면그림판와 호환되는 메모리상의 그림판 생성
		memPan = grimPan.createImage(400, 400);
		

	}

	

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		
		grimPan.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseDragged(e);
				
				//네트워크에 연결되지 않았으면 끝내라..
				if(bConnect==false) return;
				
				
				Point pt = e.getPoint();
				
				
				Data data = new Data();
				data.protocal = Data.GRIM;
				data.pt = pt;
				data.line_color = line_color;
				data.line_thick = line_thick;
				
				try {
					oos.writeObject(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//				//메모리그림판의 그리기 도구를 얻어온다
//				Graphics g = memPan.getGraphics();
//				//원그리기
//				g.setColor(line_color);
//				g.fillOval(pt.x - line_thick/2, pt.y - line_thick, line_thick, line_thick);
//				//grimPan repaint
//				grimPan.repaint();//  paintComponent(g) call
				
			}
			
			
		});
		
		
	}



	private void init_grimpan() {
		// TODO Auto-generated method stub
		
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//super.paintComponent(g);
				
				//메모리상그림판내용->화면에 복사
				g.drawImage(memPan, 0, 0, this);
								
			}
		};
				
		grimPan.setPreferredSize(new Dimension(400, 400));
		
		this.add(grimPan,BorderLayout.WEST);
		
	}



	private void init_message() {
		// TODO Auto-generated method stub
		JPanel p 	= new JPanel(new BorderLayout());
		
		jtf_message = new JTextField();
		jbt_connect = new JButton("연결");
		
		p.add(jtf_message,BorderLayout.CENTER);
		p.add(jbt_connect,BorderLayout.EAST);
		
		//버튼크기설정
		jbt_connect.setPreferredSize(new Dimension(120,0));
		
		//폰트설정
		jtf_message.setFont(font);
		jbt_connect.setFont(font);
		
		//그림판 메뉴
		JPanel grimPanMenu = new JPanel(new GridLayout(1, 3));
		grimPanMenu.setPreferredSize(new Dimension(400, 0));
		
		//선굵기
		Integer [] thick_array = {5,10,15,20,25,30,35,40,45,50};
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		jcb_thick.setFont(font);
		grimPanMenu.add(jcb_thick);
		
		//선색상
		JButton jbt_color = new JButton("선색상");
		grimPanMenu.add(jbt_color);
		
		//지우기
		JButton jbt_clear = new JButton("지우기");
		grimPanMenu.add(jbt_clear);
				
		p.add(grimPanMenu,BorderLayout.WEST);
		
		this.add(p,BorderLayout.SOUTH);
		
		
//---시작:그림판 메뉴 이벤트-----------------------------------------		
		//선굵기(CheckBox Event)
		jcb_thick.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) 
				{
					//System.out.println(e);
					line_thick = (Integer)jcb_thick.getSelectedItem();
				}
			}
		});
		
		//선색상
		jbt_color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Color im_color = JColorChooser.showDialog(MultiChatClient.this, "선색상을 선택하세요", line_color);
				
				//색상선택후 확인버튼 클릭시
				if(im_color!=null) 
					line_color = im_color;
			}
		});
		
		//지우기
		jbt_clear.addActionListener(e->{
				
			Graphics g =  memPan.getGraphics();
			
			g.clearRect(0, 0, 400, 400);
			
			grimPan.repaint();
			
		});
		
		
			
//---끝  :그림판 메뉴 이벤트-----------------------------------------
		
		//버튼이벤트 등록
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Toggle  : true <-> false
				bConnect  = !bConnect;
				
				jbt_connect.setText(bConnect? "끊기" : "연결");
				
				if(bConnect) {//연결
					
					on_connect();
					
				}else {//끊기
					
					on_disconnect();
				}
			
			}
		});//end:버튼이벤트
		

		//jtf_message이벤트 등록
		jtf_message.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {
					
					on_send_message();
					
				}
				
			}
			
		});

		
		
	}



	protected void on_send_message() {
		// TODO Auto-generated method stub
		
		if(bConnect==false)return;
		
		//메시지 창에서 값 읽어오기->공백제거
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//입력된 메시지가 없으면 끝내라
			jtf_message.setText("");//지우기
			return;
		}
		
		//네트워크 전송
		Data data 		= new Data();
		data.protocal 	= Data.CHAT;
		data.nick_name 	= nick_name;
		data.message 	= message;
		
		try {
			oos.writeObject(data);//전송
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//출력메시지 테스트
//		String display_message = String.format("[%s]님 말씀:\r\n  %s\r\n", nick_name, message);
//		jta_display.append(display_message);
//		int position = jta_display.getDocument().getLength();
//		//문서끝에 Caret를 위치시킨다
//		jta_display.setCaretPosition(position);
		
		
		
		jtf_message.setText("");//지우기
		
	}



	protected void on_disconnect() {
		// TODO Auto-generated method stub
		
		try {
			
			//ois.close();
			//oos.close();
			client.close();
			
			Thread.sleep(1000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	protected void on_connect() {
		// TODO Auto-generated method stub
		
		try {
			
			//client = new Socket("localhost", 6000);
			client = new Socket("192.168.0.49", 6000);
			
			//직렬화기능의 객체생성
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			
			//입장메시지 전송
			Data data = new Data();
			data.protocal 	= Data.IN;
			data.nick_name 	= nick_name;
			
			oos.writeObject(data);//전송
			
			//데이터 수신
			read_message();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "연결실패!!");
			bConnect=false;
			jbt_connect.setText("연결");
			
		} 
		
	}



	private void read_message() {
		// TODO Auto-generated method stub
		//수신대기
		new Thread() {
			
			public void run() {
				
				while(true) {
					
					try {
						Data data = (Data) ois.readObject();
						
						if(data==null)break;
						
						if(data.protocal==Data.USERLIST) {
							
							display_user_list(data);
							
						}else if(data.protocal==Data.CHAT) {
							
							String display_message = String.format("[%s] : %s\r\n", 
									                           data.nick_name,  data.message    
									);
							
							jta_display.append(display_message);
							int position = jta_display.getDocument().getLength();
							jta_display.setCaretPosition(position);
							
						}else if(data.protocal==Data.IN) {
							
							String display_message = String.format("=>[%s]님 입장\r\n", data.nick_name);
							
							jta_display.append(display_message);
							int position = jta_display.getDocument().getLength();
							jta_display.setCaretPosition(position);
							
						}else if(data.protocal==Data.OUT) {
							
							String display_message = String.format("<=[%s]님 퇴장\r\n", data.nick_name);
							
							jta_display.append(display_message);
							int position = jta_display.getDocument().getLength();
							jta_display.setCaretPosition(position);
							
						}else if(data.protocal==Data.GRIM) {
							
							Graphics g = memPan.getGraphics();
							
							g.setColor(data.line_color);
							g.fillOval(data.pt.x - data.line_thick/2, 
									   data.pt.y - data.line_thick/2, 
									   data.line_thick, data.line_thick);
							
							grimPan.repaint();
							
							
						}
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						break;
					}
					
					
				}//end:while
				
				//종료상황
				bConnect=false;
				jbt_connect.setText("연결");
				
				//접속자목록 지우기
				jlist_user.setListData(new String[0]);
				
				
			}
			
		}.start();
		
		
	}



	protected void display_user_list(Data data) {
		// TODO Auto-generated method stub
		String [] user_array = new String[data.userList.size()];
		data.userList.toArray(user_array);
		
		jlist_user.setListData(user_array);
		
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
		
				
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatClient();
	}

}
