package studyjava;

public abstract class AbstractClassExample {
	
	public AbstractClassExample() {
		System.out.println("추상 클래스 생성자");
	}
	
	
	// 추상 메소드 선언 (하위 클래스에서 반드시 구현되어야 함)
    public abstract void abstractMethod();

    // 인스턴스 변수 선언 (하위 클래스에서 초기화 가능)
    private int myVariable;

    // 일반 메소드 구현
    public void nonAbstractMethod() {
        System.out.println("This is a non-abstract method.");
    }

    // 인스턴스 변수에 대한 Getter 및 Setter 메소드
    public int getMyVariable() {
        return myVariable;
    }

    public void setMyVariable(int myVariable) {
        this.myVariable = myVariable;
    }
}

