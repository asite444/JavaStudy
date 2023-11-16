package javaClass;

import java.util.Calendar;

public class ConstructorTime {
	
	Calendar calendar=Calendar.getInstance();
	private int hour;
	private int minute;
	private int second;
	
	public ConstructorTime() {
		
		
		this.hour=calendar.get(Calendar.HOUR_OF_DAY);
		this.minute=calendar.get(Calendar.MINUTE);
		this.second=calendar.get(Calendar.SECOND);
	}
	
	public ConstructorTime(int hour) {
		
		this.hour=hour;
		this.minute=calendar.get(Calendar.MINUTE);
		this.second=calendar.get(Calendar.SECOND);
	}
	
	public ConstructorTime(int hour,int minute) {
		this.hour=hour;
		this.minute=minute;
		this.second=calendar.get(Calendar.SECOND);
	}

	public ConstructorTime(int hour,int minute,int second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	
	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public void display1() {
		if(hour>12) System.out.println(hour+":"+minute+":"+second);
		else System.out.println("0"+hour+":"+minute+":"+second);
	}
	public void display2() {
		if(hour>12) System.out.println(hour+"시"+minute+"분"+second+"초");
		else System.out.println("0"+hour+"시"+minute+"분"+second+"초");
	}
	public void display3() {
		if(hour>12)		System.out.println("0"+(hour-12)+":"+minute+":"+second); 
		else System.out.println("0"+hour+":"+minute+":"+second);
	}

	public static void main(String[] args) {
		ConstructorTime constructorTime1=new ConstructorTime();
		constructorTime1.display1();
		constructorTime1.display2();
		constructorTime1.display3();
		System.out.println("----------------------------------");
		ConstructorTime constructorTime2=new ConstructorTime(13);
		constructorTime2.display1();
		constructorTime2.display2();
		constructorTime2.display3();
		System.out.println("----------------------------------");
		ConstructorTime constructorTime3=new ConstructorTime(3,10);
		constructorTime3.display1();
		constructorTime3.display2();
		constructorTime3.display3();
		System.out.println("----------------------------------");
		ConstructorTime constructorTime4=new ConstructorTime(2,10,25);
		constructorTime4.display1();
		constructorTime4.display2();
		constructorTime4.display3();
	}

}
