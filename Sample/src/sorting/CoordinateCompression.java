package sorting;

/*수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-10^9 ≤ Xi ≤ 10^9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CoordinateCompression {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		

		int number[]=new int[count];
		int sorting[]=new int[count];

		for(int i=0;i<number.length;i++) {			
			number[i]=Integer.parseInt(st.nextToken());
		}
	

		sorting=Arrays.copyOfRange(number, 0, number.length);

		Arrays.sort(sorting);
		int rank=0;
		for(int i=0;i<sorting.length;i++) {	
			if(!hashMap.containsKey(sorting[i])) {
				hashMap.put(sorting[i], rank);
				rank++;
				}	
			
		}

		for(int i :number) {
			sb.append(hashMap.get(i)+" ");
		}

		System.out.println(sb);

	}

}
