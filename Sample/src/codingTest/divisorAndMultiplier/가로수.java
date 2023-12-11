package codingTest.divisorAndMultiplier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가로수 {

	public static void main(String[] args) throws Exception{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder str = new StringBuilder();

	        // N: 이미 심어져 있는 가로수의 수
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];

	        for (int n = 0; n < N; n++)
	            arr[n] = Integer.parseInt(br.readLine());

	        Arrays.sort(arr);
	        int gcd = 0;
	        for(int i=0; i<N-1; i++){
	            int dis = arr[i+1]-arr[i];
	            gcd = gcd(dis, gcd);
	        }

	        // 일정 간격마다 심은 나무 수 - 이미 심긴 나무 수
	        str.append((arr[N-1]-arr[0])/gcd + 1 - (arr.length));

	        System.out.print(str);
	        br.close();
	

	}
	public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

}
