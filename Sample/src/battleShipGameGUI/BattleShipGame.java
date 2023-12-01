package battleShipGameGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.mycommon.MyConstant;


public class BattleShipGame extends JFrame implements BattleShipGameInterface {
	
	JPanel grimPan;
	JButton gameStart=new JButton("게임 시작");
	JButton gameRull=new JButton("게임 규칙");
	JButton gameEnd=new JButton("게임 종료");

	
	public BattleShipGame() {
		super("배틀쉽 게임");

		//위치
		this.setLocation(200, 300);

		this.setLayout(new GridLayout(4,1));
		
		this.add(gameStart);
		this.add(gameRull);
		this.add(gameEnd);
		//크기
		this.setSize(600, 300);

		//보여주기
		this.setVisible(true);
		
		//크기 고정
		this.setResizable(false);

		init_grimpan();
		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//GUI 부분-----------------------------------------------------------------------------------
		private void init_grimpan() {
			
			grimPan = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					System.out.println("실행");
					
				
					
					init_mainMenu();
				}

				
			};

			
			

			this.add(grimPan,BorderLayout.CENTER);
		}
		
		private void init_mainMenu() {
			
			this.add(gameRull);
			this.add(gameRull);
			this.add(gameRull);
			this.add(gameRull);this.add(gameRull);
		}
		//GUI 부분-----------------------------------------------------------------------------------

	//클래스 선언부
	Scanner scanner=new Scanner(System.in);
	Random random=new Random();

	//변수 선언부
	private  char[][] playerABoard=new char[10][10];                    //풀레이어 A(사용자)의 게임보드판
	private  char[][] playerBBoard=new char[10][10];					//풀레이어 B(컴퓨터)의 게임보드판
	private  char[][] playerAttackBoard=new char[10][10];               //사용자의 공격 보드판
	private List<String> checkDuplicateShape=new ArrayList<String>();   //같은 크기의 배를 배치하는지 판단여부
	private String userResponse;										//사용자 메뉴화면 응답
	private String userShipPositionResponse;							//사용자 배 좌표값,배의크기,배의 방향
	private int x;														//가로방향 좌표
	private int y;														//세로방향 좌표
	private int shipSize;												//배의 크기(1~5)
	private int directionShip;											//배의 배치 방향(0:가로 1:세로)
	private String userAttack;											//사용자 공격좌표
	private int userHitCount;                                           //사용자 공격 명중 횟수
	private int computerHitCount;                                       //컴퓨터 공격 명중 횟수
	
	
	
	

	@Override
	public boolean initializeGame(String userShipPositionResponse) {
		x=Character.getNumericValue(userShipPositionResponse.charAt(0));
		y=Character.getNumericValue(userShipPositionResponse.charAt(1));
		shipSize=Character.getNumericValue(userShipPositionResponse.charAt(2));
		directionShip=Character.getNumericValue(userShipPositionResponse.charAt(3));


		//배를 배치시킬수 없는 경우
		if(!canPlaceShip(x,y,shipSize,directionShip,true)) return false;

		//배치가 가능한 경우
		else {
			placeShips(x, y, shipSize, directionShip, true);
			return true;
		}


	}
	@Override
	public void placeShips(int x, int y, int shipSize,int directionShip,boolean isUser) {
		char shape='□';
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
				if(isUser) playerABoard[y][x++]=shape;
				else playerBBoard[y][x++]=shape;
			}
			//세로로 아래방향 배치
			else {
				if(isUser) playerABoard[y++][x]=shape;
				else playerBBoard[y++][x]=shape;
			}

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

		//플레이어 A의 보드판 초기화
		for (int i = 0; i < playerABoard.length; i++) {
			for (int j = 0; j < playerABoard[i].length; j++) {
				playerABoard[i][j] = '□';
			}
		}

		//플레이어 B의 보드판 초기화
		for (int i = 0; i < playerBBoard.length; i++) {
			for (int j = 0; j < playerBBoard[i].length; j++) {
				playerBBoard[i][j] = '□';
			}
		}
		//플레이어 A의 공격보드판 초기화
		for (int i = 0; i < playerAttackBoard.length; i++) {
			for (int j = 0; j < playerAttackBoard[i].length; j++) {
				playerAttackBoard[i][j] = '□';
			}
		}
	}

	@Override
	public String playerAttack(char x, char y) {


		if(playerBBoard[y- '0'][x- '0']=='□') {
			playerAttackBoard[y- '0'][x- '0']='Ⅹ';
			System.out.println("                           빗맞췄습니다!");
		}else {
			playerAttackBoard[y- '0'][x- '0']='●';
			switch(playerBBoard[y- '0'][x- '0']) {
			case '★': System.out.println("                  당신의 공격이 ★(1)크기의 배 명중!"); break;
			case '◆': System.out.println("                  당신의 공격이 ◆(2)크기의 배 명중!"); break;
			case '■': System.out.println("                  당신의 공격이 ■(3)크기의 배 명중!"); break;
			case '▼': System.out.println("                  당신의 공격이 ▼(4)크기의 배 명중!"); break;
			case '♥': System.out.println("                  당신의 공격이 ♥(5)크기의 배 명중!"); break;
			}
			userHitCount++;
		}
		return null;
	}

	@Override
	public void computerAttack() {
		int computerAttackX;
		int computerAttackY;
		while(true) {
			computerAttackX=random.nextInt(10);
			computerAttackY=random.nextInt(10);

			//랜덤값 지정시 해당 좌표값이 컴퓨터가 이미 공격한 좌표인 경우
			if(playerABoard[computerAttackY][computerAttackX]=='Ⅹ' || playerABoard[computerAttackY][computerAttackX]=='●')continue;
			break;
		}

		if(playerABoard[computerAttackY][computerAttackX]=='□') {
			System.out.println("                           컴퓨터의 공격이 빗맞았습니다!");
			playerABoard[computerAttackY][computerAttackX]='Ⅹ';
		}else {

			switch(playerABoard[computerAttackY][computerAttackX]) {
			case '★': System.out.println("                 컴퓨터의 공격이 ★(1)크기의 배 명중!"); break;
			case '◆': System.out.println("                 컴퓨터의 공격이 ◆(2)크기의 배 명중!"); break;
			case '■': System.out.println("                 컴퓨터의 공격이 ■(3)크기의 배 명중!"); break;
			case '▼': System.out.println("                 컴퓨터의 공격이 ▼(4)크기의 배 명중!"); break;
			case '♥': System.out.println("                 컴퓨터의 공격이 ♥(5)크기의 배 명중!"); break;
			}
			playerABoard[computerAttackY][computerAttackX]='●';
			computerHitCount++;
		}
	};

	@Override
	public boolean canPlaceShip(int x, int y, int shipSize,int directionShip,boolean isUser) {

		//사용자가 이미 배치된 동일한 크기의 배를 다시 배치하려 하는 경우
		if(checkDuplicateShape.contains(Integer.toString(shipSize))) {
			if(isUser) System.out.println(shipSize+" 크기의 배는 이미 배치되었습니다.");
			return false;
		} 
		else checkDuplicateShape.add(Integer.toString(shipSize));



		//배의 배치방향이 가로인 경우
		if(directionShip==0) {
			//가능한 배치 범위를 벗어날 경우
			if(x+shipSize>10) {
				if(isUser) System.out.println("10*10 범위를 벗어난 위치에 해당 배를 배치할수 없습니다.");
				checkDuplicateShape.remove(Integer.toString(shipSize));
				return false;
			}
			else {

				for(int i=0;i<shipSize;i++) {

					//해당 위치에 배치된 배가 존재하는 경우, 즉'□' 이 아닌 값이 나타나는 경우

					if(playerABoard[y][x]!='□' && isUser || playerBBoard[y][x]!='□' && !isUser) {
						checkDuplicateShape.remove(Integer.toString(shipSize));
						if(isUser) System.out.println("배치하려는 배의 위치에 이미 배치된 배가 존재합니다.");
						return false;
					}
					x++;

				}

			}
		}

		//배의 배치방향이 세로인 경우
		else {
			//가능한 배치 범위를 벗어날 경우
			if(y+shipSize>10) {
				checkDuplicateShape.remove(Integer.toString(shipSize));
				if(isUser) System.out.println("10*10 범위를 벗어난 위치에 해당 배를 배치할수 없습니다.");
				return false;
			}
			else {
				for(int i=0;i<shipSize;i++) {
					//해당 위치에 배치된 배가 존재하는 경우, 즉'□' 이 아닌 값이 나타나는 경우
					if(playerABoard[y][x]!='□' && isUser || playerBBoard[y][x]!='□' && !isUser) { 
						checkDuplicateShape.remove(Integer.toString(shipSize));
						if(isUser) System.out.println("배치하려는 배의 위치에 이미 배치된 배가 존재합니다.");
						return false;
					}
					y++;
				}
			}
		}

		return true;
	}

	@Override
	public void computerPlaceShips() {
		checkDuplicateShape.clear();
		int coumputerX;
		int coumputerY;
		int computerShipSize=0;
		int computerDirectionShip;

		while(checkDuplicateShape.size()<5) {
			coumputerX=random.nextInt(10);
			coumputerY=random.nextInt(10);
			computerShipSize+=1;
			computerDirectionShip=random.nextInt(2);


			if(!canPlaceShip(coumputerX,coumputerY,computerShipSize,computerDirectionShip,false)) {
				--computerShipSize;
				continue;
			}
			else {
				//배의 크기에 따라 반복해서 해당하는 모양을 인서트.
				placeShips(coumputerX, coumputerY, computerShipSize, computerDirectionShip, false);

			}

		}
		//컴퓨터가 제대로 랜덤 배치시켰는지 확인을 위함
		//displayGameStatus("computer");

	}

	@Override
	public String displayGameStatus(String isUser) {

		//사용자의 현재 보드판 출력
		if(isUser.equals("user")) {
			System.out.println("  0 1 2 3 4 5 6 7 8 9");
			for (int i = 0; i < playerABoard.length; i++) {
				System.out.print(i+" ");
				for (int j = 0; j < playerABoard[i].length; j++) {
					System.out.print(playerABoard[i][j]);
				}
				System.out.println();
			}
		}

		//컴퓨터의 현재 보드판 출력
		else if(isUser.equals("computer")) {
			System.out.println("  0 1 2 3 4 5 6 7 8 9");
			for (int i = 0; i < playerBBoard.length; i++) {
				System.out.print(i+" ");
				for (int j = 0; j < playerBBoard[i].length; j++) {
					System.out.print(playerBBoard[i][j]);
				}
				System.out.println();
			}
		}

		//사용자 현재 보드판과, 사용자가 공격한 보드판 출력
		else if(isUser.equals("all")) {
			System.out.println("     사용자 보드판                             사용자 공격 보드판");
			System.out.println("  0 1 2 3 4 5 6 7 8 9                         0 1 2 3 4 5 6 7 8 9 ");
			for (int i = 0; i < playerABoard.length; i++) {
				System.out.print(i+" ");
				for (int j = 0; j < playerABoard[i].length; j++) {
					System.out.print(playerABoard[i][j]);
				}

				System.out.print("                      "+i+" ");
				for (int j = 0; j < playerAttackBoard[i].length; j++) {
					System.out.print(playerAttackBoard[i][j]);
				}
				System.out.println();
			}
		}
		return null;
	}

	@Override
	public void displayInstructions() {
		
	    System.out.println("<< BATTLESHIP 게임 규칙 >>");
        System.out.println("1. 플레이어 두 명이 참여합니다.");
        System.out.println("2. 10*10의 격자 공간에 각자 5척의 배를 가지고 원하는 위치에 배를 놓습니다.");
        System.out.println("3. 5척의 배는 각각 1, 2, 3, 4, 5의 길이를 가집니다.");
        System.out.println("4. 두 배를 중복하여 놓을 수 없으며, 마찬가지로 범위를 벗어나는 공간에 배를 놓을 수 없습니다.");
        System.out.println("5. 각 배는 각 길이 수 만큼의 좌표값을 모두 맞춰야 해당 배를 맞춘 것으로 판단됩니다.");
        System.out.println("6. A 플레이어가 배를 원하는 위치에 놓고, B 플레이어가 컴퓨터가 되어 자동으로 배를 놓고, A가 맞추는 방식입니다.");
        System.out.println("7. A 플레이어가 좌표값을 선택했을 때, 비어있는 곳인지, 배가 있는 위치인지를 판단하고, 어느 크기의 배인지도 알려줍니다.");
        System.out.println("   하나의 배를 모두 맞춘 경우, 상대방의 어떤 길이의 배가 격침되었음을 알립니다.");
        System.out.println("8. A 플레이어가 5개의 배를 모두 격침시켰을 경우 A 플레이어의 승리이며, B 플레이어가 A 플레이어의 배를 모두 격침시킨 경우 B 플레이어(컴퓨터)의 승리입니다.");
        System.out.println("   이후 해당 게임은 종료됩니다.");
        System.out.println("9. 플레이어는 원하는 배치 좌표를 기준으로 항상 오른쪽 또는 아래 방향으로만 배치합니다.");
        System.out.println();
        System.out.println("원하는 메뉴 명 또는 숫자를 입력하십시오.");
        System.out.println();
    

	}; 

	@Override
	public void isPlayGame() {
	
		

	}
	
	

}