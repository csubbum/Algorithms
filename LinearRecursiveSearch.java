
public class LinearRecursiveSearch {

	public static int search(int[] a, int currentVal, int val) {
		
		if(a[++currentVal] == val) return currentVal; 
		return search (a,currentVal,val);
	}
	
	public static void main(String args[]) {
		int[] a = {1,2,3,5,6,32,33,44,52,122};
		System.out.println(search(a,-1,22));
	}
}
