package timeComplexity;

public class InsertionSortAlgorithm {
	

		 
		public static void main(String[] args) {
			int[] arr= {2,6,4,7,3,9};
			
			insertion_sort(arr);
			
			for(int i:arr) System.out.print(i+" ");
		}
		
		
		
		/**시간복잡도 O(n^2) 알고리즘,삽입 정렬 
		 * @param arr
		 */
		public static void insertion_sort(int[] arr) {
			sort(arr, arr.length);
		}
		
		private static void sort(int[] arr, int size) {
			
			
			for(int i = 1; i < size; i++) {
				// 타겟 넘버
				int target = arr[i];
				
				int j = i - 1;
				
				// 타겟이 이전 원소보다 크기 전 까지 반복
				while(j >= 0 && target < arr[j]) {
					arr[j + 1] = arr[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
					j--;
				}
				
				/*
				 * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
				 * 타겟 원소는 j번째 원소 뒤에 와야한다.
				 * 그러므로 타겟은 j + 1 에 위치하게 된다.
				 */
				arr[j + 1] = target;	
			}
			
		}
	}

