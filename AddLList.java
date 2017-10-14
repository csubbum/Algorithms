
public class AddLList {

	    
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2 ){
	        return addTwoNumbers(l1,  l2,  0);
	    }
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
	  
	        if(l1 != null || l2 != null) {
	            int out = l1!=null ? l1.val+carry : carry;
	            out += l2!=null ? l2.val : 0;
	            if(String.valueOf(out).length() > 1) {
	                carry = Integer.valueOf(String.valueOf(String.valueOf(out).charAt(0)));
	                out = Integer.valueOf(String.valueOf(String.valueOf(out).charAt(1)));
	            } else {
	                carry =0;
	            }
	            ListNode node = new ListNode(out);
	            
	            node.next = addTwoNumbers(l1!=null ? l1.next : l1, l2!=null ? l2.next : l2,carry);
	            return node;
	        } 
	        
	            
	            return null;
	        
	    }
	    
	    public static void main(String args[]) {
	    	ListNode l1 = new ListNode(2);
	    	l1.next = new ListNode(5);
	    	l1.next.next = new ListNode(4);
	    	
	    	ListNode l2 = new ListNode(4);
	    	l2.next = new ListNode(5);
	    	l2.next.next = new ListNode(4);
	    	
	    	ListNode l3= new AddLList().addTwoNumbers(l1,l2);
	    	while(l3!= null) {
	    		System.out.println(l3.val);
	    		l3 = l3.next;
	    	}
	    	
	    }
	    
	    
	
}
