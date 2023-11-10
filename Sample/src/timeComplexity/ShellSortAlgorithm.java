package timeComplexity;

/**삽입정렬의 단점을 보완한 정렬법. gap 이라는 간격을 두고 각 부분 요소를 삽입정렬하는 방식.
 * @정렬종류:셸 정렬 
 * @시간복잡도:O(n^2)
 * 
 * @요약설명
‘Donald L. Shell’이라는 사람이 제안한 방법으로, 삽입정렬을 보완한 알고리즘이다.
삽입 정렬이 어느 정도 정렬된 배열에 대해서는 대단히 빠른 것에 착안
삽입 정렬의 최대 문제점: 요소들이 삽입될 때, 이웃한 위치로만 이동
즉, 만약 삽입되어야 할 위치가 현재 위치에서 상당히 멀리 떨어진 곳이라면 많은 이동을 해야만 제자리로 갈 수 있다.
삽입 정렬과 다르게 셸 정렬은 전체의 리스트를 한 번에 정렬하지 않는다.
 * 
 */
public class ShellSortAlgorithm {

	public static void main(String[] args) {
		
		int arr[]= {10,8,6,20,4,3,22,1,0,15,16};
		
		shell_sort(arr);
		
		for(int i:arr) System.out.print(i+" ");

	}

	
	private final static int[] gap = 
		{ 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	
		8858, 19930, 44842, 100894, 227011, 510774,
		1149241, 2585792, 5818032, 13090572, 29453787, 
		66271020, 149109795, 335497038, 754868335, 1698453753};	// 갭을 담고있는 배열	
 
	
	public static void shell_sort(int[] arr) {
		shell_sort(arr, arr.length);
		
	}
 
	// 맨 처음 gap을 참조 할 인덱스를 구하는 메소드
	private static int getGap(int length) {
		int index = 0;
		// 최소한 부분 배열의 원소가 2개씩은 비교 되도록 나눠준다.
		int len = (int)(length / 2.25);	
		
		while (gap[index] < len) {
			index++;
		}
		System.out.println("index:"+index);
		return index;
	}
 
	private static void shell_sort(int[] arr, int size) {
		int index = getGap(size);	// 첫 gap을 사용할 index
 
		// gap[index] 값부터 gap[0] 까지 반복한다.
		for (int i = index; i >= 0; i--) {
 
			for (int j = 0; j < gap[i]; j++) {	// 각 부분 리스트에 대해 삽입정렬을 한다.
				insertion_sort(arr, j, size, gap[i]);
			}
		}
	}
 
	/**
	 * 
	 * @param arr		 배열
	 * @param start	 부분 배열의 첫 번째 원소 인덱스 
	 * @param size	 배열의 전체 크기
	 * @param gap	 현재 gap
	 */
	private static void insertion_sort(int[] arr, int start, int size, int gap) {
 
		// 부분 배열의 두 번째 원소부터 size까지 반복한다. (gap 값씩 건너띔) 
		for (int i = start + gap; i < size; i += gap) {
			
			 System.out.print(arr[i]+" ");
			int target = arr[i];
			int j = i - gap;
			//System.out.println("target:"+target);
 
			// 타겟 원소가 이전의 원소보다 작을 때 까지 반복 
			while (j >= start && target < arr[j]) {
				arr[j + gap] = arr[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
				j -= gap;
			}
			/*
			 * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
			 * 타겟 원소는 j번째 원소 뒤에 와야한다.
			 * 그러므로 타겟은 j + gap 에 위치하게 된다.
			 */
			
			arr[j + gap] = target;
 
		}
		System.out.println();
	}
}
