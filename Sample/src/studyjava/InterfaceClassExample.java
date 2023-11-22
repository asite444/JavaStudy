package studyjava;

public class InterfaceClassExample implements InterfaceExample {

	@Override
	public int funcb() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}
	
	@Override
	public int funca(int a,int b) {
		System.out.println("곱하기로 변경");
		return a*b;
	}
    
	public static void main(String[] args) {
		InterfaceExample ie=new InterfaceClassExample();
		//ie.funcb(3,2); <--사용 불가
		InterfaceExample.funcb(3, 2);
		ie.funcc(3, 4);
		
	}
}
