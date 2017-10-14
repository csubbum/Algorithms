
public class ReverseList {

	
	   public NotNode reverseList(NotNode head) {
	    if (head == null || head.next == null) return head;
	    NotNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	   public void printList(NotNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }
	   public static void main(String args[]) {
		   NotNode node = new NotNode(2);
		   node.next = new NotNode(5);
		   node.next.next = new NotNode(8);
		   new ReverseList().printList(node);
		 NotNode reverseNode = new ReverseList().reverseList(node);
		
		 System.out.println("");
		 System.out.println("Reversed 1");
		 new ReverseList().printList(reverseNode);
	   }
	   
	   
	
}

class NotNode {
    int val;
    NotNode next;
    public NotNode(int x) { this.val = x; }
}


  

