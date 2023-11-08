package studyjava;

import java.util.Scanner;

public class FindingAlphabet {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		int n = 0;

		for (int i = 97; i < 123; i++) {
			n = 0;
			for (int j = 0; j < s.length(); j++) {

				if ((int) s.charAt(j) == i) {
					System.out.print(j + " ");
					n += 1;
					break;
				}

			}
			if (n == 0) {
				System.out.print(-1 + " ");
			}
		}
	}
}
