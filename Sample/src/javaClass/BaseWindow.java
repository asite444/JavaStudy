package javaClass;

import javax.swing.JFrame;
//코드 자동 붙여넣기 창>환경설정>java>템플리트에서 넣고싶은 코드 추가하면 됨
//해당 템플릿을 가져가고 싶은 경우 템플리트 화면에서 export(내보내기) 하면 됨

public class BaseWindow extends JFrame {

	public BaseWindow() {
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
		new BaseWindow();

	}

}
