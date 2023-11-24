package studyjava;
public class OuterClass {
    private int outerVariable = 10;

    public void outerMethod() {
        System.out.println("Outer Method");
    }

    public class InnerClass {
        private int innerVariable = 20;

        public void innerMethod() {
            System.out.println("Inner Method");
            System.out.println("Accessing outer variable from inner class: " + outerVariable);
            outerMethod(); // 외부 클래스의 메소드 호출
        }
    }

    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();

        innerObj.innerMethod(); // 내부 클래스의 메소드 호출
    }
}
