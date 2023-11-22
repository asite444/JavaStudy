package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestBorderLayout extends JFrame {

	public TestBorderLayout() {
		super("项目");

		//LayoutManger(배치방법)
		//BorderLayout  ->Frame or JFrame
		//FlowLayout   	->Panel or JPanel
		//GridLayout
		//CardLayout
		
		//BorderLayout
		
		//파라미터 순서 무관
		this.add(new Button("East Button"),"East");
		this.add(new JButton("West Button"),BorderLayout.WEST);
		this.add("South",new JButton("South Buttton"));
		this.add(BorderLayout.NORTH,new JButton("북"));
		this.add(new JButton("Center"));
		//위치
		this.setLocation(200, 300);

		//크기
		this.setSize(400, 300);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new TestBorderLayout();

	}

}
