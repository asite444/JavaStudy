package studyjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedIOExample {
    public static void main(String[] args) {
        try {
            // BufferedWriter를 사용한 파일 쓰기 예시
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Hello, World!");
            writer.newLine(); // 새로운 줄로 이동
            writer.write("This is an example of BufferedWriter.");
            writer.newLine(); // 새로운 줄로 이동
            writer.write("我现在学JAVA。");
            writer.close(); // 파일 쓰기 종료

            // BufferedReader를 사용한 파일 읽기 예시
            BufferedReader reader = new BufferedReader(new FileReader("output.txt")); 
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // 한 줄씩 읽어서 출력
            }
            reader.close(); // 파일 읽기 종료
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
