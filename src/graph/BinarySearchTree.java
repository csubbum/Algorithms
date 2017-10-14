package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree {

	private BinaryNode rootNode;
	
	public ArrayList<BinaryNode>[] bnArray = new ArrayList[5];
	
	BinarySearchTree (int rootVal) {
		rootNode = new BinaryNode(rootVal);
		
	}
	
	public void addNode(int value) {
		rootNode = addNode(rootNode, value);
	}
	// Traverse Node 
	
	
	
	public void inorderTraversal (BinaryNode node) {
		if(node!=null) {
			inorderTraversal (node.getNodeLeft());
			System.out.print(node.getValue()+ "-->");
			inorderTraversal (node.getNodeRight());
		}
	}
	
	public void preorderTraversal (BinaryNode node) {
		if(node!=null) {
			System.out.print(node.getValue()+ "-->");
			preorderTraversal (node.getNodeLeft());
			preorderTraversal (node.getNodeRight());
		}
	}
	
	public void postorderTraversal (BinaryNode node) {
		if(node!=null) {
			
			
			postorderTraversal (node.getNodeLeft());
			postorderTraversal (node.getNodeRight());
			System.out.print(node.getValue()+ "-->");
			
		}
	}
	
	public int findTreeHeight (BinaryNode rootNode) {
		if(rootNode==null) {
			return 0;
		}
		
		int lHeight = findTreeHeight(rootNode.getNodeLeft());
		int rHeight = findTreeHeight(rootNode.getNodeRight());
		int out = 0;
		if(lHeight>rHeight) {
			out=  lHeight+1;
		}  else {
			out = rHeight+1;
		}
		if(bnArray[out]==null) {
			bnArray[out] = new ArrayList<BinaryNode>();
		}
		bnArray[out].add(rootNode);
		return out;
	}
	

	private BinaryNode addNode(BinaryNode rootNode2, int value) {
		if(rootNode2 == null) {
			return new BinaryNode(value);
		}
		if(value <= rootNode2.getValue()) {
			rootNode2.setNodeLeft(addNode(rootNode2.getNodeLeft(),value));
		} else {
			rootNode2.setNodeRight(addNode(rootNode2.getNodeRight(),value));
		}
		return rootNode2;
		
	}
	
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree(8);
		bst.addNode(6);
		bst.addNode(10);
		bst.addNode(3);
		bst.addNode(7);
		bst.addNode(1);
		bst.addNode(9);
		bst.addNode(22);
		System.out.println("Inorder traversal --->");
		bst.inorderTraversal(bst.getRootNode());
		System.out.println("");
		System.out.println("Preorder traversal --->");
		bst.preorderTraversal(bst.getRootNode());
		System.out.println("");
		System.out.println("Postorder traversal --->");
		bst.postorderTraversal(bst.getRootNode());
		System.out.println("");
		System.out.println("Tree height: " + bst.findTreeHeight(bst.getRootNode()));
		int count = 0;
		
		for(ArrayList<BinaryNode> bns : bst.bnArray) {
			System.out.println("level --- " + count++ +  "---");
			if(bns!=null) {
			
			
			for(BinaryNode bn : bns) {
				System.out.print (bn.getValue());
			}
			}
		}
	}

	
	public BinaryNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(BinaryNode rootNode) {
		this.rootNode = rootNode;
	}
	
}


class BinaryNode {
	private int value;
	private BinaryNode nodeRight;
	private BinaryNode nodeLeft;
	
	BinaryNode(int value) {
		this.value = value;
	}
	
	public BinaryNode getNodeRight() {
		return nodeRight;
	}
	public void setNodeRight(BinaryNode nodeRight) {
		this.nodeRight = nodeRight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryNode getNodeLeft() {
		return nodeLeft;
	}
	public void setNodeLeft(BinaryNode nodeLeft) {
		this.nodeLeft = nodeLeft;
	}
}