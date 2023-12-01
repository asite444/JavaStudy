package ddong.mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ddong.mycommon.MyConstant;

public class DDongManager {

	public static final int DDONG_INTERVAL = 20;
	
	int ddong_interval = DDONG_INTERVAL;
	
	List<DDong> ddong_list = new ArrayList<DDong>();
	
	
	Random random  = new Random();
	
	Color [] color_array = {  
			                  Color.red,    //0
			                  Color.green,  //1
			                  Color.blue,   //2
			                  Color.yellow, //3 
			                  Color.cyan,   //4
			                  Color.magenta //5
			                };
	
	ExplosionManager explosionManager;
	
	//이미 생성된 똥 정보 받아오기
	public DDongManager(ExplosionManager explosionManager) {
		this.explosionManager = explosionManager;
	}


	public void make_ddong() {
		
		
		if(ddong_interval == DDONG_INTERVAL)
		{
		
			//똥 객체를 계속 생성하여 각각의 똥을 제어한다.
			//각각의 똥들은 list안에 집어넣어지게 되는 것이다.
			DDong ddong = new DDong();
			//위치/크기
		    ddong.pos.x = random.nextInt(MyConstant.GrimPan.WIDTH) - DDong.W/2;
			ddong.pos.y = -DDong.H;
			ddong.pos.width = DDong.W;
			ddong.pos.height= DDong.H;
			
			//색상선택
			int color_index = random.nextInt(color_array.length);
			ddong.color = color_array[  color_index  ];
			
			//속도: 1~3
			ddong.speed = random.nextInt(3)+1;
			ddong_list.add(ddong);
		}//end:if
		
		
		//System.out.println(ddong_interval);
		ddong_interval--;
		if(ddong_interval==0)
			ddong_interval = DDONG_INTERVAL;
		
	}
	
	
	public void draw_all(Graphics g) {
		//개선 loop
		for(DDong ddong : ddong_list) {
			ddong.draw(g);
		}
	}
	
	public void move_all() {
		//첨자방식
		for(int i=0;i<ddong_list.size();i++) {
			DDong ddong = ddong_list.get(i);
			
			if(ddong.move()==true) {
				//화면밖으로 나간경우
				//리스트에서 해당 똥 제거
				explosionManager.make_explosion(ddong.pos.x+DDong.W/2, ddong.pos.y);
				ddong_list.remove(i);
				return;
			}
		}//end:for
		
	}
}
