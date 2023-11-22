package layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCardLayout extends JFrame {

	JPanel mainPanel;
	CardLayout  card;
	
	
	public TestCardLayout() {
		// TODO Auto-generated constructor stub
		super("CardLayout연습");
		
		//상단메뉴
		init_menu();
		
		//중앙화면
		init_screen();
		

		//위치
		this.setLocation(200, 200);

		//크기
		this.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_screen() {
		// TODO Auto-generated method stub
		//카드레이아웃생성
		card = new CardLayout();
		mainPanel = new JPanel(card);
		
		//Frame중앙에 mainPanel넣기
		this.add(mainPanel);	
		
		
		//mainPanel에 화면을 넣는다
		mainPanel.add(new Screen1(),"s1");
		mainPanel.add(new Screen2(),"s2");
		mainPanel.add(new Screen3(),"s3");
		
		
	}

	private void init_menu() {
		// TODO Auto-generated method stub
		
		//JPanel(테두리없는 윈도우)
		JPanel  p = new JPanel(new GridLayout(3, 1));//숫자는 배치 좌표값
		//p.setBackground(Color.red);
		this.add(p, BorderLayout.EAST);
		
		JButton jbt1 = new JButton("화면1");
		JButton jbt2 = new JButton("화면2");
		JButton jbt3 = new JButton("화면3");
		
		//Panel에 버튼 올리기
		p.add(jbt1);
		p.add(jbt2);
		p.add(jbt3);
		
		//버튼이벤트 처리
		jbt1.addActionListener( e->{
			//card.show(mainPanel, "s1");
			card.first(mainPanel);
		} );
		
		jbt2.addActionListener( e->{
			card.show(mainPanel, "s2");
		} );
		
		jbt3.addActionListener( e->{
			//card.show(mainPanel, "s3");
			card.last(mainPanel);
		} );
		
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCardLayout();
	}

}

