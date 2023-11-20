package sorting;

/*
퀵 정렬(QuickSorting)
기본 설명: 분할 정복 방식의 정렬 알고리즘이다. 리스트에서 하나의 요소를 피벗으로 선택하고, 이 피벗보다 작은 요소들은
 왼쪽으로, 큰 요소들은 오른쪽으로 이동. 이렇게 분할된 두 리스트에 대해 같은 작업을 재귀적으로 반복한다.

시간복잡도: 평균 시간복잡도:O(n log n).
             최악의 경우(이미 정렬된 리스트 등) 시간복잡도: O(n^2).

장점:

평균적으로 매우 빠른 실행 속도를 가짐.
추가 메모리를 거의 요구하지 않는 인플레이스 알고리즘.

단점:
최악의 경우 시간 복잡도가 O(n^2)이므로, 특정 상황에서는 성능이 저하될 수 있다.
피벗을 잘못 선택하면 비효율적인 결과를 가져올 수 있다.
일반적으로 가장 왼쪽의 요소를 피벗으로 선택한다.(무조건 가장 왼쪽요소를 선택하라는 의미가 아님)
 */
public class QuickSortingAlgorithm {

	public static void main(String[] args) {
		int number[]= {8,4,1,6,3,9,2,7,5};
		quickSort(number);
		
		System.out.println("최종결과");
		for(int i:number) System.out.print(i+" ");
	}

	public static void quickSort(int number[]) {

	sort(number,0,number.length-1);

	
	}

	public static void sort(int[] arr, int start, int end) {
		// start가 end보다 크거나 같다면 정렬할 원소가 1개 이하이므로 정렬하지 않고 return
	    if (start >= end)
	      return;
	    
	    // 가장 왼쪽의 값을 pivot으로 지정, 실제 비교 검사는 start+1 부터 시작
	    int pivot = start;
	    int lo = start + 1;
	    int hi = end;
	    
	    // lo는 현재 부분배열의 왼쪽, hi는 오른쪽을 의미
	    // 서로 엇갈리게 될 경우 while문 종료
	    while (lo <= hi) {
	      while (lo <= end && arr[lo] <= arr[pivot]) // 피벗보다 큰 값을 만날 때까지
	        lo++;
	      while (hi > start && arr[hi] >= arr[pivot]) // 피벗보다 작은 값을 만날 때까지
	        hi--;
	      if (lo > hi)				 // 엇갈리면 피벗과 교체
	        swap(arr, hi, pivot);
	      else
	        swap(arr, lo, hi);			 // 엇갈리지 않으면 lo, hi 값 교체 
	      }
		
	    // 엇갈렸을 경우, 
	    // 피벗값과 hi값을 교체한 후 해당 피벗을 기준으로 앞 뒤로 배열을 분할하여 정렬 진행
	    sort(arr, start, hi - 1);
	    sort(arr, hi + 1, end);

	  }

	  private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }

}



