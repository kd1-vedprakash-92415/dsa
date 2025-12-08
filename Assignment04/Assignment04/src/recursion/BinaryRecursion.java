package recursion;

import java.util.Scanner;

public class BinaryRecursion {
	static void printBinary(int n) {
		if(n == 0) 
			return;
		printBinary(n/2);
		System.out.print(n%2);
	}
	public static void main(String[] args) {
		System.out.println("Decimal to Binary converter");
		System.out.println("Enter number to convert:");
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		if(num == 0)
			System.out.println(0);
		else
			System.out.print("Binary:");
			printBinary(num);
			 
	}

}
