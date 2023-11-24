package studyjava;

public class AbstractExtendsClassExample extends AbstractClassExample{
     
	public AbstractExtendsClassExample() {
		System.out.println("자식 클래스 생성자");
	}
	
	// 추상 메소드의 구현
	 @Override
	 public void abstractMethod() {
	     System.out.println("Implementation of abstractMethod in MyChildClass");
	 }

	 // myVariable의 초기화 및 사용 예시
	 public void initializeAndPrintVariable() {
	     // 하위 클래스에서 상속받은 변수에 접근하여 초기화
	     setMyVariable(10);

	     // 하위 클래스에서 상속받은 변수를 사용
	     System.out.println("Value of myVariable: " + getMyVariable());
	 }

	 public static void main(String[] args) {
	     // 자식 클래스의 인스턴스 생성
		 AbstractExtendsClassExample abstractExtendsClassExample = new AbstractExtendsClassExample();

	     // 추상 메소드 호출
	     abstractExtendsClassExample.abstractMethod();

	     // 변수 초기화 및 사용
	     abstractExtendsClassExample.initializeAndPrintVariable();

	     // 일반 메소드 호출
	     abstractExtendsClassExample.nonAbstractMethod();
	 }
}
