package javaClass;
//가변인자
//받아들이는 파라미터 값의 갯수에 따라, 배열의 크기를 지정하여 파라미터 배열 선언
public class ArrayEllipsis {

	static void list1 (int ...number) {
	for(int i:number) System.out.print(i+" ");	
	System.out.println();
	}	
	public static void main(String[] args) {
	list1(1);
	list1(1,2);
	list1(1,2,3,4,5);

	maxNumber(1,3,5,7,9);
	}
	
	public static void maxNumber(int ...max) {
		int maxNumber=Integer.MIN_VALUE;
		
		for(int i:max) if(maxNumber<i) maxNumber=i;
		
		System.out.println(maxNumber);
		
	}

}
