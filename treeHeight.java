import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {         // recursive version
      	// Write your code here.
          if(root == null)                        
          {
              return 0;
          }

          int leftHeight = height(root.left);
          int rightHeight = height(root.right);

          return 1 + Math.max(leftHeight, rightHeight); 
    }

    public static int height(Node root)                      // iterative version
    {
        if(root == null)
        {
            return 0;
        }

        int treeHeight = 0;
        Queue<Node> q = new LinkedList<Node>();               // used Queue for storing next level elements
        q.add(root);

        while(true)
        {
            int nodesOnLevel = q.size();                     // finding total elements in current level 
            if(nodesOnLevel == 0)
            {
                return treeHeight;                           // if total elements are 0 then we reach emd of tree return answer
            }
            treeHeight++;                                    // add 1 to tree height for every new level

            while(nodesOnLevel != 0)                         // visit every node in queue for current level
            {
                Node currNode = q.peek();
                q.remove();                                  // remove visited node from queue
                if(currNode.left != null)                    // add next level elements to queue
                {
                    q.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    q.add(currNode.right);
                }
                nodesOnLevel--;                              // reduce current level elements by 1 cause we visit 1 of them
            }
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}
