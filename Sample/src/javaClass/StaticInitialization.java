package javaClass;

public class StaticInitialization {
	static int number=0;
	//static 초기화
	static {
		//메인프로그램 시작 전의 준비작업
		//1.DB초기화
		//2.이미지 로딩
		number++;
		System.out.println("0.가장 처음 실행");
	}
	public StaticInitialization() {
		System.out.println("1.생성자 실행");
	}
	
	public static void main(String[] args) {
		StaticInitialization staticInitialization=new StaticInitialization();
		System.out.println("2.그 다음 실행");
		System.out.println(number);
		
	}
}
