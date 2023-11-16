package javaClass;

import java.util.Scanner;

public class VendingMachine {
	public final static int COLA=0;
	public final static int JUICE=1;
	public final static int CYDER=2;
	public final static int MILK=3;

	private int[] dringkPrice = {1500,2000,3000,2500};
	private String[] dringkName  = {"콜라","솔의눈","사이다","서울우유"};

	private int price;
	private String name;

	public void insertCoin(int price) {
		this.price=price;
	}
	public void selectDrink(String name) {
		this.name=name;

	}
	public void show() {

		int select=0;
		if(name.equals("1") || name.equals("콜라")) select=COLA;
		else if (name.equals("2") || name.equals("솔의눈")) select=JUICE;
		else if (name.equals("3") || name.equals("사이다")) select=CYDER;
		else if (name.equals("4") || name.equals("서울우유")) select=MILK;
		else {System.out.println("다시 선택할 것!");}
		
		if(price<dringkPrice[select]) System.out.println("돈 없네? 꺼져");
		else {
			System.out.println(dringkName[select]);
			System.out.println("거스름돈:"+(price-dringkPrice[select]));
		}


	}


	public static void main(String[] args) {
		VendingMachine vendingMachine=new VendingMachine();
		Scanner scanner=new Scanner(System.in);

		while(true) {
			System.out.print("금액:");
			vendingMachine.insertCoin(scanner.nextInt());
			System.out.println("음료선택(1.콜라 2.솔의눈 3.사이다 4.서울우유)");
			vendingMachine.selectDrink(scanner.next());

			vendingMachine.show();
			System.out.println("다시 뽑을겨?(y/n)");
			if(scanner.next().equalsIgnoreCase("n")) break;
		}
		System.out.println("종료");
	}

}
