package collection.list;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArrayExample {
    public static void main(String[] args) {
        // ArrayList 생성 및 값 추가
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("값1");
        arrayList.add("값2");
        arrayList.add("값3");

        // ArrayList을 배열로 변환
        String[] stringArray = new String[arrayList.size()];
        arrayList.toArray(stringArray);

        // 변환된 배열 출력
        for (String value : stringArray) {
            System.out.println(value);
        }
        
        System.out.println(arrayList.hashCode()); // 출력: 예측 불가능한 값
        System.out.println(stringArray.hashCode()); // 출력: 예측 불가능한 값

       
    }
}