package layout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestMoveBall extends JFrame {

	//상수
	public static final int GRIMPAN_W	= 600;
	public static final int GRIMPAN_H	= 400;

	//-------------------------------------------------------------------------		
	//그림판
	class GrimPan extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			if(timer.isRunning()) super.paintComponent(g);

			//공그리기
			g.setColor(Color.red);
			g.fillOval(ball_x, ball_y, ball_size, ball_size);
		}

	}
	//-------------------------------------------------------------------------	

	JPanel grimPan;

	Timer timer;

	//공의 정보
	int ball_size=30;
	int ball_x = GRIMPAN_W/2 - ball_size/2;
	int ball_y = GRIMPAN_H/2 - ball_size/2;


	boolean bRight = true;//우측
	boolean bDown  = true;//아래쪽



	public TestMoveBall() {
		// TODO Auto-generated constructor stub
		super("공굴리기");

		//그림판 초기화
		init_grimpan();

		//타이머 초기화
		init_timer();

		init_key_event();

		//위치
		this.setLocation(200, 200);

		//크기
		//this.setSize(400, 400);
		this.pack();//포장(자식윈도우크기에 맞게 Frame이 주변을 씌운다)

		//크기조절불가
		this.setResizable(false);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_key_event() {

		//이벤트소스.addXXXListener(처리객체)
		//							처리객체:XXXListener 인터페이스를 준비한 객체
		//위임 이벤트 모델
		KeyListener keyListener=new KeyListener() {
			
			//키 눌림?
			
			@Override
			public void keyTyped(KeyEvent e) {//키 타입
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {//키보드 뗌
				
				
			}
			

			public void keyPressed(KeyEvent e) {//가장 자주 사용,키 입력
				
				//System.out.println(e);
				int key=e.getKeyCode();//입력키값
				//System.out.println(key);
				//키값을 상수로 선언: VK_A  VK_LEFT VK_= VK_ENTER(가상키)
				if(key==KeyEvent.VK_LEFT) {
					if(timer.isRunning())bRight=false;
					else {
						ball_x=ball_x-20;
						grimPan.repaint();
						}
					
				}else if(key==KeyEvent.VK_RIGHT) {
					if(timer.isRunning())bRight=true;
					else {
						ball_x=ball_x+20;
						grimPan.repaint();
						}
				}else if(key==KeyEvent.VK_UP) {
					if(timer.isRunning()) bDown=false;
					else {
						ball_y=ball_y-20;
						grimPan.repaint();
					}
					
				}else if(key==KeyEvent.VK_DOWN) {
					if(timer.isRunning()) bDown=true;
					else {
						ball_y=ball_y+20;
						grimPan.repaint();
					}
				}else if(ball_size<=100&&(key==KeyEvent.VK_ADD || key==KeyEvent.VK_EQUALS )) {
					ball_size++;
				}else if(ball_size>=10 &&(key==KeyEvent.VK_MINUS || key==KeyEvent.VK_SUBTRACT)) {
					ball_size--;
				}else if(key==KeyEvent.VK_ENTER) {
					//타이머 시작
					if(!timer.isRunning())	timer.start();
					else timer.stop();
				}
			}
			
		};
		
		this.addKeyListener(keyListener);
		
		
	}

	private void init_timer() {
		// TODO Auto-generated method stub

		ActionListener timer_listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer_function();
			}
		};

		//       
		// 지정된 시간간격으로 timer_function() 호출
		//                100FPS(Frame Per Second)
		//                시간         호출객체  
		timer = new Timer(10,  timer_listener );

		timer.start();
	
		

	}

	int gan = 5;
	void timer_function() {
		//System.out.println("----");

		//공의 좌표변경

		//좌우이동
		if(bRight)
			ball_x +=gan;//우측이동
		else
			ball_x -=gan;//좌측이동


		//우측벽에 닿았냐?
		if( (ball_x + ball_size) > GRIMPAN_W) {
			ball_x=GRIMPAN_W-ball_size;
			bRight = false;
		}

		//왼쪽벽에 닿았냐?
		if(ball_x < 0) {
			ball_x=0;
			bRight= true;
		}

		//상하이동
		if(bDown)
			ball_y +=gan;//아래이동
		else
			ball_y -=gan;//위로이동


		//아래벽에 닿았냐?
		if( (ball_y + ball_size) > GRIMPAN_H) {
			ball_y=GRIMPAN_H - ball_size;
			bDown = false;
		}

		//윗벽에 닿았냐?
		if(ball_y < 0) {
			ball_y=0;
			bDown= true;
		}


		grimPan.repaint();// paintComponent() call
	}


	void init_grimpan() {

		//그림판 생성
		grimPan = new GrimPan();
		//그림판 크기를 예약
		grimPan.setPreferredSize(new Dimension(GRIMPAN_W, GRIMPAN_H));

		this.add(grimPan,"Center");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestMoveBall();
	}

}
