package javaClass;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;

//AWT(Abstract Window Toolkit)
/*
 awt
   ㄴswing
 Frame     	<-awt
   ㄴJFrame <-swing
 */
public class MyWindow  extends JFrame{

	//초기화 기능 구현
	public MyWindow() {
		//타이틀 작성
		super("我第一次做的视窗。");//super.setTitle("我第一次做的视窗。");
		
		//버튼 생성
		
		JButton jButtonSenter=new JButton("你好！");
	    this.add(jButtonSenter);
		JButton jButtonSouth=new JButton("结束");
	    this.add(jButtonSouth,"South");
	    
	   
	  	JButton jButtonNorth=new JButton("选择");
	    this.add(jButtonNorth,"North");
	    
	    JButton jButtonEast=new JButton("更改标题");
	    this.add(jButtonEast,"East");
	    
	    JButton jButtonWest=new JButton("推荐");
	    this.add(jButtonWest,"West");
		super.setLocation(200,200);
		
		//버튼 이벤트 처리(JDK8.0 이후 :Lambda 식 (인자)->{구현 코드})
		jButtonNorth.addActionListener(e -> {
	    	//프로그램 종료
	    	System.exit(0);
	    });
	    
		jButtonEast.addActionListener(e->{
			super.setTitle("把点击东侧按钮了");
		});
	    
		
		//크기 설정
		super.setSize(500, 300);
		
		//display
		super.setVisible(true);
		
		//종료코드<--없으면 x눌러도 화면만 꺼지고 실행 안 멈춤
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	
	}
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		
		new MyWindow();
		
	
	}

}
