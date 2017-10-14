package SelectionSort;
public class SelectionSort {
	public static void main(String args[]) {
		// create array
		int[] input = {1,22,-5,11,5,3,0};
		selectionSort(input);
		for(int i : input) {
			System.out.print(i + " ");
		}
	}

	public static void selectionSort(int[] arr) {
	      int i, j, minIndex, tmp;
	      int n = arr.length;
	      for (i = 0; i < n - 1; i++) {
	            minIndex = i;
	            for (j = i + 1; j < n; j++)
	                  if (arr[j] < arr[minIndex])
	                        minIndex = j;
	            if (minIndex != i) {
	                  tmp = arr[i];
	                  arr[i] = arr[minIndex];
	                  arr[minIndex] = tmp;
	            }
	      }
	}
	
}
