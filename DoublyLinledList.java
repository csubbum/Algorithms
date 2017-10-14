//
//public class DoublyLinledList {
//	
//	Node first;
//	Node last;
//	
//	DoublyLinledList() {
//		first = null;
//		last = null;
//	}
//	
//	
//	boolean isEmpty() {
//		return first == null ? true : false;
//	}
//	
//	public void addFirst(int val) {
//		Node node = new Node();
//		node.setVal(val);
//		if(isEmpty()) {
//			node.setNextNode(last);
//			node.setPreviousNode(null);
//			first = node;
//		} else {
//			first.setPreviousNode(node);
//			node.setNextNode(first);
//			first = node;
//			
//		}
//	}
//
//
//}
//
////class Node {
////	private int val;
////	private Node nextNode;
////	private Node previousNode;
////	Node() {
////		
////	}
////	Node(int val, Node nextNode, Node previousNode) {
////		this.setVal(val);
////		this.nextNode = nextNode;
////		this.setPreviousNode(previousNode);
////	}
////	public int getVal() {
////		return val;
////	}
////	public void setVal(int val) {
////		this.val = val;
////	}
////	public Node getNextNode() {
////		return nextNode;
////	}
////	public void setNextNode(Node nextNode) {
////		this.nextNode = nextNode;
////	}
////	public Node getPreviousNode() {
////		return previousNode;
////	}
////	public void setPreviousNode(Node previousNode) {
////		this.previousNode = previousNode;
////	}
////}