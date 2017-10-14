
public class StringReverse {
	public static void main(String args[]) {
		String str = "sudha gummadi";
		java.util.Stack<Character> s = new java.util.Stack<Character>();
		 str.chars().forEach(r -> s.push((char) r));
		 StringBuilder out = new StringBuilder();
		 while(!s.isEmpty()) {
			 out.append(s.pop());
		 }
		 System.out.println(out.toString());
		 
		
	}

}
