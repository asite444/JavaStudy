package layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InnerClassExample extends JFrame {
	GridLayout gridLayout;
	JLabel jLabel_result;
	JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9;
	//버튼이벤트 처리할 객체선언
	class MyButtonEventObject implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("一")) jLabel_result.setText("一的意识是1。");
			else if(e.getActionCommand().equals("二")) jLabel_result.setText("二的意识是2。");
			
		}
	}
	
	public InnerClassExample() {
		super("내부 클래스");

		ActionListener actionListener01=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("四")) jLabel_result.setText("四的意识是4。");
				else if(e.getActionCommand().equals("五")) jLabel_result.setText("五的意识是5。");
				else if(e.getActionCommand().equals("六")) jLabel_result.setText("六的意识是6。");
			}
		};
		
       ActionListener actionListener02=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob=e.getSource();
				
				if(ob==jButton8) {jLabel_result.setText("八的意识是8。");}
				else if(ob==jButton9) {jLabel_result.setText("九的意识是9。");}
				
			}
		};
		 gridLayout=new GridLayout(10,1);
		this.setLayout(gridLayout);
		jLabel_result=new JLabel(" ",JLabel.CENTER);
		 jButton1=new JButton("一");
		 jButton2=new JButton("二");
		 jButton3=new JButton("三");
		 jButton4=new JButton("四");
		 jButton5=new JButton("五");
		 jButton6=new JButton("六");
		 jButton7=new JButton("七");
		 jButton8=new JButton("八");
		 jButton9=new JButton("九");

		this.add(jLabel_result);
		this.add(jButton1);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jButton5);
		this.add(jButton6);
		this.add(jButton7);
		this.add(jButton8);
		this.add(jButton9);

		//버튼리스너
		//XXXListener으로 구현된 자료형은 모두 interface
		//처리객체 :이벤트 위임받아서 처리할 객체(ActionListener inter로 구현한 객체)
		jButton1.addActionListener(new MyButtonEventObject());
		jButton2.addActionListener(new MyButtonEventObject());
		
		//익명 객체를 더 간편화한 표현법
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				jLabel_result.setText("三的意识是3。");
				
			}
		});
		jButton4.addActionListener(actionListener01);
		jButton5.addActionListener(actionListener01);
		jButton6.addActionListener(actionListener01);
		//익명 객체의 람다식 표현
		jButton7.addActionListener(e->{						
				jLabel_result.setText("七的意识是7。");
			
		});
		
		jButton8.addActionListener(actionListener02);
		jButton9.addActionListener(actionListener02);

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
		new InnerClassExample();

	}

}
