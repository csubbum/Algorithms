
public class LinearSearch {


	public static int[] SearchSort(int a[]) {
		
		//
		int startCount = 0;
		
		while(startCount <= a.length-1) {
			int minVal = a[startCount];
			int minCount = startCount;
			for (int i=startCount;i<=a.length-1;i++) {
				if(minVal > a[i]) {
					minVal = a[i];
					minCount = i;
				}
				
			}
			
			swap(a,startCount, minCount);
			startCount++;
			
			
		}
		return a;
	}

	private static void swap(int[] a, int startCount, int minVal) {
		
		int temp = a[startCount];
		 a[startCount] = a[minVal];
		 a[minVal] = temp;

		 
	}
	
	public static void main(String args[]) {
		int a[] = {1,3,2,44,7,12,14,0,25,33};
		for (int i : SearchSort(a)) {
			System.out.println(i);
		}
	}
}
