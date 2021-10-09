package sheetSolutions.binaryTree;

import java.util.Stack;

public class postOrderTraversal{
    static void postOrder(Node root){
        if (root == null) {
            return;
        }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
    }
    static void postOrderIterative(Node root){
        // use two stacks
        Stack<Node> s= new Stack<>();
        s.push(root);
        // create another stack to store postorder traversal
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()){
            Node curr=s.pop();
            t.push(curr.data);//output stack

            if(curr.left!=null){
                s.push(curr.left);
            }
            if(curr.right!=null){
                s.push(curr.right);
            }
        }
        while (!t.isEmpty()){
            System.out.print(t.pop()+" ");
        }
    }

    public static void main(String[] args) {
         /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
         postOrder(root);
        System.out.println();
        postOrderIterative(root);
    }
}
