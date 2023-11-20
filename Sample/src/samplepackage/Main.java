package samplepackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		
		
    Scanner scanner=new Scanner(System.in);
    
    String address=scanner.nextLine();
    System.out.println(address.substring(0,6));
	}
}