import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestUniqueLetter {

//	public int lengthOfLongestSubstring(String s) {
//        int l = 0;
//        int start = 0;
//        int end = s.length();
//		for(int i=start;i<=end;i++) {
//			for(int j=i+1;j<=end;j++) {
//				l=uniqueString(s.substring(i,j)) ? Math.max(j-i, l) : l;
//			}
//		}
//        return l;
//    }
	
	public int lengthOfLongestSubstring(String s) {
		 int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	    }
	    public boolean uniqueString(String s) {
	    	
	        return s.chars().distinct().mapToObj(c -> Character.valueOf((char) c)).collect(Collectors.toList()).size() == s.length();
	    }
	    
	    public static void main(String args[]) {
	    	System.out.println(new LongestUniqueLetter().lengthOfLongestSubstring("subrajs"));
	    }
}
