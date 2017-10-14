
public class QuickSort {
	
	public static void partition(int a[], int start, int end) {
		int partStart = start-1;
		int partEnd =start;
		int pivot = a[end];
		
		while(partEnd <= end ) {
			if(a[partEnd] <= pivot) {
				partStart ++;
				swap(a, partStart, partEnd);
			}
			partEnd++;
		}
	}

	private static void swap(int[] a, int partStart, int partEnd) {
		int temp =a[partStart];
		a[partStart] = a[partEnd];
		a[partEnd] = temp;
		
	}
	
	public static void quickSort(int[] a, int start, int end) {
		if(start<end) {
			partition(a, start, end);
			System.out.println("first"+ start + " " + (((start+end)/2)-1) + " " + end);
			quickSort(a,start, ((start+end)/2)-1);
			System.out.println("second" + start + " " + (((start+end)/2)+1) + " " + end);
			quickSort(a,((start+end)/2)+1, end);
		}
	}
	
	public static void main(String args[]) {
		int a[] = {2,3,44,12,14,22,8};
		quickSort(a,0,a.length-1);
		
		for(int ai:a) {
			System.out.println(ai);
		}
	}

}






   //    