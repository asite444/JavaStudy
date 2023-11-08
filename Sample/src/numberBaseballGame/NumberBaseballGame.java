package numberBaseballGame;

import java.util.List;

public interface NumberBaseballGame {
	//게임의 비밀 숫자를 생성. 랜덤 숫자를 생성하고 반환.
	public void  generateRandomNumber(); 
	
    //사용자의 추측과 비밀 숫자를 비교하여 스트라이크와 볼의 수를 계산.
	public int checkGuess(List<String> userInputValue, List<String> systemRandomValue);
    
	//사용자로부터 입력을 받아 유효성을 검사하고 올바른 형식의 입력을 확인.
	public void validateUserInput();

	//게임 종료 조건을 확인하고, 스트라이크 개수가 정해진 조건을 만족하면 true를 반환.
	public boolean isGameOver(int strikes);
	
	//중복 숫자 체크 함수
	public boolean checkDuplicateNumbers(String userInput);
	
	//임의 규칙 및 지침을 표시하는 함수.
	public void displayInstructions(); 
	
	//게임의 주요 실행 부분을 처리, 게임 루프를 시작하고 사용자 입력을 처리하고 게임 상태를 업데이트.
	public void playGame(); 
}