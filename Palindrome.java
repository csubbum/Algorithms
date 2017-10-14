
public class Palindrome {

	public String longestPalindrome(String s) {
        int max = 0;
        String palin = "";
        for(int i = 0; i<s.length();i++) {
             String palins = evaluateMiddle(s,i, i+1);
             String palins2 = evaluateMiddle(s,i-1, i+1);
             
             int length = Math.max(palins.length(), palins2.length());
             
             
            if(length>max) {
            	max=length;
            	if(palins.length()>palins2.length()) {
            		palin= palins;
            	} else {
            		palin =palins2;
            	}
            }
            
        }
        return palin;
    }
    
    public String evaluateMiddle(String s,int left, int right) {
        int l=left, r=right;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
    
    public static void main(String args[]) {
    	Palindrome p = new Palindrome();
    	System.out.println(p.longestPalindrome("abaabtteed"));
    }
}
