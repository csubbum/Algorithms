package BubbleSort;

public class BubbleSortBasic {

	public static void main(String args[]) {
		// create array
		int[] input = {1,22,-5,11,5,3,0};
		bubbleSort(input);
		for(int i : input) {
			System.out.print(i + " ");
		}
	}
	
	public static void bubbleSort(int[] input) {
		boolean repeat = false;
		for (int i = 0; i <input.length-1; i++) {
			if(input[i] > input[i+1]) {
				swap(input, i, i+1);
				repeat = true;
			}
		}
		if(repeat) {
			bubbleSort(input);
		}
	}
	
	public static void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
