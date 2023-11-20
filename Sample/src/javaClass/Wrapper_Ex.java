package javaClass;

public class Wrapper_Ex {
    public static void main(String[] args)  {
        String str = "10";
        String str2 = "10.5";
        String str3 = "true";
        
        byte b = Byte.parseByte(str);
        int i = Integer.parseInt(str);
        short s = Short.parseShort(str);
        long l = Long.parseLong(str);
        float f = Float.parseFloat(str2);
        double d = Double.parseDouble(str2);
        boolean bool = Boolean.parseBoolean(str3);
		
        System.out.println("문자열 byte값 변환 : "+b);
        System.out.println("문자열 int값 변환 : "+i);
        System.out.println("문자열 short값 변환 : "+s);
        System.out.println("문자열 long값 변환 : "+l);
        System.out.println("문자열 float값 변환 : "+f);
        System.out.println("문자열 double값 변환 : "+d);
        System.out.println("문자열 boolean값 변환 : "+bool);
        
        
        //자동 박싱,자동 언박싱 <--JDK5.0 이후
        
        
        
        Integer[] arr1= {//정석대로 할 경우
        		Integer.valueOf(1),
        		Integer.valueOf(2),
        		Integer.valueOf(3)
        };
        
        //자동박싱
        Integer [] arr2= {1,2,3};
        int n=arr2[0];//arr2[].intValue();<정석대로 할 경우
       
        
        
    }

}
