package BitSet;

public class Test2 {

	public static void main(String args[]) {
		String a = "goddf";
		String b= "dogdfsdfs";
		Test2 test = new Test2();
		System.out.println(test.isPalindrome(a,b));
	}

	private boolean isPalindrome(String a, String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		int len = a.length();
		for(int i=0; i<a.length(); i++) {
			if(String.valueOf(a.charAt(i)).equals(String.valueOf(b.charAt(--len)))) {
					continue;
			} else {
				return false;
			}
		}
		
		return true;
		
		
	}
}
