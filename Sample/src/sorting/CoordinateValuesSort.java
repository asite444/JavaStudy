package sorting;
/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, 
x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class CoordinateValuesSort {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Random random=new Random();

		//int count=Integer.parseInt(br.readLine());
		int count=10;//random.nextInt(9)+1;
		int x,y;

		ArrInteger[] arr=new ArrInteger[count];
		for(int i=0;i<arr.length;i++) {
			/*StringTokenizer st=new StringTokenizer(br.readLine());	
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			 */
			x=random.nextInt(10);
			y=random.nextInt(10);
			arr[i]=new ArrInteger(x,y);			
		}

		Arrays.sort(arr,compDescX);

		for(int i=0;i<arr.length;i++) sb.append(arr[i].number[0]+" "+arr[i].number[1]).append("\n");


		System.out.println(sb);

		//br.close();

	}

	//X좌표 Asc정렬
	public static Comparator<ArrInteger> compAscX =new Comparator<ArrInteger>() {

		@Override
		public int compare(ArrInteger o1, ArrInteger o2) {
			if(o1.number[0]-o2.number[0]==0) return o1.number[1]-o2.number[1];  
			else return o1.number[0]-o2.number[0];
		}
	};

	//X좌표 Desc정렬
	public static Comparator<ArrInteger> compDescX =new Comparator<ArrInteger>() {

		@Override
		public int compare(ArrInteger o1, ArrInteger o2) {
			if(o1.number[0]-o2.number[0]==0) return -(o1.number[1]-o2.number[1]);  
			else return -(o1.number[0]-o2.number[0]);
		}
	};

	//Y좌표 Asc정렬
	public static Comparator<ArrInteger> compAscY =new Comparator<ArrInteger>() {

		@Override
		public int compare(ArrInteger o1, ArrInteger o2) {
			if(o1.number[1]-o2.number[1]==0) return o1.number[0]-o2.number[0];  
			else return o1.number[1]-o2.number[1];
		}
	};

	//Y좌표 Desc정렬
	public static Comparator<ArrInteger> compDescY =new Comparator<ArrInteger>() {

		@Override
		public int compare(ArrInteger o1, ArrInteger o2) {
			if(o1.number[1]-o2.number[1]==0) return -(o1.number[0]-o2.number[0]);  
			else return -(o1.number[1]-o2.number[1]);
		}
	};

}
class ArrInteger {
	int number[]=new int[2];

	public ArrInteger(int x,int y) {
		this.number[0]=x;
		this.number[1]=y;
	}
}

