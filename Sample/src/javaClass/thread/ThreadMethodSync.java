package javaClass.thread;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreadMethodSync extends JFrame {

	JButton jbt_red;
	JButton jbt_yellow;
	JButton jbt_blue;

	Thread t_red;
	Thread t_yellow;
	Thread t_blue;

	Object syncObject=new Object();


	//내부클래스------------------------------------------------------
	class SignalRunnable /*extends Object*/ implements Runnable{

		//메소드 쓰레드 동기화처리 
		//해당 메소드 실행 중 동기화 처리로 인한 다른 동기화된 메소드 동작 불가능
		//메소드 동기화 관리객체는 this
		synchronized/*(this)<--Object*/ void redOn() {

			jbt_red.setBackground(Color.red);
			jbt_yellow.setBackground(Color.gray);
			jbt_blue.setBackground(Color.gray);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}

		}

		synchronized void yellowOn() {

			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.yellow);
			jbt_blue.setBackground(Color.gray);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}

		synchronized void blueOn() {
			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.gray);
			jbt_blue.setBackground(Color.blue);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String name = Thread.currentThread().getName();

			while(true) {
				//쓰레드는 실행 순서는 알수가 없다!
				//쓰레드 실행 도중 다른 쓰레드가 실행될수도 있는 방식임(즉,신호등이 동시에 두개가 켜지는 문제 발생)
				//synchronized(this) 방식으로 감싸지 않으면 쓰레드 실행 도중 다른 쓰레드가 동작할수 있다.
				//해당 키워드로 감쌀경우, 해당 과정이 끝나야 다음 과정이 실행된다.

				if(name.equals("R")) {
					redOn(); 
				}else if(name.equals("Y")) {
					yellowOn();
				}else if(name.equals("B")) {
					blueOn();
				}

			}//end:while


		}//end:run
	}

	//----------------------------------------------------------------

	public ThreadMethodSync() {
		// TODO Auto-generated constructor stub
		super("Thread 동기화");

		this.setLayout(new GridLayout(1, 3));

		jbt_red = new JButton();
		jbt_red.setBackground(Color.red);

		jbt_yellow = new JButton();
		jbt_yellow.setBackground(Color.yellow);

		jbt_blue = new JButton();
		jbt_blue.setBackground(Color.blue);

		this.add(jbt_red);
		this.add(jbt_yellow);
		this.add(jbt_blue);


		//Thread생성 및 구동
		Runnable  r = new SignalRunnable();

		t_red = new Thread(r, "R");
		t_red.start();

		t_yellow = new Thread(r, "Y");
		t_yellow.start();

		t_blue = new Thread(r,"B");
		t_blue.start();


		//위치
		this.setLocation(200, 200);

		//크기
		this.setSize(300, 100);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadMethodSync();
	}

}
