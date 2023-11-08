package timeComplexity;

/*
선형 시간 알고리즘
입력한 배열을 역순으로 만드는 함수를 구현한 예시
해당 시간복잡도는 O(n)
*/
public class LinearTimeAlgorithm {

	public static void main(String[] args) {
		
		int nums[]= {1,2,3,4,5};
		nums=reverse(nums);
		for(int i:nums) System.out.print(i+" ");
		

	}

	// O(n)
	public static int[] reverse(int[] nums) {
	    int[] reversed = new int[nums.length];
	    for (int i = 0; i < nums.length; i++) {
	        reversed[nums.length - i - 1] = nums[i];
	    }
	    return reversed;
	}

}
