package layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GrimPan extends JPanel{
	
	static Image back_image;
	static Image bird_image;
	
	static {
	    back_image = Toolkit.getDefaultToolkit().getImage("image/back.jpg");	
	    bird_image = Toolkit.getDefaultToolkit().getImage("image/앵무새1.png");	
	}
	
	Font font = new Font("굴림체", Font.BOLD, 30);
	
	//현재화면이 변경되면 자동호출
	//사용자 요구에 의해서 호출 : grimPan.repaint();
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//배경이미지 그리기
		g.drawImage(back_image, 0, 0, this);
		
		g.drawImage(bird_image, 300, 200, this);
		//Graphics : 그리기도구(연필/붓)
		
		//폰트적용
		g.setFont(font);
				
		//문자열출력                           x    y
		
		//그림자
		g.setColor(Color.black);
		g.drawString("자바 그래픽스 연습하기", 60+1, 50+1);
		//원본
		g.setColor(Color.red);
		g.drawString("자바 그래픽스 연습하기", 60, 50);
		
		//도형그리기
		g.setColor(Color.blue);
		
		//사각형    x   y   W     H
		g.drawRect(60, 80, 100, 100); //테두리만
		
		g.fillRect(180, 80, 100, 100); //채워서그리기
		
		g.drawRoundRect(300, 80, 100, 100, 20,20); //채워서그리기
		
		//타원
        g.setColor(Color.green);	
        
        g.drawOval(60,  200, 100, 100); //테두리만
		
		g.fillOval(180, 200, 100, 100); //채워서그리기 
		
		//선
		for(int i=0;i<256;i++) {
			
			Color color= new Color(0,0,i);
			g.setColor(color);
			
		    g.drawLine(60, 320+i, 400, 320+i);
		}
		
		
		
		
	}
}



public class TestGraphics extends JFrame {

	JPanel grimPan;
	
	public TestGraphics() {
		// TODO Auto-generated constructor stub
		super("타이틀");

		//그림판 생성
		grimPan = new GrimPan();
		//현재 Frame중앙에 배치
		this.add(grimPan);
		
		
		
		//위치
		this.setLocation(700, 100);

		//크기
		this.setSize(500, 500);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//그리기 도구 얻는다
		//Graphics g = grimPan.getGraphics();
		//g.drawString("안녕하세요", 50, 50);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestGraphics();
	}

}
