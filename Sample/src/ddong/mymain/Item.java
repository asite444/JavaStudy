package ddong.mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {

	//위치정보
	Rectangle pos  = new Rectangle();
	
	//색상정보
	Color color = Color.red;
	
	//이동속도
	int speed;
	
	//그려라
	public abstract void draw(Graphics g);
	//이동해라
	public abstract boolean move();
	
}
