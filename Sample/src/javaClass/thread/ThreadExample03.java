package javaClass.thread;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/*
이클립스 실행을 위한 쓰레드 예시
코딩 에러 체크 쓰레드
폴더 관리 쓰레드
저장 관리 쓰레드
메뉴 관리 쓰레드
자동완성 관리 쓰레드
.......

*/
public class ThreadExample03 extends JFrame {

	JProgressBar bar_red;
	JProgressBar bar_green;
	JProgressBar bar_blue;

	Thread thread_red;
	Thread thread_blue;
	Thread thread_green;
	
	//쓰레드 실행중 여부
	boolean barRedRunning=true;
	boolean barGreenRunning=true;
	boolean barBlueRunning=true;
	
	//내부클래스 생성-------------------------
	//내부클래스의 자원을 바로바로 사용가능함
	//red Thread
	class RedThread extends Thread{

		@Override
		public void run() {
			//탈출문 없으면 해당 쓰레드는 무한 실행
			while(true) {
				System.out.println(Thread.currentThread().getName());
				//현재 위치 얻어옴
				int value=bar_red.getValue(); 
				value++;
				if(value>bar_red.getMaximum()) 
					value=0;

				bar_red.setValue(value);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {//해당 에러가 발생할 확률은 거의 없으나 자바 프로그램 상 필수적인 선언
					e.printStackTrace();
				}
			}
		}

	}

	//green Thread
	class GreenThread extends Thread{

		@Override
		public void run() {
			//탈출문n 없으면 해당 쓰레드는 무한 실행
			while(true) {
				System.out.println(Thread.currentThread().getName());
				//현재 위치 얻어옴
				int value=bar_green.getValue(); 
				value++;
				if(value>bar_green.getMaximum()) 
					value=0;

				bar_green.setValue(value);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {//해당 에러가 발생할 확률은 거의 없으나 자바 프로그램 상 필수적인 선언
					e.printStackTrace();
				}
			}
		}

	}

	//blue Thread
	class BlueThread extends Thread{

		@Override
		public void run() {
			//탈출문n 없으면 해당 쓰레드는 무한 실행
			while(true) {
				System.out.println(Thread.currentThread().getName());//실행되는 쓰레드의 순서는 알수 없음
				//현재 위치 얻어옴
				int value=bar_blue.getValue(); 
				value++;
				if(value>bar_blue.getMaximum()) 
					value=0;

				bar_blue.setValue(value);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {//해당 에러가 발생할 확률은 거의 없으나 자바 프로그램 상 필수적인 선언
					e.printStackTrace();
				}
			}
		}

	}

	//-----------------------------------
	public ThreadExample03() {
		super("项目");

		//배치방법 변경:Border->Grid
		this.setLayout(new GridLayout(3,1));

		//thread 3개 동작의 시각화

		//red
		bar_red=new JProgressBar();//0~100사이의 범위
		bar_red.setForeground(Color.red);
		this.add(bar_red);
		bar_red.setValue(30); //30까지만 진행

		//green
		bar_green=new JProgressBar();//0~100사이의 범위
		bar_green.setForeground(Color.green);
		this.add(bar_green);
		bar_green.setValue(50); //50까지만 진행

		//blue
		bar_blue=new JProgressBar();//0~100사이의 범위
		bar_blue.setForeground(Color.blue);
		this.add(bar_blue);
		bar_blue.setValue(80); //80까지만 진행

		//Thread 생성 및 구동
		thread_red=new RedThread();
		thread_red.setName("R_Thread");
		thread_red.start();
		
		thread_green=new GreenThread();
		thread_green.setName("G_Thread");
		thread_green.start();

		
		thread_blue=new BlueThread();
		thread_blue.setName("B_Thread");
		thread_blue.start();


		//키 이벤트 초기화
		init_key_event();
		//위치
		this.setLocation(200, 300);

		//크기
		this.setSize(400, 300);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_key_event() {
		KeyAdapter adapter=new KeyAdapter() {
		
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_R) {
					barBlueRunning=!barBlueRunning; //true<->false
					
					if(barBlueRunning) {//재가동
						thread_red.resume();						
					}else {//잠시 대기
						thread_red.suspend();
					}
				} else if(key==KeyEvent.VK_G) {
					barGreenRunning=!barGreenRunning; //true<->false
					
					if(barGreenRunning) {//재가동
						thread_green.resume();						
					}else {//잠시 대기
						thread_green.suspend();
					}
				}else if(key==KeyEvent.VK_B) {
					barBlueRunning=!barBlueRunning; //true<->false
					
					if(barBlueRunning) {//재가동
						thread_blue.resume();						
					}else {//잠시 대기
						thread_blue.suspend();
					}
				}
			}
		};
		
		this.addKeyListener(adapter);
	}

	public static void main(String[] args) {
		new ThreadExample03();

	}

}
