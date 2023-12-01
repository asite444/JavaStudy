package javaClass.thread;

//Thread 생성법2:수행객체+관리객체 분리
class MyRunnable implements Runnable{
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());

	}
}

public class ThreadExample02 {
	public static void main(String[] args) {

		//쓰레드 수행 객체 생성
		Runnable runnable=new MyRunnable();
		
		//쓰레드 관리객체 생성
		Thread thread=new Thread(runnable,"child");//수행 객체와 해당 쓰레드 명을 명시
		thread.start();
		
	}
}



