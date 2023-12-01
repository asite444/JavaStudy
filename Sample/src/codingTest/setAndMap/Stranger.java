package codingTest.setAndMap;


/*첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
 *이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과,
 *N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 
 *이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며,
 *그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.

예제 입력 1 
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton

예제 출력 1 
2
baesangwook
ohhenrie*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Stranger {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Set<String> set=new HashSet<String>();
		List<String> list=new ArrayList<String>();

		StringTokenizer st=new StringTokenizer(br.readLine());

		int count1=Integer.parseInt(st.nextToken());
		int count2=Integer.parseInt(st.nextToken());
		String person;
		int countPerson=0;
		for(int i=0;i<count1;i++) {
			set.add(br.readLine());
		}

		for(int i=0;i<count2;i++) {
			person=br.readLine();
			if(set.contains(person)) {
				countPerson++;
				list.add(person); 
			}

		}
		Collections.sort(list);

		for(String s:list) sb.append(s).append("\n");
		System.out.println(countPerson);
		System.out.println(sb);

	}

}
