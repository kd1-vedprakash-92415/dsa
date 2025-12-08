package insertionSort;

import java.util.Arrays;

public class InsertionSortDesc {
	public static void InsertionSort(int arr[],int N) {
		for(int i = 1; i<N;i++) {
			int temp = arr[i];
			int j;
			for(j = i-1; j>=0; j--) {
				if(arr[j]<temp) {
					arr[j+1] = arr[j];
				}
				else {
					break;
				}
			}
			arr[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		int arr[]={55, 44, 22, 66, 11, 33};
		System.out.println("Before Sorting:"+Arrays.toString(arr));
		InsertionSort(arr,arr.length);
		System.out.println("After Sorting in Descending order:"+Arrays.toString(arr));
	}	
}
