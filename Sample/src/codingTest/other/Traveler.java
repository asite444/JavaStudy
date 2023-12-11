package codingTest.other;

import java.util.Scanner;

/*아래와 같은 계획서가 주어졌을 때 여행가 A가 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시오.

L : 왼쪽으로 한 칸 이동
R : 오른쪽으로 한 칸 이동
U : 위로 한 칸 이동
D : 아래로 한 칸 이동
가장 왼쪽 위 좌표는 (1,1) 이며, 시작 좌표는 항상 (1,1)이다.

입력 조건

첫째 줄에 공간의 크기를 나타내는 N이 주어진다. (1 ≤ MapSize ≤ 100)
둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다. (1 ≤ 이동 횟수 ≤ 100)


출력 조건

첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (locationValue[0],locationValue[1])를 공백으로 구분하여 출력한다.


입력/출력 예시

입력
5
R R R U D D	

출력
3 4
 */

public class Traveler {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		int MapSize=scanner.nextInt();
		scanner.nextLine();
		String movingDirection=scanner.nextLine().replaceAll(" ", "");
		System.out.println(movingDirection);
		int[] locationValue= {1,1};

		for(int i=0;i<movingDirection.length();i++) {
			
			switch(movingDirection.charAt(i)) {
			case 'U':
	            locationValue[0] = (locationValue[0] - 1 < 1 ? locationValue[0] : locationValue[0] - 1);
	            break;
	        case 'D':
	            locationValue[0] = (locationValue[0] + 1 > MapSize ? locationValue[0] : locationValue[0] + 1);
	            break;
	        case 'L':
	            locationValue[1] = (locationValue[1] - 1 < 1 ? locationValue[1] : locationValue[1] - 1);
	            break;
	        case 'R':
	            locationValue[1] = (locationValue[1] + 1 > MapSize ? locationValue[1] : locationValue[1] + 1);
	            break;
		}
		}
		System.out.println(locationValue[0]+" "+locationValue[1]);
		scanner.close();
        
	}

	}
