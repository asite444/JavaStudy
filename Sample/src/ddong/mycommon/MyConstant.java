package ddong.mycommon;

public class MyConstant {

	//그림판상수
	public static class GrimPan{
		
		public static final int WIDTH  = 400;
		public static final int HEIGHT = 600;
		
	}
	
	//키상수
	public static class Key{
		//현재 사용
		public static final int NONE=0;
		public static final int LEFT=1;
		public static final int RIGHT=2;
		
		
		public static final int UP=4;
		public static final int DOWN=8;
		
		//OR연산,현재 안씀
		public static final int LEFTUP=LEFT | UP;
	}
	
	
}