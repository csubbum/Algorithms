
public class LinkedList {

	Node firtNode;
	
	public boolean addData (int val, int location) {
		Node insertNode = this.firtNode;
		while(insertNode!=null) {
			if(--location == -1) {
				insertNode.setNextNode(new Node(val,insertNode.getNextNode()));
				return true;
			} else {
				insertNode = insertNode.getNextNode();
				
			}
		}
		return false;
	}
	
	public void removeValue(int val) {
		Node removeNode = this.firtNode;
		while(removeNode!=null) {
		if(removeNode!=null) {
			if(removeNode.getVal() == val) {
				removeNode.setNextNode(firtNode.getNextNode().getNextNode()); 
			} 
		}
		}
	}
	
}

class Node {
	private int val;
	private Node nextNode;
	Node(int val, Node nextNode) {
		this.setVal(val);
		this.nextNode = nextNode;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}