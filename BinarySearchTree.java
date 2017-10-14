
public class BinarySearchTree {

	static NodeB root;
	
	public static void addNode(int val) {
		
			root = insertNode(root,val);
		
	}
	
	public static NodeB insertNode(NodeB node, int val) {
		
		
		if(node==null) {
			NodeB n = new NodeB();
			n.setNodeValue(val);
			return n;
		}
		
		if(node.getNodeValue() > val) {
			node.setLeft(insertNode(node.getLeft(),val));
		} else {
			node.setRight(insertNode(node.getRight(),val));
		}
		
		return node;
	}

	public static void traverse(NodeB root) {
		if(root!=null) {
		traverse(root.getLeft());
		System.out.println(root.getNodeValue());
		traverse(root.getRight());
		}
	}
	
	public static void main(String args[]) {
		int[] a = {3,5,2,4,6,7,12,33,1};
		for(int ai : a) {
			addNode(ai);
		}
		traverse(root);
	}
}

class NodeB {
	
	private int nodeValue;
	private NodeB left;
	private NodeB right;
	
	public NodeB getLeft() {
		return left;
	}
	public void setLeft(NodeB left) {
		this.left = left;
	}
	public NodeB getRight() {
		return right;
	}
	public void setRight(NodeB right) {
		this.right = right;
	}
	public int getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}
	
}