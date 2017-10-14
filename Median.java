import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Median {

	
	


void merge(int[] a, int[] b, int lastA, int lastB) {
	
	int indexA = lastA-1;
	int indexB = lastB-1;
	int lastIndex = indexA + indexB + 1;
	
	while(indexB>=0 ) {
		if(indexA>=0 && b[indexB]>=a[indexA]) {
			a[lastIndex] = b[indexB];
			indexB--;
		} else {
			a[lastIndex] = a[indexA];
			indexA--;
		}
		lastIndex--;
	}
	
}


	  public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;

	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }


public static void main(String args[])
 {
	String[] str = {"sub", "sss", "bus","from", "sus", "morf", "form" };
	groupAnagrams(str).forEach(System.out::println);
	
 }
 }
