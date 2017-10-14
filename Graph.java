import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

	int vertexCount =0;
	private Vertex[] vertexes;
	public Vertex[] getVertexes() {
		return vertexes;
	}

	public void setVertexes(Vertex[] vertexes) {
		this.vertexes = vertexes;
	}

	Map<String, Integer> vertexMap = new HashMap<String,Integer>();
	Map<Integer, String> vertexIntLookup = new HashMap<Integer,String>();
	Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		vertexes = new Vertex[vertexCount];
	}
	
	public void addVertex(String vertex) {
		int current = vertexMap.size();
		vertexes[current] = new Vertex(vertex);
		vertexMap.put(vertex, current);
		vertexIntLookup.put(current, vertex);
	}
	
//	void BFS(int s)
//    {
//        // Mark all the vertices as not visited(By default
//        // set as false)
//        boolean visited[] = new boolean[vertexCount];
// 
//        // Create a queue for BFS
//        LinkedList<Integer> queue = new LinkedList<Integer>();
// 
//        // Mark the current node as visited and enqueue it
//        visited[s]=true;
//        queue.add(s);
// 
//        while (queue.size() != 0)
//        {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s+" ");
// 
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            
//            while (NodeG ng : vertexes[s].getRoot())
//            {
//                int n = i.next();
//                if (!visited[n])
//                {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//    }
	
	public void addEdge(String vertex, String edge) {
		vertexes[vertexMap.get(vertex)].addNode(vertexMap.get(edge));
	}
	
	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addEdge("a", "e");
		g.addEdge("a", "d");
		g.addEdge("c", "b");
		g.addEdge("d", "a");
		for (Vertex v : g.getVertexes()) {
			
			System.out.println("Vertex" + "---->" + v.getValue()  );
			System.out.println("Edges" + "---->");
			loopOverAllNodes(v.getRoot(), g);
			System.out.println("Next");
		}
		
	}

	private static void loopOverAllNodes(NodeG root, Graph g) {
		if(root!=null) {
		System.out.print( g.vertexIntLookup.get(root.getValue()) + "---->");
		loopOverAllNodes(root.getNextNode(),g);
		} 
			
		
	}
	
	
}

class Vertex{
	private NodeG root;
	private String value;
	
	public Vertex(String value) {
		this.value = value;
	}

	public NodeG getRoot() {
		return root;
	}
	
	public void addNode(int value){
		root = addNodeRec(root,value);
	}

	private NodeG addNodeRec(NodeG root2, int value) {
		if ( root2 == null) {
			root2 = new NodeG(value);
			return root2;
		} 
			root2.setNextNode(addNodeRec(root2.getNextNode(),value));
		
			return root2;
		
	}

	public void setRoot(NodeG root) {
		this.root = root;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}

class NodeG{
	private int value;
	private NodeG nextNode;
	
	public NodeG(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public NodeG getNextNode() {
		return nextNode;
	}
	public void setNextNode(NodeG nextNode) {
		this.nextNode = nextNode;
	}
	
}