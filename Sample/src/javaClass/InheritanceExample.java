package javaClass;

//상당히 중요한 내용
//상속과 관련된 참조변수 내용
//힙 영역의 하나의 주소에 3가지 클래스가 모두 탑재됨.즉, 같은 영역 

//Object는 첫번째 영역
//2번째 영역
public class InheritanceExample {
	static int number;
	int first=0;

	//InheritanceExample 영역만 사용토록 제한

	static void useInheritanceExample(InheritanceExample ci) {
		System.out.println("----InheritanceExample---");
		int x=3;
		int y=5;
		int res=ci.first;
		System.out.println("-------------------------");
		//ci.second=3; second 변수는 자식 클래스만이 가지고 있음.
	}
	static void useUnlyObjext(Object ob) {
        System.out.println(ob.toString());
        
        int a=2;
        int b;
        //사용 영역 확장하기(강제 형변환)
        //Childtwo클래스를 선언했 으므로 형변환이 가능.
        Childtwo ch=(Childtwo) ob;
        b=ch.plus(a, 3);
        System.out.println(b);
	}
	public static void main(String[] args) {
		/*선언되는 객채에 따라 사용되는 범위 설정
		 * 자동 형변환 
		 * 영역 축소화(up-casting)-- 자식->부모 방향
		 * 영역 확장(down-casting)-- 부모->자식 방향
		 * */
		Childtwo child=new Childtwo(); //1,2,3 영역 전부 
		useInheritanceExample(child);
		Object ob=child; //1번 영역만
		InheritanceExample ie=child;// 1,2 영역만
		child.first=1;
		child.second=2;

		number=3;

		ie.first=3;
		//ie.second=4; //범위외 이므로,사용불가

		//같은 인스턴트 이므로,값은 가장 최후의 값이 반영됨
		System.out.println("first:"+child.first);
		//static 변수를 이런 식으로 쓰는것은 좋지 않으나, 설명을 위함임 
		System.out.println("number:"+child.number);
		
 
		//모두 같은 해시코드
		useUnlyObjext(child);
		
		
		Object ob2=new Object();
		//Object클래스만 생성하고, 해당 클래스가 가진 자식 클래스 정보를 선언하지 않았기 때문에 사용 불가(캐스팅 에러)
		//useUnlyObjext(ob2); 불가,에러발생
		
		//윗쪽에서 Childtwo를 넣었기 때문에 가능함
		useUnlyObjext(ob);
		useUnlyObjext(ie);
	}

}

//3번째 영역
class Childtwo extends InheritanceExample{


	int second;
	
	int plus(int a,int b) {
		return a+b;
	}

}
