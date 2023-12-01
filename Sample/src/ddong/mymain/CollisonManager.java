package ddong.mymain;

public class CollisonManager {

	Me me;
	DDongManager ddongManager;
	public CollisonManager(Me me, DDongManager ddongManager) {
		this.me = me;
		this.ddongManager = ddongManager;
	}
	
	public boolean check_collison_me_and_ddong() {
		
		for(DDong ddong:ddongManager.ddong_list) {
			
			//나와 똥 충돌 여부
			if(ddong.pos.intersects(me.pos)) {
				return true;
			}
		}
		
		return false;
	}
	
}
