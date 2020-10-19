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

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Node root) {     // recursive preorder traversal

        System.out.print(root.data + " ");

        if(root.left != null)
        {
            preOrder(root.left);
        }
        if(root.right != null)
        {
            preOrder(root.right);
        }
    }

    public static void preOrder(Node root)           // Iterative preorder travesal version
    {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(!stack.empty() || curr != null )       // cheack if node is empty or stack of right elements is empty
        {
            while(curr != null)                      // go until the end of all left elements
            {
                System.out.print(curr.data + " ");  // print curr element
                if(curr.right != null)              // push right element to stack for futher use
                {
                    stack.push(curr.right);
                }
                curr = curr.left;                   // assign curr left to curr 
            }

            if(!stack.empty())                      // pick right element from stack and assign to curr
            {
                curr = stack.pop();
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
        preOrder(root);
    }	
}
