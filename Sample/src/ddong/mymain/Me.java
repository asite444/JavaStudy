package ddong.mymain;

import java.awt.Graphics;

import ddong.mycommon.MyConstant;

public class Me extends Item {

	public static final int W=30;
	public static final int H=30;
	
	//키 눌림 상태 관리
	int key_state=MyConstant.Key.NONE; //0
	
	@Override
	public void draw(Graphics g) {
	
		//나 그리기
		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
		
	}

	@Override
	public boolean move() {
		if(key_state==MyConstant.Key.LEFT) {
			
			pos.x-=speed;
			if(pos.x<-W/2)
				pos.x=-W/2;
		}else if(key_state==MyConstant.Key.RIGHT) {
			pos.x+=speed;
			if(pos.x>MyConstant.GrimPan.WIDTH-20)			
			pos.x=MyConstant.GrimPan.WIDTH-20;
		
			
		} 
		return false;
	}

}
