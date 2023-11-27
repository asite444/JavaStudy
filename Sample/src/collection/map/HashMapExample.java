package collection.map;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 HashMap
 <Key,Value> 로 저장되는 방식
 Key값은 중복 불가
 Value 값은 중복이 허용됨
 
 각 값은 Key값을 참조하여 Value를 가져온다.
 해당 자료구조는 순서 무관하다.  
*/
public class HashMapExample {

	public static void main(String[] args) {
		//      Key  , Value       
		HashMap<String, String> chinaCity=new HashMap<String, String>();	
		
		chinaCity.put("북경", "北京");
		chinaCity.put("상해", "上海");
		System.out.println(chinaCity.get("상해"));
		chinaCity.put("청두", "青岛");
		System.out.println(chinaCity.get("청두"));
		
		//이미 저장 된 Key값에 다시 집어 넣을 경우, Value 값은 수정됨
		chinaCity.put("청두", "成都");
		System.out.println(chinaCity.get("청두"));
		chinaCity.put("충칭", "重庆");
		chinaCity.put("난징", "南京");
		chinaCity.put("하얼빈", "哈尔滨");
		chinaCity.put("샤면", "厦门");
		chinaCity.put(null, "없음");//Null 허용
		System.out.println(chinaCity.get("충칭")+"<------------------");
		
		for (Entry<String, String> entry : chinaCity.entrySet()) {
		    System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
		}
		
	}
	
	

	
}
