package battleShipGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleShipGame implements BattleShipGameInterface {

	//클래스 선언부
	Scanner scanner=new Scanner(System.in);
	Random random=new Random();

	//변수 선언부
	private  char[][] playerABoard=new char[10][10];                    //풀레이어 A(사용자)의 게임보드판
	private  char[][] playerBBoard=new char[10][10];					//풀레이어 B(컴퓨터)의 게임보드판
	private List<String> checkDuplicateShape=new ArrayList<String>();   //같은 크기의 배를 배치하는지 판단여부
	private String userResponse;										//사용자 메뉴화면 응답
	private String randomNumber;                                        //컴퓨터 랜덤 배치를 위한 랜덤값
	private String userShipPositionResponse;							//사용자 배 좌표값,배의크기,배의 방향
	private int x;														//가로방향 좌표
	private int y;														//세로방향 좌표
	private int shipSize;												//배의 크기(1~5)
	private int directionShip;											//배의 배치 방향(0:가로 1:세로)

	@Override
	public boolean initializeGame(String userShipPositionResponse) {
		x=Character.getNumericValue(userShipPositionResponse.charAt(0));
		y=Character.getNumericValue(userShipPositionResponse.charAt(1));
		shipSize=Character.getNumericValue(userShipPositionResponse.charAt(2));
		directionShip=Character.getNumericValue(userShipPositionResponse.charAt(3));
		char shape='□';

		//배를 배치시킬수 없는 경우
		if(!canPlaceShip(x,y,shipSize,directionShip)) return false;

		//배치가 가능한 경우
		else {
			//배의 크기에 따라 모양 선택
			switch(shipSize) {
			case 1: shape='★';break;
			case 2: shape='◆';break;
			case 3: shape='■';break;
			case 4: shape='▼';break;
			case 5: shape='♥';break;
			}
			//해당 배치값을 실제 배열에 인서트!

			//배의 크기에 따라 반복해서 해당하는 모양을 인서트.
			for(int i=0;i<shipSize;i++) {

				//가로로  오른쪽방향 배치
				if(directionShip==0) {
					playerABoard[y][x++]=shape;
				}
				//세로로 아래방향 배치
				else {
					playerABoard[y++][x]=shape;
				}

			}
			return true;
		}


	}

	@Override
	public boolean validateUserInput(String userShipPositionResponse) {		
		boolean containsNonDigit = userShipPositionResponse.matches(".*[^0-9].*"); //사용자로부터 입력받은 값에 숫자가 아닌 문자의 포함 여부
		if (containsNonDigit || userShipPositionResponse.length()!=4 ) { 
			System.out.println("4자리의 숫자가 아닙니다. 다시 입력하십시오"); 
			return false;
		}
		else if(userShipPositionResponse.charAt(2)>'5' || userShipPositionResponse.charAt(2)=='0') {
			System.out.println("배의 크깃값이 5를 넘어섰거나, 0입니다.");	
			return false;
		}else if(userShipPositionResponse.charAt(3)>'1') {
			System.out.println("방향값은 (0:가로,1:세로) 입니다. 그 이외의 값은 입력할수 없습니다.");
			return false;
		} else return true;


	}

	@Override
	public void initializePlayerABoard() {
		for (int i = 0; i < playerABoard.length; i++) {
			for (int j = 0; j < playerABoard[i].length; j++) {
				playerABoard[i][j] = '□';
			}
		}
	}

	@Override
	public String playerAttack(int x, int y) { 
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override

	public boolean canPlaceShip(int x, int y, int shipSize,int directionShip) {

		//사용자가 이미 배치된 동일한 크기의 배를 다시 배치하려 하는 경우
		if(checkDuplicateShape.contains(Integer.toString(shipSize))) {
			System.out.println(shipSize+" 크기의 배는 이미 배치되었습니다.");
			return false;
		} 
		else checkDuplicateShape.add(Integer.toString(shipSize));



		//배의 배치방향이 가로인 경우
		if(directionShip==0) {
			//가능한 배치 범위를 벗어날 경우
			if(x+shipSize>10) {
				System.out.println("10*10 범위를 벗어난 위치에 해당 배를 배치할수 없습니다.");
				checkDuplicateShape.remove(Integer.toString(shipSize));
				return false;
			}
			else {
				for(int i=0;i<shipSize;i++) {

					//해당 위치에 배치된 배가 존재하는 경우, 즉'□' 이 아닌 값이 나타나는 경우
					if(playerABoard[y][x++]!='□') {
						checkDuplicateShape.remove(Integer.toString(shipSize));
						System.out.println("배치하려는 배의 위치에 이미 배치된 배가 존재합니다.");
						return false;
					}
				}
			}
		}

		//배의 배치방향이 세로인 경우
		else {
			//가능한 배치 범위를 벗어날 경우
			if(y+shipSize>10) {
				checkDuplicateShape.remove(Integer.toString(shipSize));
				System.out.println("10*10 범위를 벗어난 위치에 해당 배를 배치할수 없습니다.");
				return false;
			}
			else {
				for(int i=0;i<shipSize;i++) {
					//해당 위치에 배치된 배가 존재하는 경우, 즉'□' 이 아닌 값이 나타나는 경우
					if(playerABoard[y++][x]!='□') { 
						checkDuplicateShape.remove(Integer.toString(shipSize));
						System.out.println("배치하려는 배의 위치에 이미 배치된 배가 존재합니다.");
						return false;
					}
				}
			}
		}

		return true;
	}

	@Override
	public void computerPlaceShips() {
		// TODO 자동 생성된 메소드 스텁

	}

	@Override
	public String displayGameStatus() {




		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < playerABoard.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < playerABoard[i].length; j++) {
				System.out.print(playerABoard[i][j]);
			}
			System.out.println();
		}
		return null;
	}

	@Override
	public void displayInstructions() {

	}; 

	@Override
	public void isPlayGame() {
		System.out.println("BattleShip 게임 입니다.");
		System.out.println("원하는 메뉴 명 또는 숫자를 입력하십시오.");

		while(true) {
			//게임 재시작 시,사용자 입력값과 시스템 랜덤값의 초기화


			System.out.println("1.게임 시작\n"
					+ "2.게임 규칙\n"
					+ "3.게임 종료");
			userResponse=scanner.nextLine();
			if(userResponse.equals("1") || userResponse.equals("게임 시작")) {
				int count=0;//배 5개를 놓기위한 카운터값
				System.out.println("배틀쉽 게임이 시작되었습니다.");

				//좌표값 초기화
				initializePlayerABoard();
				displayGameStatus();
				checkDuplicateShape.clear();

				System.out.println("배를 놓을 위치,배의 크기,배의 방향을 입력하십시오");
				System.out.println("가로값 세로값 배의 크기 배의 방향(0:가로,1:세로)");


				while(true) {

					System.out.print(">>");

					userShipPositionResponse=scanner.nextLine();
					userShipPositionResponse=userShipPositionResponse.replaceAll(" ", "");

					//사용자의 숫자가 범위를 벗어나는가?
					if(validateUserInput(userShipPositionResponse)){
						//해당 좌표값에 배를 위치시키는 것이 가능한가?
						if(initializeGame(userShipPositionResponse)) displayGameStatus();
						else continue;
					}
					else continue;
					count++;
					if(count==5) break;
				}




			}
			else if (userResponse.equals("2") || userResponse.equals("게임 규칙")){
				displayInstructions(); //게임 규칙 설명 출력
			}
			else if (userResponse.equals("3") || userResponse.equals("게임 종료")) {
				System.out.println("게임이 종료되었습니다.");
				break;
			}
			else System.out.println("입력이 정확하지 않습니다. 다시 입력하십시오.");
		}
		scanner.close();

	}

}
