package InsertionSort;

import java.util.ArrayList;

public class InsertionSort {
	public static void main(String args[]) {
		// create array
		int[] input = {1,22,-5,11,5,3,0};
		insertionSort(input);
		for(int i : input) {
			System.out.print(i + " ");
		}
	}

	static void insertionSort(int[] arr) {
	      int i, j, newValue;
	      // loop over the array
	      for (i = 1; i < arr.length; i++) {
	    	  // newvalue value of i
	    	  // j is i count
	            newValue = arr[i];
	            j = i;
	            // count not the first one
	            // count = 0 greater than 1
	            // swap
	            while (j > 0 && arr[j - 1] > newValue) {
	                  arr[j] = arr[j - 1];
	                  j--;
	            }
	            arr[j] = newValue;
	      }
	}

	

}
