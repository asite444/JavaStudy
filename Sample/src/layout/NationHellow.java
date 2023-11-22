package layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NationHellow extends JFrame {

	public NationHellow() {
		super("项目");

		//위치
		this.setLocation(200, 300);

		this.setLayout(new GridLayout(7,1));
		JButton jbt_ch=new JButton("你好");
		JButton jbt_ch1=new JButton("早时间");
		JButton jbt_ch2=new JButton("招呼");
		this.add(jbt_ch);
		this.add(jbt_ch1);
		this.add(jbt_ch2);
		jbt_ch.addActionListener(e->{
			JOptionPane.showMessageDialog(this, "你好");
		});
		
		jbt_ch1.addActionListener(e->{
			JOptionPane.showMessageDialog(this, "早上好！","汉语对话一",JOptionPane.INFORMATION_MESSAGE);
		});
		jbt_ch2.addActionListener(e->{
			JOptionPane.showMessageDialog(null, "你身体好吗！");//경고창 위치 컴퓨터 중앙
		});
		//크기
		this.setSize(400, 300);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new NationHellow();

	}

}

