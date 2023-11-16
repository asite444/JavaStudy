package studyjava;
//정보처리기사 실기 2021년 3회 기출
public class Singleton {

	public static void main(String[] args) {
		
		Gisafirst gisafirst1=Gisafirst.getInstance();
		gisafirst1.count();

		Gisafirst gisafirst2=Gisafirst.getInstance();
		gisafirst2.count();

		Gisafirst gisafirst3=Gisafirst.getInstance();
		gisafirst3.count();
	
		System.out.println(gisafirst1.getCount());
	}

}
class Gisafirst{
	//처음에 한번만 생성됨
	//생성자는 인스턴스를 생성할 때 단 한번만 실행됨,따라서 싱글톤 패턴 형식으로 했으므로,
	//인스턴스는 한번만 생성되었으므로 생성자도 한번만 실행되게 된 것임
	public Gisafirst() { 
		System.out.println("단 한번만 실행됨");
	}
	private static Gisafirst instance =null;
	
	private int count=0;
    private int sum=0;
	static public Gisafirst getInstance() {
		if(instance ==null) {
			instance=new Gisafirst();
			return instance;//이미 생성되어 있으니,기존의 인스턴트를 쓸것
		}
		return instance;
	}	
	public void count() {count++;}
	public int getCount() {return count;}
	
	
}