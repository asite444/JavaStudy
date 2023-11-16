package studyjava;

public class Singlton02 {

	private Singlton02() {
		System.out.println("한번만 생성");
	}
	static  Singlton02 instance;
	int  count=0;
	public static Singlton02 getinstance() {
		if(instance==null) instance=new Singlton02();
		return instance;
	}

	public int func() {
		count++;
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) throws InterruptedException {

		int number;
		while(true) {	
			Singlton02  singlton02=Singlton02.getinstance();
			number=singlton02.func();
			Thread.sleep(1000);
			if(number==10) break;


		}
	}

}
