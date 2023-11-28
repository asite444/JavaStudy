package gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import gui.mycommon.MyConstant;

public class TurningEyeballs extends JFrame {

	static Image background,chikin,background_red,background_imsi,huck,mogi;
	Timer timer;
	static {

		background=Toolkit.getDefaultToolkit().getImage("image/face.png");
		background_imsi=background;
		background_red=Toolkit.getDefaultToolkit().getImage("image/face_red.png");
		mogi=Toolkit.getDefaultToolkit().getImage("image/mogi.png");
		//huck=Toolkit.getDefaultToolkit().getImage("image/huck.png");
		chikin=Toolkit.getDefaultToolkit().getImage("image/chikin.jpg");

	}

	JPanel grimPan;

	//눈의 위치
	Point eye_left,eye_right;
	int   eye_radius;//눈의 반지름
	Point pt;

	//눈알의 위치
	Point eyeball_left,eyeball_right;
	int   eyeball_radius;

	boolean eyes=true;

	boolean mogi_flying=false;
	//모기 위치
	Point mogi_fly=new Point();
	Random random=new Random();


	public TurningEyeballs() {
		// TODO Auto-generated constructor stub
		super("눈알 돌리기");

		//그림판 초기화
		init_grimpan();

		//눈의 위치 초기화
		init_eye_position();

		//눈알의 위치 초기화
		init_eyeball_position();


		//마우스 이벤트 초기화
		init_mouse_event();

		//키보드 이벤트
		init_mogi_timer();


		//위치
		this.setLocation(700, 30);

		//크기
		//this.setSize(400, 400);
		this.pack();//자식윈도우(grimPan)를 감싸서 프레임을 씌워라

		//크기변경 불가
		this.setResizable(false);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_mogi_timer()  {
		KeyAdapter adapter=new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {//키 눌렸누!
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_S) {

					if(timer==null) {
						ActionListener actionListener=new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								fly_pari();

							}
						};
						timer=new Timer(500,actionListener);
						timer.start();
						mogi_flying=true;
					}
				}
				else if(key==KeyEvent.VK_X) {
					if(timer!=null) {
						timer.stop();
						timer=null;
						grimPan.repaint();
						mogi_flying=false;
					}
				}
				super.keyPressed(e);
			}
		};
		this.addKeyListener(adapter);


	}

	void fly_pari() {

		mogi_fly.x=random.nextInt(MyConstant.GrimPan.WIDTH-10);
		mogi_fly.y=random.nextInt(MyConstant.GrimPan.HEIGHT-10);

		//삼각형의 빗변의 길이
		int x_left=mogi_fly.x-eye_left.x;//밑변
		int y_left=mogi_fly.y-eye_left.y;//높이

		int x_right=mogi_fly.x-eye_right.x;//밑변
		int y_right=mogi_fly.y-eye_right.y;//높이
		//루트값
		double r_left=Math.sqrt(x_left*x_left+y_left*y_left);
		double r_right=Math.sqrt(x_right*x_right+y_right*y_right);

		//빗변의 비율
		double rate_left = eyeball_radius/r_left;
		double rate_right = eyeball_radius/r_right;
		//왼눈알 위치
		eyeball_left.x=(int)(eye_left.x+x_left*rate_left);
		eyeball_left.y=(int)(eye_left.y+y_left*rate_left);

		//오른눈알 위치
		eyeball_right.x=(int)(eye_right.x+x_right*rate_left);
		eyeball_right.y=(int)(eye_right.y+y_right*rate_right);

		//모기가 내 점심에 앉아서 쳐묵고 있다우 동무.자네는 아오지 행이라우.
		if(mogi_fly.x<150 && mogi_fly.y<150) {
			eyeball_radius=25;
			huck=Toolkit.getDefaultToolkit().getImage("image/huck.png");

		}
		else {eyeball_radius= eye_radius/4;
		huck=null;

		}

		//모기가 눈에 들어갔누!
		if(mogi_fly.x<292 && mogi_fly.x>208 && mogi_fly.y<290 && mogi_fly.y>215 || mogi_fly.x<436 && mogi_fly.x>344 && mogi_fly.y<292 && mogi_fly.y>225)
		{
			background=background_red;
			eyes=false;
		}
		else {
			background=background_imsi;
			eyes=true;
		}
		grimPan.repaint();





	}
	private void init_eyeball_position() {
		// TODO Auto-generated method stub
		//최초 눈알의 위치는 눈의 좌표와 동일하다

		//왼쪽눈알
		eyeball_left = new Point(eye_left);

		//오른쪽눈알
		eyeball_right = new Point(eye_right);

		//눈알의 반지름 = 눈의반지름/2
		eyeball_radius = eye_radius/4;


	}

	private void init_eye_position() {
		// TODO Auto-generated method stub
		//왼쪽눈
		eye_left = new Point();
		eye_left.x=254;
		eye_left.y=256;
		//eye_left.x = MyConstant.GrimPan.WIDTH/4;
		//eye_left.y = MyConstant.GrimPan.HEIGHT/2;

		//오른쪽눈
		eye_right = new Point();
		//eye_right.x = MyConstant.GrimPan.WIDTH/4 * 3;
		//eye_right.y = MyConstant.GrimPan.HEIGHT/2;
		eye_right.x=393;
		eye_right.y=251;

		//눈의 반지름
		//eye_radius = MyConstant.GrimPan.WIDTH/4 - 30;
		eye_radius=50;
	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		//class MyMouseAdapter extends MouseAdapter{}

		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {//마우스 클릭
				// TODO Auto-generated method stub
				//super.mousePressed(e);
				//마우스의 위치 구하기
				pt = e.getPoint();
				//System.out.println("pt.x:"+pt.x);
				//System.out.println("pt.y:"+pt.y);
				//System.out.println("이거P");
				//왼쪽눈알 위치 계산
				move_eyeball_left_position(pt);
				//오른쪽눈알 위치 계산
				move_eyeball_right_position(pt);

				if(pt.x<150 && pt.y<150) {
					eyeball_radius=25;
					huck=Toolkit.getDefaultToolkit().getImage("image/huck.png");
				}
				else {
					eyeball_radius= eye_radius/4;
					huck=null;
				}
				if(pt.x<292 && pt.x>208 && pt.y<290 && pt.y>215 || pt.x<436 && pt.x>344 && pt.y<292 && pt.y>225)
				{background=background_red;
				eyes=false;}
				else {background=background_imsi;
				eyes=true;
				}
				//다시그려라
				grimPan.repaint();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseReleased(e);
				init_eyeball_position();
				eyes=true;
				background=background_imsi;
				huck=null;
				//System.out.println("때버림ㅋ");
				grimPan.repaint(); //paintComponent(g) 간접적으로 호출
			}

			@Override
			public void mouseDragged(MouseEvent e) {//마우스 누르고 떼지 않음
				// TODO Auto-generated method stub
				//super.mouseDragged(e);
				//마우스의 위치 구하기
				pt = e.getPoint();
				//System.out.println("이거D");
				//왼쪽눈알 위치 계산
				move_eyeball_left_position(pt);
				//오른쪽눈알 위치 계산
				move_eyeball_right_position(pt);

				if(pt.x<150 && pt.y<150) {
					eyeball_radius=25;
					huck=Toolkit.getDefaultToolkit().getImage("image/huck.png");

				}
				else {eyeball_radius= eye_radius/4;
				huck=null;

				}


				if(pt.x<292 && pt.x>208 && pt.y<290 && pt.y>215 || pt.x<436 && pt.x>344 && pt.y<292 && pt.y>225)
				{background=background_red;
				eyes=false;}
				else {background=background_imsi;
				eyes=true;
				}
				//다시그려라
				grimPan.repaint();

			}

		};

		grimPan.addMouseListener(adapter);
		grimPan.addMouseMotionListener(adapter);

	}

	protected void move_eyeball_right_position(Point pt) {

		//삼각형의 빗변의 길이
		int x=pt.x-eye_right.x;//밑변
		int y=pt.y-eye_right.y;//높이

		//루트값,빗변길이
		double r=Math.sqrt(x*x+y*y);

		//빗변의 비율
		double rate = eyeball_radius/r;

		//왼눈알 위치
		eyeball_right.x=(int)(eye_right.x+x*rate);
		eyeball_right.y=(int)(eye_right.y+y*rate);

	}

	protected void move_eyeball_left_position(Point pt) {
		//삼각형의 빗변의 길이
		int x=pt.x-eye_left.x;//밑변
		int y=pt.y-eye_left.y;//높이
		//루트값
		double r=Math.sqrt(x*x+y*y);

		//빗변의 비율
		double rate = eyeball_radius/r;

		//왼눈알 위치
		eyeball_left.x=(int)(eye_left.x+x*rate);
		eyeball_left.y=(int)(eye_left.y+y*rate);

	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		//		class GrimPan extends JPanel{
		//			//상속받은 클래스 구간
		//			@Override
		//			protected void paintComponent(Graphics g) {
		//				// TODO Auto-generated method stub
		//				super.paintComponent(g);
		//			}
		//		}

		//anonymouse(익명클래스)
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {//다시그리기 메소드 호출시 자동 호출됨

				// TODO Auto-generated method stub
				super.paintComponent(g);


				g.drawImage(background, 0, 0, this);
				g.drawImage(chikin, 10, 10, this);
				g.drawImage(huck, 500, 100, this);




				g.drawImage(mogi, mogi_fly.x, mogi_fly.y, this);

				//눈그리기
				//왼쪽눈
				/*g.drawOval(eye_left.x-eye_radius, 
						eye_left.y-eye_radius, 
						eye_radius*2, 
						eye_radius*2);*/
				//오른쪽눈
				/*g.drawOval(eye_right.x-eye_radius, 
						eye_right.y-eye_radius, 
						eye_radius*2, 
						eye_radius*2);*/

				//눈알그리기
				//왼쪽
				//System.out.println("eyeball_left.x:"+eyeball_left.x);
				//System.out.println("eyeball_radius:"+eyeball_radius);

				if(eyes) {
					g.fillOval(eyeball_left.x - eyeball_radius,
							eyeball_left.y - eyeball_radius, 
							eyeball_radius*2, 
							eyeball_radius*2);
					//오른쪽
					g.fillOval(eyeball_right.x - eyeball_radius,
							eyeball_right.y - eyeball_radius, 
							eyeball_radius*2, 
							eyeball_radius*2);
				}





			}

			//}
		};

		//그림판 크기 예약
		//                      Dimension: width / height
		grimPan.setPreferredSize(new Dimension(MyConstant.GrimPan.WIDTH, MyConstant.GrimPan.HEIGHT));

		this.add(grimPan,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TurningEyeballs();
	}

}