package leetCode;

import sheetSolutions.binarySearchTree.Node;

import java.util.Stack;

public class BinaryTreeToLinearLinkedList {

    //Approach 1 - Use recursion
    public void flatten(Node root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        Node left = root.left;
        Node right = root.right;

        root.left = null;
        root.right = left;

        Node temp = root;
        //To traverse to Last Node
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;

    }

    //Approach 2 use Stack
    public void flatten1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node node = st.pop();
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
            if (!st.isEmpty()) {
                node.right = st.peek();
            }
            node.left = null;
        }

    }

    //Approach 3 -Morris traversal
    public void flatten3(Node root) {
        if (root == null) {
            return;
        }
       Node curr = root;
        Node prev ;
        while(curr!=null){
            if(curr.left!=null){
                prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right; // find rightmost node on left side
                }
                prev.right = curr.right; // set right of rightmost node on left side to the right node of root
                curr.right = curr.left ;// set right of root to your left subtree
                curr.left=null;// set leftmost node of curr root to null
            }
            curr = curr.right;
        }

    }

}
