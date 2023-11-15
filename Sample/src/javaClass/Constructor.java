package javaClass;

public class Constructor {
	 String city;
	 String nation;
	 int nationcode;

	Constructor(){
		this("북경","중국",82);
		System.out.println("인자가 없는 부모 생성자");
		System.out.println();
		
	}
	Constructor(String city,String nation,int nationcode){
		System.out.println("인자가 존재하는 생성자 호출(부모)");
		this.city=city+"  부모";
		this.nation=nation+"  부모";
		this.nationcode=nationcode;
		System.out.println();
	}
	
	public void getPrint() {
		System.out.println("부모 메서드");
		System.out.println(city);
		System.out.println(nation);
		System.out.println(nationcode);
		System.out.println();
	}


	public static void main(String[] args) {
		
		Constructor child=new Child();
		System.out.println("-----------------------------------------");
		Child child2=new Child();
		child.getPrint();
		
		System.out.println("-----------------------------------------");
		child2.getPrint();
		
		
	}
}

class Child extends Constructor{
	public Child() {
		this("북경","중국",82);
		System.out.println("인자가 없는 자식 생성자");
		System.out.println();
	}

	@Override
	public void getPrint() {
		super.getPrint();
		System.out.println("------------------------");
		System.out.println("자식 메서드");
		System.out.println(city);
		System.out.println(nation);
		System.out.println(nationcode);
		System.out.println();
	}
	
	Child(String city,String nation,int nationcode){
		System.out.println("인자가 존재하는 생성자 호출(자식)");
		this.city=city+" 자식";
		this.nation=nation+" 자식";
		this.nationcode=nationcode+100;
		System.out.println();
	}
}

class ChildSecond extends Child{
	public ChildSecond() {
		this("북경","중국",82);
		System.out.println("자식의 자식 생성자");
	}

	ChildSecond(String city,String nation,int nationcode){
		super(city,nation,nationcode);
	}
}