import java.util.HashMap;
import java.util.Map;

public class AddArray {
	
	public static void main(String args[]) {
		int a[] = {1,33,12,4,5,3,10,24,28,20};
		
		int[] outs = twoSum(a, 22);
		for(int out : outs) {
			System.out.println();
			System.out.println(out);
		}
	}
	

	
	public int[] twoSums(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        
        for(int i=0; i<nums.length; i++) {
            
            int sub = target - nums[i];
            
            
            if(map.containsKey(sub)) {
                return new int[] {map.get(sub), i};
            }
            
            map.put(nums[i], i);
        }
        
      
        return null;
    }

	public static int[] twoSum(int[] num2, int target) {

		int[] output = new int[2];
        int[] nums = num2.clone();
		sort(nums);
		
		for(int num : nums) {
			System.out.print(num + ",");
		}
		
	       for(int num=0; num < nums.length-1; num++) {

	           
	           int element = nums[num];
	           int nextElement = nums[num+1];
	           
	           if(element+nextElement == target) {
	        	   output[0] = element;
	        	   output[1] = nextElement;
	        	   break;
	           }
	       }
	       
	       int count = 0;
	       int[] out = new int[2];
	       int outR =0;
	       for(int n:num2) {
	    	   if(outR > 1) break;
	    	   if(n ==  output[0] || n==output[1]) {
	    		   out[outR] = count;
	    		   outR++;
	    	   }
	    	  count++;
	       }
	       return out;
	        
	    }

	private static void sort(int[] nums) {
		quickSort(nums,0, nums.length-1);
		
	}
	
	// 3,8,44,22,11,2,7

	private static void quickSort(int[] nums, int start, int end) {
		if(start<end) {
			int piv = sort(nums,start,end);
			quickSort(nums,start,piv-1);
			quickSort(nums,piv+1,end);
			
		}

	}

	private static int sort(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start;
		int j = start-1;
		
		while(i<end) {
			if(nums[i]<=pivot) {
				j++;
				swap(nums,i,j);
			}
			i++;
		}
		
		j++;
		swap(nums,j,end);
		return j;
		
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
		
	}
}
