package ddong.mymain;

import java.awt.Graphics;

import ddong.mycommon.MyConstant;

public class DDong extends Item{

	public static final int W = 60;
	public static final int H = 20;
	
	public DDong() {
		// TODO 자동 생성된 생성자 스텁
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
		
	}

	double t=0.01;
	@Override
	public boolean move() {
		double h=0.5*9.8*t*t;
		
		 pos.y += speed;
		 pos.y=(int)(pos.y+h);
		 t=t+0.005;
		//System.out.println(speed);
		
		
		//      화면아래로 내려갔냐?
		return (pos.y > MyConstant.GrimPan.HEIGHT);
	}

}
