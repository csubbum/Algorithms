package BitSet;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]) {
		Test test = new Test();
		char[] arr = {'e','o','b', 'a','m','g', 'l'} ;
		String[] Dict = {"go","bat","me","eat","goal", "boy", "run"};
		for ( String out : test.getDicWords(arr,Dict) ) {
			System.out.println(out);
		}
	}
	
	public List<String> getDicWords(char[] arr, String[] dict) {
		List<String> output = new ArrayList<String>();
		for(String dic : dict) {
			String temp = dic;
			for(char cur : arr) {
				
				if(dic.contains(String.valueOf(cur))) {
					temp = temp.replaceFirst(String.valueOf(cur), "");
					
				}
				
				if(temp.isEmpty()) {
					output.add(dic);
					break;
				}
			}
			

		}
		return output;
	}
}
