package codingTest.other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Queue {

	private static List<String> queue=new ArrayList<String>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		Scanner scanner=new Scanner(System.in);
		int commandLine=scanner.nextInt();

		String command;
		for(int i=0;i<commandLine;i++) {
			command=scanner.next();
			switch (command) {
			case "push" : push(scanner.next()); break; 
			case "front": front();   			break;
			case "size" : size();				break;
			case "back" : back();				break;
			case "empty": empty();				break;
			case "pop"  : pop();				break;
			default: 

			}

		}
		bw.flush();



		scanner.close();
		br.close();
		bw.close();

	}
	
	
	public static void push(String number) {
		queue.add(number);		
	}

	public static void back() throws IOException {
		if(queue.size()<=0) bw.write("-1");
		else bw.write(queue.get(queue.size()-1));
		bw.write("\n");
	}
	
	public static void front() throws IOException {
		if(queue.size()<=0) bw.write("-1");
		else bw.write(queue.get(0));
		bw.write("\n");
	}

	public static void size() throws IOException {
		bw.write(Integer.toString(queue.size()));
		bw.write("\n");

	}

	public static void empty() throws IOException {
		if(queue.size()<=0) bw.write("1");
		else bw.write("0");
		bw.write("\n");
	}

	public static void pop() throws IOException {
		if(queue.size()<=0) bw.write("-1");
		else
		{
			bw.write(queue.get(0));
			queue.remove(0);
		}
		bw.write("\n");
	}


}
