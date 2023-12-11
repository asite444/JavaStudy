package myutill;

public class MyMath {
	
	/**
	 * 두 수의 최대공약수를 구함
	 * @param a 
	 * @param b
	 * @return
	 */
	static int gcd(int a, int b) { 
		if(a%b ==0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
	/**
	 * 두 수의 최대공약수 메소드를 사용하여(gcd(a,b)) 최소공배수를 구함
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int lcm(int a, int b)
	{
	    return a * b / gcd(a,b);
	}
}
