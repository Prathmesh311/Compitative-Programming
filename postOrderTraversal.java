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

    public static void postOrder(Node root) {        // recursive version of postorder traversal

        if(root != null)
        {
            postOrder(root.left);

            postOrder(root.right);

            System.out.print(root.data + " ");

        }

    }


    public static void postOrder(Node root)                // recursive version of postorder traversal
    {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();           // used 2 stack for staring node and stack2 for storing postorder traversal sequence

        Node currNode = root;
        stack1.push(currNode);                            // push root to stack1
 
        while(!stack1.empty())
        {
            currNode = stack1.pop();
            stack2.push(currNode);                        // 1st push root to stack2 because it came out last from stack2 in postroder traversal

            if(currNode.left != null)         
            {
                stack1.push(currNode.left);
            }
            if(currNode.right != null)
            {
                stack1.push(currNode.right);
            }
        }

        while(!stack2.empty())                         // print all tree in postorder traversal 
        {
            Node node = stack2.pop();
            System.out.print(node.data + " ");
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
        postOrder(root);
    }
}
