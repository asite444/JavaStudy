package gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class TestMouseEvent extends JFrame {

	public TestMouseEvent() {
		// TODO Auto-generated constructor stub
		super("마우스 이벤트");

		//마우스 이벤트 초기화
		init_mouse_event();
		
		
		//위치
		this.setLocation(200, 200);

		//크기
		this.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		
		MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseReleased:떼었을때--");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mousePressed:눌렸을때--");
				
				//어느위치가 눌렸냐?
				Point pt = e.getPoint();
				System.out.printf("x=%d  y=%d\n", pt.x, pt.y);
				
				//어느버튼 클릭했냐?
				int button = e.getButton();
				
				if(button==MouseEvent.BUTTON1) {
					System.out.println("마우스 왼쪽버튼 클릭!!");
				}else if(button==MouseEvent.BUTTON2) {
					System.out.println("마우스 미들버튼 클릭!!");
				}else if(button==MouseEvent.BUTTON3) {
					System.out.println("마우스 오른쪽버튼 클릭!!");
				}
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseExited:마우스포인터가 나갔을때--");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseEntered:마우스포인터가 들어왔을때--");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseClicked:눌렀다떼었을때--");
			}
		};
		
		MouseMotionListener mouseMotionListener = new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseMoved--");
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("--mouseDragged--");
			}
		};
		
		
		//이벤트소스.addMouseListener(처리객체);
		this.addMouseListener(mouseListener);
		
		//마우스가 움직일때 이벤트
		this.addMouseMotionListener(mouseMotionListener);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestMouseEvent();
	}

}
