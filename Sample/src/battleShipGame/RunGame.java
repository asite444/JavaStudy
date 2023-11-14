package battleShipGame;

public class RunGame {

	public static void main(String[] args) {
		BattleShipGame battleShipGame=new BattleShipGame();
		
		battleShipGame.isPlayGame();
		
		//컴퓨터가 랜덤 배치를 잘 하는가?
		//battleShipGame.initializePlayerABoard();		
		//battleShipGame.computerPlaceShips();
		//System.out.println("                           빗맞췄습니다!");
		//System.out.println("                  당신의 공격이 ★(1)크기의 배 명중!");
		//System.out.println();
		//battleShipGame.displayGameStatus("all");
	}

}
/*

  0 1 2 3 4 5 6 7 8 9
0 □□□□□□□□□□
1 □□□□□□□□□□
2 □□□□▼▼▼▼□□
3 □□♥♥♥♥♥□□□
4 □□□□□□□□□□
5 □□□■■■◆□□□
6 □□□□□□◆□□□
7 □□□□□□□□□□
8 □□□□□□□□□□
9 ★□□□□□□□□□
*/