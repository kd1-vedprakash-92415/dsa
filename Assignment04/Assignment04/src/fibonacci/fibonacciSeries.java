package fibonacci;

import java.util.Scanner;

public class fibonacciSeries {
	static int fibonacci(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
		
	}
	public static void main(String[] args) {
		System.out.println("Enter number to find fibonacci series");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Fibonacci series:" + fibonacci(n));
	}

}
