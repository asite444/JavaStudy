package ddong.mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ExplosionManager {

	List<Explosion> explosion_list=new ArrayList<Explosion>();

	//폭발 위치
	public void make_explosion(int x,int y) {
		Explosion explosion=new Explosion();
		
		//폭팔 위치
		explosion.pos.x=x-Explosion.W/2;
		explosion.pos.y=y-Explosion.H/2;
		explosion_list.add(explosion);
		
	}
	
	//
   public void draw_all(Graphics g) {
	   
	   for(Explosion explosion:explosion_list) {
		   explosion.draw(g);
	   }
	   
	   
	   
   }
   
   public void move_all() {
	   for(int i=0;i<explosion_list.size();i++) {
		   Explosion explosion=explosion_list.get(i);
		   //현재 이미지가 다 출력 되었다면(27장)
		   if(explosion.move()) {
			   explosion_list.remove(i);
			   return;
		   }
	   }
   }
}
