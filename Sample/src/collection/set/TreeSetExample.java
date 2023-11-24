package collection.set;

import java.util.Set;
import java.util.TreeSet;
/*
 TreeSet은 이진탐색트리 중에서도 성능을 향상시킨 레드-블랙 트리(Red-Black Tree)로 구현되어 있다. 
 일반적인 이진 탐색 트리는 트리의 높이만큼 시간이 걸린다. 데이터의 값이 트리에 잘 분산되어 있다면 효율성에 큰 문제가 없으나 
 데이터가 들어올 때 값이 편향되게 들어올 경우 한쪽으로 크게 치우쳐진 트리가 되어 굉장히 비효율적이다. 
 이 문제를 보완하기 위해 레드 블랙 트리가 적용되었다. 레드 블랙 트리는  부모노드보다 작은 값을 가지는 노드는 왼쪽 자식으로
,큰 값을 가지는 노드는 오른쪽 자식으로 배치하여 데이터의 추가나 삭제 시 트리가 한쪽으로 치우쳐지지 않도록 균형을 맞추어준다.
 */
public class TreeSetExample {

	public static void main(String[] args) {
	  Set<String> treeSet=new TreeSet<String>();
	  
	  treeSet.add("서울");
	  treeSet.add("충주");
	  treeSet.add("속초");
	  treeSet.add("부산");
	  treeSet.add("평양");
	  System.out.println(treeSet.contains("충주"));
	  

	  for(String s:treeSet) System.out.print(s+" ");
	}

}
