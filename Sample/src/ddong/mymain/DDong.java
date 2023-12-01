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

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		//speed++;
		pos.y += speed;
		
		//      화면아래로 내려갔냐?
		return (pos.y > MyConstant.GrimPan.HEIGHT);
	}

}
