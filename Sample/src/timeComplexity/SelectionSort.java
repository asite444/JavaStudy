package timeComplexity;
/*
 * 
선택정렬(SelectionSort)

[장점]
1. 추가적인 메모리 소비가 작다. 

[단점]

1. 시간복잡도가 O(N2) 이다.
2. 안정 정렬이 아니다.
 */
public class SelectionSort {


	public static void main(String[] args) {

		int array[]= {1,5,7,6,4,9,3};
		//오름차순 정렬인 경우
		selection_sort_asc(array);
		for(int i:array) System.out.print(i+" ");
		System.out.println();
		
		//내림차순 정렬인 경우
		selection_sort_desc(array);
		for(int i:array) System.out.print(i+" ");

	}
	public static void selection_sort_asc(int[] array) {
		selection_sort_asc(array, array.length);
	}
	public static void selection_sort_desc(int[] array) {
		selection_sort_desc(array, array.length);
	}

	private static void selection_sort_asc(int[] array, int size) {

		for(int i = 0; i < size - 1; i++) {
			int min_index = i;	

			// 최솟값을 갖고있는 인덱스 찾기 
			for(int j = i + 1; j < size; j++) {
				if(array[j] < array[min_index]) {
					min_index = j;
				}
			}

			// i번째 값과 찾은 최솟값을 서로 교환 
			swap(array, min_index, i);
		}
	}

	private static void selection_sort_desc(int[] array, int size) {

		for(int i = 0; i < size - 1; i++) {
			int max_index = i;	

			// 최대값을 갖고있는 인덱스 찾기 
			for(int j = i + 1; j < size; j++) {
				if(array[j] > array[max_index]) {
					max_index = j;
				}
			}

			// i번째 값과 찾은 최솟값을 서로 교환 
			swap(array, max_index, i);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
