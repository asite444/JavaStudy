package javaClass.thread;

//Thread 생성법:Thread상속받아 생성(수행 및 관리객체 통합)
class MyThread extends Thread{
	//가장 중요한 메소드,Thread가 수행하는 코드 
	//run()메소드가 종료될 경우 스레드는 소멸
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		super.run();
	}
}

public class ThreadExample01 {

	public static void main(String[] args) {
		//현재 실행중인 쓰레드명
		//Primary Thread(주쓰레드 or 메인쓰레드)
		System.out.println(Thread.currentThread().getName());

		//Sub Thread/Child Thread
		Thread thread=new MyThread();//쓰레드 객체 생성
		thread.setName("child");//thread명 
		
		thread.start();//쓰레드 구동->runable(쓰레드 대기방)
		//thread.run();//쓰레드를 생성한게 아님,절대 이런식으로 하면 안됨
	}

}
