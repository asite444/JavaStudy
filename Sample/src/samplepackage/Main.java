package samplepackage;



interface Inter{
	int a=3;
	void mathod01(int b);
	//void mathod02();
}
public class Main {
	


	
	public static void main(String[] args) {

		try {
			System.out.println(3/0);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	
	};
}


