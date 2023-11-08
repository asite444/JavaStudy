package numberBaseballGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SimpleNumberBaseballGame implements NumberBaseballGame  {

	//클래스 선언부
	private Scanner scanner =new Scanner(System.in);
	private Random random=new Random();

	//변수 선언부
	private String userResponse; 										//사용자 응답 
	private String userInputNumber;       								//사용자 입력값
	private String randomNumber;										//시스템 랜덤값
	private int strike; 												//스트라이크
	private int ball;													//볼
	private int count;													//시도 횟수
	private List<String> userInputValue=new ArrayList<String>();  		//사용자 입력값
	private List<String> systemRandomValue = new ArrayList<String>(); 	//시스템 랜덤값


	@Override
	//게임의 비밀 숫자를 생성. 랜덤 숫자를 생성하고 반환.
	public void generateRandomNumber() {
		systemRandomValue.clear();  //시스템 랜덤값 초기화
		while (systemRandomValue.size() < 4) {
			randomNumber = Integer.toString((random.nextInt(10))); //0~9 사이의 랜덤값 생성

			if (!systemRandomValue.contains(randomNumber)) { //생성된 숫자 모두 서로 다른 경우에만 실행
				systemRandomValue.add(randomNumber);
			}
		}


	}

	@Override
	//사용자의 추측과 비밀 숫자를 비교하여 스트라이크와 볼의 수를 계산.
	public int checkGuess(List<String> userInputValue, List<String> systemRandomValue) {
		strike=0;                   //스트라이크 초기화(게임 재시작 할 때 strike 값 초기화 되지 않는 문제 방지)
		count=1;					//시도 횟수 초기화(게임 재시작 할 때 count 값 초기화 되지 않는 문제 방지)
		while(true) {
			
			strike=0;				//스트라이크 초기화
			ball=0;					//볼 초기화
			validateUserInput();
			for(int i=0;i<userInputValue.size();i++) {
				if(systemRandomValue.contains(userInputValue.get(i))) {
					if(userInputValue.get(i).equals(systemRandomValue.get(i)))++strike;
					else ++ball;
				}
			}
			
			System.out.println(strike+" strike! "+ball+" ball!");
			System.out.println(count+"회 시도");
			if(strike==4) break;
			else if(count>=10) break;
			++count;
		}
		
		if(count<=10 && strike==4) {
			System.out.println(count+"번 시도하셨습니다.");
			System.out.println("WIN");
		} else {
			System.out.println("안타깝습니다!10번 안에 숫자를 맞추지 못하셨습니다.");
			System.out.print("랜덤값:");
			for(int i=0;i<4;i++) {
				System.out.print(systemRandomValue.get(i));
			}

			System.out.println();
		}
		return 0;
	}

	@Override
	//사용자로부터 입력을 받아 유효성을 검사하고 올바른 형식의 입력을 확인.
	public void validateUserInput() {
		userInputValue.clear(); //사용자 입력값 초기화

		while(true) {
			userInputNumber=scanner.nextLine();
			boolean containsNonDigit = userInputNumber.matches(".*[^0-9].*"); //사용자로부터 입력받은 값에 숫자가 아닌 문자의 포함 여부
			if (containsNonDigit || userInputNumber.length()!=4 ) { 
				System.out.println("4자리의 숫자가 아닙니다. 다시 입력하십시오");
			}
			else if(checkDuplicateNumbers(userInputNumber)) {
				System.out.println("중복된 숫자가 있습니다. 다시 입력하십시오");
			}
			else break; 
		}
		for(int i=0;i<4;i++) {
			userInputValue.add(Character.toString(userInputNumber.charAt(i)));	//랜덤 값과의 비교를 위한 값을 Arraylist에 값 저장  
		}

	}

	@Override
	//게임 종료 조건을 확인하고, 스트라이크 개수가 정해진 조건을 만족하면 true를 반환.(해당 class에서는 사용하지 않음)
	public boolean isGameOver(int strikes) {
		// 사용 안함
		return false;
	}

	//중복 숫자 체크 함수
	@Override
	public boolean checkDuplicateNumbers(String userInputNumber) {
		Set<Character> characters = new HashSet<>();
		for (char c : userInputNumber.toCharArray()) {
			if (!characters.add(c)) {
				return true; // 중복된 문자가 있으면 true 반환
			}
		}
		return false; // 중복된 문자가 없으면 false 반환
	}

	@Override
	//임의 규칙 및 지침을 표시하는 함수.
	public void displayInstructions() {
		System.out.println("=== 숫자 야구 게임 규칙 ===");
		System.out.println("1. 게임의 목표는 0부터 9까지 서로 다른 4자리 비밀 숫자를 맞히는 것입니다.");
		System.out.println("2. 플레이어는 각 턴마다 4자리의 숫자를 입력하여 비밀 숫자를 추측합니다.");
		System.out.println("3. 플레이어가 입력한 숫자와 비밀 숫자를 비교하여 결과를 알려줍니다.");
		System.out.println("4. 비교 결과는 스트라이크와 볼로 표시됩니다.");
		System.out.println("5. 스트라이크: 숫자와 위치가 정확히 일치하는 경우");
		System.out.println("6. 볼: 숫자는 일치하지만 위치가 틀린 경우");
		System.out.println("7. 4개의 스트라이크를 달성하면 게임에서 이기게 됩니다.");
		System.out.println("8. 10번의 기회 안에 비밀 숫자를 맞히지 못하면 게임에 패배합니다.");
		System.out.println("9. 모든 입력은 1부터 9까지의 서로 다른 숫자여야 합니다.");
		System.out.println("10. 숫자 야구 게임을 즐겨보세요!");
		System.out.println();
		System.out.println("원하는 메뉴의 숫자 또는 명칭을 입력하십시오.");
	}

	@Override
	//게임의 주요 실행 부분을 처리, 게임 루프를 시작하고 사용자 입력을 처리하고 게임 상태를 업데이트.
	public void playGame() {
		System.out.println("야구 게임 입니다.");
		System.out.println("원하는 메뉴의 숫자 또는 명칭을 입력하십시오.");
		while(true) {
			//게임 재시작 시,사용자 입력값과 시스템 랜덤값의 초기화
			userInputValue.clear();    
			systemRandomValue.clear();

			System.out.println("1.게임 시작\n"
					+ "2.게임 규칙\n"
					+ "3.게임 종료");
			userResponse=scanner.nextLine();
			if(userResponse.equals("1") || userResponse.equals("게임 시작")) {
				System.out.println("야구 게임이 시작되었습니다.");
				generateRandomNumber();
				
				//볼,스트라이크 판정이 제대로 동작하는지 확인하기 위한 임시코드.
				System.out.print("랜덤값:");
				for(int i=0;i<4;i++) {
					System.out.print(systemRandomValue.get(i));
				}
				
				System.out.println();
				System.out.println("4자리의 숫자를 입력하십시오.");

				checkGuess(userInputValue,systemRandomValue);  //랜덤값과 입력값 비교

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

	}

}
