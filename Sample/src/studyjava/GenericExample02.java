package studyjava;

public class GenericExample02 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		A<String> a=new A<String>();
		a.str=" ";

		A<String> a2=new A<String>();
		

		ClassName<Integer> cls=new ClassName<Integer>();
		

	}

}


class ClassName2 <E extends Comparable<? super E>> { 

	E str;	

}
class A<E extends String>{

	int a;
	E str;
  
	public E usefunc(E e) {
    	return e;
    }

	public <E> E hellow(E e) {
		System.out.println(e+" 입니다!");
		return e;
	}

}


class B<E extends A> extends A{
	E str2;
	int b;
}