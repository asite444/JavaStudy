package studyjava;

public interface InterfaceExample {

	//Java8 버전부터 default,static 키워드가 있는 메소드는 인터페이스에서도 구현이 되고,반드시 구현해야 한다.
	default  int funca(int a,int b) {
		System.out.println("더하기");
		return a+b;
	}
	
	int funcb();
	
	//오버로딩
	static int funcb(int a,int b) {
		System.out.println("빼기");
		return a-b;
	}
	
	
	default  int funcc(int a,int b) {
		System.out.println("더하기 후 2배");
		return (a+b)*2;
	}
	
	//static void funcc(int a,int b);//반드시 본문을 구현해야 한다.
}
