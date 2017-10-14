package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	Node rootNode;
	ArrayList nodeList;
	int[][] edge;
	int vertexCount;
	boolean directed;
	
	public Graph(int vertexCount, boolean directed) {
		this.vertexCount = vertexCount;
		this.directed = directed;
		edge = new int[vertexCount][vertexCount];
		nodeList = new ArrayList<Node>();
	}
	
	public void addVertex(Node val) {
		nodeList.add(val);
	}
	
	
	
	public void dft() {
		
		rootNode = (Node) nodeList.get(0);
		
		Stack<Node> stack = new Stack<Node>();
		stack.add(rootNode);
		Node n = null;
		
		System.out.println("Depth First traversal");
		
		while(!stack.isEmpty()) {
			n = stack.peek();
			if(!n.isVisited()) {
				System.out.print("--->" + n.getNodeName());
			}
			n.setVisited(true);
			Node cn = getUnvisitedChild(n);
			if(cn!=null) {
				cn.setVisited(false);
				stack.push(cn);
			} else {
				stack.pop();
			}
		}
		
	}
	
	
	public void bfs() {
		rootNode = (Node) nodeList.get(0);
		
		LinkedList<Node> queue = new LinkedList<Node>();
		
		queue.add(rootNode);
		
		while(!queue.isEmpty()) {
			Node n = queue.getFirst();
			queue.removeFirst();
			if(!n.isVisited()){
				System.out.print("Starting breadth first Traversal  ---> " + n.getNodeName());
				n.setVisited(true);
			} else {
				System.out.print(" ---> " + n.getNodeName());
			}
			Node cn = null;
			while((cn = getUnvisitedChild(n)) != null) {
					
				queue.addLast(cn);
				
				
			}
			
		}
	}
	
	
	private Node getUnvisitedChild(Node n) {
		int row = nodeList.indexOf(n);
		Node cn;
		int col=0;
		while(col<nodeList.size()) {
		if(edge[row][col] == 1 && !(cn=(Node) nodeList.get(col)).isVisited()) {
			cn.setVisited(true);
			return cn;
		}
		col++;
		}
		return null;
	}

	public void addEdge(Node from, Node to) {
		int start = nodeList.indexOf(from);
		int end = nodeList.indexOf(to);
		if(start == -1 || end == -1) {
			return;
		}
		
		edge[start][end] = 1;
		if(!directed) {
			edge[end][start] = 1;
		}
	}
	
	public static void main(String args[]) {
		Graph g = new Graph(5,false);
		
		Node na = new Node('a');
		Node nb = new Node('b');
		Node nc = new Node('c');
		Node nd = new Node('d');
		Node ne = new Node('e');
		g.addVertex(na);
		g.addVertex(nb);
		g.addVertex(nc);
		g.addVertex(nd);
		g.addVertex(ne);
		
		g.addEdge(na, nb);
		g.addEdge(na, nd);
		g.addEdge(na, ne);
		
		g.addEdge(nb, nd);
		
		g.addEdge(nb, nc);
		
		//g.bfs();
		g.dft();
		
	}
	
	

}

class Node{
	private char nodeName;
	private boolean visited = false;
	
	public Node(char nodeName) {
		this.setNodeName(nodeName);
	}

	public char getNodeName() {
		return nodeName;
	}

	public void setNodeName(char nodeName) {
		this.nodeName = nodeName;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}