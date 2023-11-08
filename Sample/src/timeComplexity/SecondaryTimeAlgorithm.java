package timeComplexity;
//정수 배열을 선택 정렬(selection sort)을 이용해 정렬하는 예시
//O(n^2): 이차 시간 알고리즘
public class SecondaryTimeAlgorithm {

	public static void main(String[] args) {
		int nums[]= {2,3,8,4,7};
		selectionSort(nums);
		for(int i:nums) System.out.print(i+" ");

	}

	
	// O(n^2)
	public static void selectionSort(int[] nums) {
	    for (int i = 0; i < nums.length - 1; i++) {
	        int minIdx = i;
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] < nums[minIdx]) {
	                minIdx = j;
	            }
	        }
	        int tmp = nums[i];
	        nums[i] = nums[minIdx];
	        nums[minIdx] = tmp;
	    }
	}

}
