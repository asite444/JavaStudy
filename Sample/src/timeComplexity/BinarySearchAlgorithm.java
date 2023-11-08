package timeComplexity;

import java.util.Scanner;

/*
 이진탐색 알고리즘 
 int[] nums= {15,28,34,56,68,78,89};
 에서 28을 찾고자 한다면 
 해당 배열에서의 중간값 56을 찾아서 크기 비교 후, 절반으로 나누기를 반복하여 찾는다. 
 해당 시간 복잡도는 O(log n) 이다.
 */
public class BinarySearchAlgorithm {

	public static void main(String[] args) {
		int[] nums= {15,28,34,56,68,78};
		Scanner scanner=new Scanner(System.in);
		System.out.println(binarySearch(nums,scanner.nextInt()));

	}

	// O(log n)
	public static int binarySearch(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] == target) {
	            return mid;
	        } else if (nums[mid] < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return -1;
	}
	
}
