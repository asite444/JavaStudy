package studyjava;

public class InterfaceClassExample implements InterfaceExample {
	// default 메소드를 오버라이딩
    @Override
    public void myDefaultMethod() {
        System.out.println("Overridden default implementation in class");
    }

    // static 메소드를 오버라이딩 (불가능)
    // 오류 발생: "myStaticMethod() in MyClass cannot override myStaticMethod() in MyInterface"
    // static 메소드는 인터페이스의 일부가 아니라 클래스 레벨에서 호출되므로 오버라이딩 불가
    // @Override
    // public static void myStaticMethod() {
    //     System.out.println("Overridden static method in class");
    // }

    @Override
    public void myInterMethod() {
    	System.out.println("인터페이스 오버라이딩");
    	
    }
    public static void main(String[] args) {
    	InterfaceExample obj = new InterfaceClassExample();
    	//InterfaceClassExample obj = new InterfaceClassExample(); //다형성, 위 코드와 동일
        obj.myDefaultMethod();  // 오버라이딩된 default 메소드 호출

        InterfaceExample.myStaticMethod();  // 인터페이스의 static 메소드 직접 호출
    }
}
