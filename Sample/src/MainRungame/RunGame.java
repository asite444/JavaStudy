package MainRungame;
import java.util.Scanner;

import battleShipGame.*;
import numberBaseballGame.*;
public class RunGame {
    Scanner scanner=new Scanner(System.in);
    String userRsponse;
	public void gameRun() {
		
		System.out.println();
		System.out.println("게임 메뉴 입니다.");
		System.out.println("원하는 메뉴의 숫자 또는 명칭을 입력하십시오.");
		while(true) {
			System.out.println("1.야구 게임\n"
					+ "2.배틀쉽 게임\n"
					+ "3.게임 종료");
			System.out.print(">>");
		userRsponse=scanner.next();
		
		 if (userRsponse.equals("1") || userRsponse.equals("야구 게임")){
			SimpleNumberBaseballGame simpleNumberBaseballGame=new SimpleNumberBaseballGame();
			simpleNumberBaseballGame.playGame();
			
		}else if (userRsponse.equals("2") || userRsponse.equals("배틀쉽 게임")){
			BattleShipGame battleShipGame=new BattleShipGame();
			 battleShipGame.isPlayGame();
			
		}	else if (userRsponse.equals("3") || userRsponse.equals("게임 종료")) {
			System.out.println("게임이 종료되었습니다.");
			break;
		}
		
		}
	}
	public static void main(String[] args) {
		RunGame runGame=new RunGame();
		runGame.gameRun();
      
	}

}
