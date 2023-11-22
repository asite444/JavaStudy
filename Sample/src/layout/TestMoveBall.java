package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
			super.paintComponent(g);
			
			//공그리기
			g.setColor(Color.red);
			g.fillOval(ball_x, ball_y, ball_size, ball_size);
		}
		
	}
//-------------------------------------------------------------------------	
	
	JPanel grimPan;
	
	Timer timer;
	
	//공의 정보
	int ball_x = 0;//GRIMPAN_W/2;
	int ball_y = GRIMPAN_H/2;
	int ball_size=30;
	
	public TestMoveBall() {
		// TODO Auto-generated constructor stub
		super("공굴리기");
		
		//그림판 초기화
		init_grimpan();
		
		//타이머 초기화
		init_timer();
		
		
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
	
	
	private void init_timer() {
		// TODO Auto-generated method stub
		
		// 지정된 시간간격으로 timer_function() 호출
		//                시간         호출객체  
		timer = new Timer(10,  e->{ timer_function(); } );
		
		//타이머 시작
		timer.start();
		
	}
	
	void timer_function() {
		//System.out.println("----");
		ball_x ++;
		
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
