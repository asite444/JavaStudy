package battleShipGame;


public interface BattleShipGameInterface {
	

    /**
     * 게임을 초기화하고 플레이어가 배를 배치한다.
     * 사용자가 선택한 좌표값을  첫번째 값으로 지정하고 방향을 기준으로 배를 배치한다.
     * @param x 가로 좌표값
     * @param y 세로 좌표값
     * @param shipSize 배의 크기
     * @param directionShip 배의 방향 0:가로 1:세로
     */
	boolean initializeGame(String userShipPositionResponse);
    
	/**사용자로부터 입력을 받아 유효성을 검사하고 올바른 형식의 입력을 확인. 
	 *
	 */
	public boolean validateUserInput(String userShipPositionResponse);
	
    /**
     * 플레이어 A의 좌표 공간을 '□'으로 초기화한다.
     */
    public void initializePlayerABoard(); 

    /**
     * 플레이어가 좌표를 선택하여 공격을 수행한다.
     * @param x 선택한 좌표의 가로 위치
     * @param y 선택한 좌표의 세로 위치
     * @return 공격 결과 (맞췄는지, 어떤 크기의 배인지 등)
     */
    String playerAttack(int x, int y);
    
    /**
     * 주어진 좌표와 배의 방향을 기반으로 배를 배치할 수 있는지 여부를 확인한다.
     * @param x 배를 배치하려는 가로 좌표
     * @param y 배를 배치하려는 세로 좌표
     * @param shipSize 배의 크기값(0~5)
     * @param directionShip 배의 방향 가로/세로(0:가로 1:세로) 판단
     * @return 배를 배치할 수 있는지 여부 (중복 여부, 범위 초과 여부)
     */
    boolean canPlaceShip(int x, int y, int shipSize,int directionShip);

    /**
     * 컴퓨터가 자동으로 배를 배치한다.
     */
    void computerPlaceShips();

    /**
     * 현재 게임 상태를 보여준다 (플레이어의 배 위치, 맞춘 부분, 아직 안 맞춘 부분 등).
     * @return 현재 게임 상태를 나타내는 문자열
     */
    String displayGameStatus();
    
    
	/** 규칙 및 지침을 표시하는 함수.
	 * 
	 */
	public void displayInstructions(); 

    /**
     * 현재 게임을 실행하고 종료시킨다.
     * @return 게임 메인 메소드
     */
    void isPlayGame();
}
