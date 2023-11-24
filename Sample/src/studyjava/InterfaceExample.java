package studyjava;

public interface InterfaceExample {
/*
	인터페이스에서 변수를 선언할 때, 해당 변수는 기본적으로 public, static, final이어야 한다.
	변수를 선언하면서 초기값을 할당하는 것이 가능하며, 이 때 final 키워드를 사용하여 상수로 선언가능하다.
	Java 8부터는 인터페이스에서도 default 메소드를 통해 초기값을 제공할 수 있다.
*/
	public static final int POINT_STATIC = 30;
	//pulbic,final은 생략된 암시적 명시,즉 상속 클래스가 변경불가. 
                        String   FRONT_NAME="그룹웨어";
	//Java8 버전부터 default,static 키워드가 있는 메소드는 인터페이스에서도 구현이 되며,default의 경우,구현은 선택
	default void myDefaultMethod() {
		System.out.println("Default implementation in interface");
	}

	//static로 구현한 메소드의 경우, 상속받은 클래스에서 오버라이딩을 할수 없다.
	static  void myStaticMethod() {
		System.out.println("Static method in interface");
	}

	//상속받은 클래스는 반드시 해당 추상 메소드를 구현하여야 한다.abstract 키워드는 생략 가능
	/*abstract*/ void  myInterMethod();

	//반드시 본문을 구현해야 한다.
	//static void funcc(int a,int b);
}
