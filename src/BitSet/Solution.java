package BitSet;

import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] x = {3,2,1,5,2,7,6};
		
		System.out.println(s.hIndex(x));
	}
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
         
        Arrays.sort(citations);
        // Reverse the array
        int m = 0;
        int n = citations.length - 1;
        while (m < n) {
            swap(citations, m, n);
            m++;
            n--;
        }
         for (int i : citations) {
        	 System.out.print(i + " ");
         }
         System.out.println("");
        int len = citations.length;
         
        int i = 0;
        for (i = 0; i < len; i++) {
        	System.out.println(i + " "+citations[i]);

            if (i + 1 > citations[i]) {
                return i;
            }
        }
         
        return i;
    }
     
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}