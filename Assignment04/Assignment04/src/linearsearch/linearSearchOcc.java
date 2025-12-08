package linearsearch;

import java.util.Scanner;

public class linearSearchOcc {
//	public static int linearSearch(int arr[], int key) {
//		for(int i = 0 ; i < arr.length; i++) {
//			if(key == arr[i])
//				return i;
//		}
//		return -1;	
//	}
	
	public static int linearSearchOcc(int arr[], int key, int n) {
		if(n <= 0 )
			return -1;
		
		int count = 0;
		
		for(int i = 0 ; i< arr.length; i++) {
			if(arr[i]==key) {
				count++;
				if(count == n) {
				return i;
		}
	}
}
		
		return -1;
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		System.out.println("Enter "+ size+ " element:");
		for(int i = 0; i< size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the data to be searched :");
		int key = sc.nextInt();
		
		System.out.println("Enter the occurence number:");
		int n = sc.nextInt();
		
		int result = linearSearchOcc(arr, key, n);
		System.out.println("The "+n+ " occurence of"+key+"is at index "+result);
		
		
		
//		int[] arr = {10, 20, 30, 20, 40, 20, 50};
//		int key = 20;
//		int n = 2;
//
//		int index = linearSearchOcc(arr, key, n);
//		System.out.println("Index of " + n + "-th occurrence: " + index);
	}

}
