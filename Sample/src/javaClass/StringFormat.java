package javaClass;

import java.time.LocalDateTime;

public class StringFormat {

	public static void main(String[] args) {
		String str = "StringFormatExample";
        boolean bool = true;
        int n = 1234;
        LocalDateTime now = LocalDateTime.now();
        
        String result = String.format("문자열 서식: %s, %S", str, str);
        System.out.println(result);
        
        result = String.format("boolean 서식 문자열: %B, %b", bool, bool);
        System.out.println(result);
        
        result = String.format("정수 서식: %d, %o, %x, %05d", n, n, n, n); 
        System.out.println(result);  // %05d → 5자리수, 공백을 0으로 채움
        
        result = String.format("부동 소수점 서식: %4$e, %3$f, %2$g, %1$a", 1234.01, 1234.02, 1234.03, 1234.04);
        System.out.println(result);  // %숫자$ 로 절대 인수 인덱스 지정
        
        result = String.format("날짜/시간 서식: %tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", now);
        System.out.println(result);  // $< 로 상대 인덱스 지정하여 직전의 인수와 같은 인덱스를 이용
        

	}

}
