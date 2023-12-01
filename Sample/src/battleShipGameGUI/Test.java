package battleShipGameGUI;

import javax.swing.JFrame;

public class Test extends JFrame {

	public Test() {
		super("项目");

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
		new Test();

	}

}

