package javaClass;

import java.util.Scanner;
import myutill.Jumin;
public class JuminNumber {

	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		Jumin jumin=new Jumin();
		
		
		while(true) {
		System.out.print("주민번호(xxxxxx-xxxxxxx):");
		jumin.setJuminNo(scanner.next());
				
		System.out.println("출생연도:"+jumin.getYear()+jumin.getGabja()+"년");
		System.out.println("출생 계절:"+jumin.getSeason());
		System.out.println("출생 지역:"+jumin.getArea());
		System.out.println("나이:"+jumin.getAge());
		System.out.println("띠:"+jumin.getTti());
		
		break;
		}

	}

}
