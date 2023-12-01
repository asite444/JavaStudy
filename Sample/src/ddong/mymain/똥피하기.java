package ddong.mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import ddong.mycommon.MyConstant;
//나와 똥 겹친 경우(충돌) intersepter
public class 똥피하기 extends JFrame {

	JPanel grimPan;

	Timer  timer;

	ExplosionManager explosionManager=new ExplosionManager();
	DDongManager ddongManager = new DDongManager(explosionManager);//폭발정보 객체로 저장
	DDong ddong=new DDong();

	Me me=new Me();
	
	//Me와ddongManager 정보 담아가기
	CollisonManager collisonManager=new CollisonManager(me, ddongManager);
	public 똥피하기() {
		// TODO Auto-generated constructor stub
		super("똥피하기");

		//그림판 초기화
		init_grimpan();

		//타이머 초기화
		init_timer();

		//내 위치 초기화
		init_me();

		//키보드 초기화
		init_key_event();

		//첫 로딩시 버벅임 방지(편법임)
		explosionManager.make_explosion(-1000, -1000);
		//테스트용 마우스 이벤트
		init_mouse_event();
		
		//위치
		this.setLocation(750, 50);

		//크기
		//this.setSize(400, 400);
		this.pack();

		//크기변경불가
		this.setResizable(false);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_mouse_event() {
		MouseAdapter adapter=new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				Point pt=e.getPoint();
				explosionManager.make_explosion(pt.x, pt.y);
			}
		};
		grimPan.addMouseListener(adapter);
	}

	private void init_key_event() {

		KeyAdapter adapter=new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();

				if(key==KeyEvent.VK_LEFT) {

					me.key_state=me.key_state | MyConstant.Key.LEFT;
					
					


				}else if(key==KeyEvent.VK_RIGHT) {
					me.key_state=me.key_state | MyConstant.Key.RIGHT;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();

				if(key==KeyEvent.VK_LEFT) {

					me.key_state=me.key_state ^ MyConstant.Key.LEFT;


				}else if(key==KeyEvent.VK_RIGHT) {
					me.key_state=me.key_state ^ MyConstant.Key.RIGHT;
				}
			}


		};

		this.addKeyListener(adapter);
	}

	private void init_me() {

		//내 위치는 중앙에
		me.pos.x=MyConstant.GrimPan.WIDTH/2 - Me.W/2;
		me.pos.y=MyConstant.GrimPan.HEIGHT-Me.H-60;
		me.pos.width=Me.W;
		me.pos.height=Me.H;

		me.color=Color.black;
		me.speed=5;
	}

	private void init_timer() {
		// TODO Auto-generated method stub

		ActionListener timer_listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				//이동작업등 작업수행
				process();

				//다시그려라-> paintComponent() call
				grimPan.repaint();


			}
		};

		//          시간:1/1000초   
		timer = new Timer(10, timer_listener);
		timer.start();
	}

	//좌표이동은 전부 여기
	protected void process() {
		// TODO Auto-generated method stub

		//똥만들기
		ddongManager.make_ddong();

		//똥이동시키기
		ddongManager.move_all();
		
		
		
		//나 이동
		//타이머에 의한 작동이므로 부드럽게 됨.
	    me.move();

	    //폭발 이동시키기
	    explosionManager.move_all();
	    
		//System.out.println(ddongManager.ddong_list.size());

	    //충돌 체크
	   if(collisonManager.check_collison_me_and_ddong()) {
		   //dead ->
		   System.out.println("충돌");
		   ddongManager.ddong_list.clear();//똥 전부 삭제
		   explosionManager.explosion_list.clear();
		   
		   //explosionManager.make_explosion(, );
	   };
	}

	private void init_grimpan() {
		

		grimPan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				//똥그리기
				ddongManager.draw_all(g);

				//나 그리기
				me.draw(g);
				
				//폭발 그리기
				explosionManager.draw_all(g);

			}

		};

		//그림판크기를 예약(400x600)
		grimPan.setPreferredSize(new Dimension(MyConstant.GrimPan.WIDTH, MyConstant.GrimPan.HEIGHT));

		this.add(grimPan);//Center에 넣는다

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 똥피하기();
	}

}
