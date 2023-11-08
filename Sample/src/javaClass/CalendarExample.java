package javaClass;

import java.util.Calendar;

public class CalendarExample {
public static void main(String[] args) {
	//싱글톤 패턴
	Calendar today=Calendar.getInstance();
	
	int current_year=today.get(Calendar.YEAR);
	
	System.out.println(current_year);
	
}
}
