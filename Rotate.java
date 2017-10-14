import java.util.ArrayList;
import java.util.List;

public class Rotate {
	public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
       int[][] ret = new int[n][n];

   for (int i = 0; i < n; i++) {
       for (int j = 0; j < n; j++) {
           ret[i][j] = matrix[n - j - 1][i];
       }
   }

   return ret;
   }
	
	public static void rotate2(int[][] matrix) {
	    int N = matrix.length;
	    for(int i = 0; i < N/2; ++i) {
	        for(int j = 0; j < (N+1)/2; ++j) {
	            int temp = matrix[i][j];  // save the top element;
	            matrix[i][j] = matrix[N-1-j][i];  // right -> top;
	            matrix[N-1-j][i] = matrix[N-1-i][N-1-j]; // bottom -> right;
	            matrix[N-1-i][N-1-j] = matrix[j][N-1-i];// left -> bottom;
	            matrix[j][N-1-i] = temp;                // top -> left;
	        }
	    }
	}
	
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		/* "Visit" the root */
        ArrayList<Integer> current = new ArrayList<Integer>();
		
        if (root != null) {
			current.add(root.val);
		}
		
		
		ArrayList<TreeNode> roots = new ArrayList<TreeNode>();
		roots.add(root);
		
		while (current.size() > 0) {
			
			result.add(current); // Add previous level
			ArrayList<TreeNode> parents = roots; // Go to next level
			
			current = new ArrayList<Integer>(); 
			parents =new ArrayList<TreeNode>();
			
			for (TreeNode parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					parents.add(parent.left);
					current.add(parent.left.val);
				}
				if (parent.right != null) {
					parents.add(parent.right);
					current.add(parent.right.val);
				}
			}
		}

		return result;
    
}
	public static void main(String args[]) {
		
	int[][] array = {{ 1,2,3,4 },
		    { 5,6,7,8 },
		    { 9,0,1,2 },
		    { 3,4,5,6 }
		};
	printMatrix(array);
	System.out.println("");
	printMatrix(new Rotate().rotate(array));

	System.out.println("");

	new Rotate().rotate2(array);
	printMatrix(array);
	
}
	static void printMatrix(int[][] grid) {
	    for(int r=0; r<grid.length; r++) {
	       for(int c=0; c<grid[r].length; c++)
	           System.out.print(grid[r][c] + " ");
	       System.out.println();
	    }
	}
	
	
}
