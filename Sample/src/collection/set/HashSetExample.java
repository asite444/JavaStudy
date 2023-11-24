package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/*
기본적으로 Set혹은 Set계열을 구현하는 클래스들은 다음과 같은 공통점이 있다.
1. 중복되는 요소(원소)를 허용하지 않는다.
2. 저장 순서를 유지하지 않는다. (LinkedHashSet 만 예외)
 */
public class HashSetExample {

	public static void main(String[] args) {

		Set<String> set=new HashSet<String>();

		//순서는 없음
		set.add("충칭"); //오토박싱
		set.add("청두");
		set.add("상해");
		set.add("난징");
		set.add("북경");
		set.add("하얼빈");

		if(!set.add("북경")) System.out.println("중복 불허");

		System.out.println(set);
		System.out.println("set의 size:"+set.size());

		for(String i:set) System.out.print(i+" ");
		System.out.println();
		//제내릭을 사용하지 않은 경우(절대 이렇게 짜면 안됨)
		/*  for(Object i:set) {
	    	Integer nomb=(Integer) i;
	    	System.out.printf("%d ",nomb);
	    }
		 */
		Iterator<String> iterator=set.iterator();
		
		while(iterator.hasNext()) { //값이 존재할 동안
			String city=iterator.next(); //다음 값으로
			System.out.println(city);
		}
		
		String[] arr=new String[set.size()];
		set.toArray(arr);//arr배열에 set 객체 집어넣기
		
		for(String s:arr) {
			System.out.print(s+" ");
		}
	}

}
