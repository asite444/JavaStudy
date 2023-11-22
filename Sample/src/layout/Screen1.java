package layout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Screen1 extends JPanel{

	public Screen1() {
		// TODO Auto-generated constructor stub
		JButton jbt = new JButton("여기는 Screen1");
		this.add(jbt);
		
		this.setBackground(Color.red);
	}
}
