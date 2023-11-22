package layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowLayout extends JFrame {

	public TestFlowLayout() {
		super("FlowLayout");

		//Layout 변경
		FlowLayout fl=new FlowLayout(FlowLayout.LEFT,10,10);
		this.setLayout(fl);
		
		for(int i=0;i<20;i++) {
		this.add(new JButton("BT"+(i+1)));
		}
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
		new TestFlowLayout();

	}

}
