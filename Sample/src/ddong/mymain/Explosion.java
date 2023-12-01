package ddong.mymain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Explosion extends Item {

	public static final int W=128;
	public static final int H=128;
	static Image [] exp_array=new Image[27];//이미지 객체는 직렬화 안됨 
	
	static {
		for(int i=0;i<27;i++) {
			String filename=String.format("image/exp/exp_%d.png", i+1);
			exp_array[i]=Toolkit.getDefaultToolkit().getImage(filename);
		}
	}
	//이미지 인덱스
	int index=0;
	@Override
	public void draw(Graphics g) {
		
		g.drawImage(exp_array[index],pos.x,pos.y,null);

	}
	public static final int INDEX_INTERVAL=2;
	int index_interval=INDEX_INTERVAL;
	@Override
	public boolean move() {
		if(index_interval==INDEX_INTERVAL) {
		index++;
		}
		index_interval--;
		if(index_interval<0) {
			index_interval=INDEX_INTERVAL;
		}
		//이미지 다 돌았는가!
		if(index==exp_array.length-1) return true;
		return false;
	}

}
