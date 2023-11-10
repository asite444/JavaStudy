package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {

	private static List<String> stact=new ArrayList<String>();

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{

		Scanner scanner=new Scanner(System.in);
		int commandLine=scanner.nextInt();

		String command;
		for(int i=0;i<commandLine;i++) {
			command=scanner.next();
			switch (command) {
			case "push" : push(scanner.next()); break; 
			case "top"  : top();				break;
			case "size" : size();				break;
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
		stact.add(number);		
	}

	public static void top() throws IOException {
		if(stact.size()<=0) bw.write("-1");
		else bw.write(stact.get(stact.size()-1));
		bw.write("\n");
	}

	public static void size() throws IOException {
		bw.write(Integer.toString(stact.size()));
		bw.write("\n");

	}

	public static void empty() throws IOException {
		if(stact.size()<=0) bw.write("1");
		else bw.write("0");
		bw.write("\n");
	}

	public static void pop() throws IOException {
		if(stact.size()<=0) bw.write("-1");
		else
		{
			bw.write(stact.get(stact.size()-1));
			stact.remove(stact.size()-1);
		}
		bw.write("\n");
	}


}
