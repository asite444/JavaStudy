package studyjava;

/*
 익명 객체
 class 선언시, class명을 명시하고 클래스를 선언하거나,class,interface 상속하여 명시클래스 재정의하는등의 이름을 명시하는 선언과 달리
 익명 객체는 class선언시 class 명을 선언하지 않고 객체를 선언하는 것이다.
 이때,반드시 상속으로 선언하여야 한다. 상속 없는 익명 객체는 만들수 없다.
 */
public class AnonymousObject {

	public static void main(String[] args) {
		Rectangle a = new Rectangle();

		// 익명 객체 1 (자식클래스 상속)
		Rectangle anonymous1 = new Rectangle() {

			@Override
			int get() {
				return width;
			}
		};

		System.out.println(a.get());
		System.out.println(anonymous1.get());
		System.out.println(anonymous2.get());
	}

	// 익명 객체 2 (자식클래스 상속)
	static Rectangle anonymous2 = new Rectangle() {

		int depth = 30;
		@Override
		int get() {
			return width * height * depth;
		}
	};
}

class Rectangle {

	int width = 10;
	int height = 20;

	int get() {	
		return height;
	}
}