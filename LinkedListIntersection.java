import java.util.HashMap;
import java.util.Map;

public class LinkedListIntersection {
	 Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
	
	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	
			  while(headB != null) {
				  map.put(headB.val, headB);
				  headB = headB.next;
			  }
		 
			  while(headA != null) {
				  if(map.containsKey(headA.val)) return headA;
				  headA = headA.next;
			  }
		  
		  return null;
	        
	    }
	  
	  
}
class ListNode {
	     int val;
	    ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
