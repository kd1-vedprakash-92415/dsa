package sortDesc;

public class SortDesc {
	    private static void heapifyMin(int[] arr, int n, int i) {
	        int smallest = i;
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        if (left < n && arr[left] < arr[smallest]) {
	            smallest = left;
	        }
	        if (right < n && arr[right] < arr[smallest]) {
	            smallest = right;
	        }

	        if (smallest != i) {
	            int temp = arr[i];
	            arr[i] = arr[smallest];
	            arr[smallest] = temp;

	            heapifyMin(arr, n, smallest);
	        }
	    }

	    public static void heapSortDescending(int[] arr) {
	        int n = arr.length;

	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapifyMin(arr, n, i);
	        }

	        for (int i = n - 1; i > 0; i--) {
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	            heapifyMin(arr, i, 0);
	        }
	    }

	    public static void printArray(int[] arr) {
	        for (int val : arr) {
	            System.out.print(val + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        int[] arr = {12, 11, 13, 5, 6, 7};
	        System.out.print("Original: ");
	        printArray(arr);

	        heapSortDescending(arr);

	        System.out.print("Descending: ");
	        printArray(arr);
	    }
	}

