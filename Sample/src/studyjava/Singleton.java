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
	private static Gisafirst instance =null;
	private int count=0;

	static public Gisafirst getInstance() {
		if(instance ==null) {
			instance=new Gisafirst();
			return instance;
		}
		return instance;
	}	
	public void count() {count++;}
	public int getCount() {return count;}
}