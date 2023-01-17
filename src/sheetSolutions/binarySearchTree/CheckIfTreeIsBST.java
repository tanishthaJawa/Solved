package sheetSolutions.binarySearchTree;

/*
Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 */
public class CheckIfTreeIsBST {
    static boolean isBST(Node root) {
        // code here.
        return isBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTRecur(Node currNode, int lowerBound, int upperBound) {
    /*
    checks if left data is less than upperbound and more than lower bound
    checks if right data is more than lower bound and less than upperbound or if it is a leaf node
      */
        return currNode == null
                || ((lowerBound < currNode.data && currNode.data < upperBound)
                && isBSTRecur(currNode.left, lowerBound, currNode.data)
                && isBSTRecur(currNode.right, currNode.data, upperBound));
    }

    public static void main(String[] args) {
    /* Construct the following tree
               3
             /   \
            /     \
           2       7
          /      /   \
         /      /     \
        1      5       9
              / \
             /   \
            4    6
    */

        Node root1 = new Node(3);
        root1.left = new Node(2);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.right.left = new Node(5);
        root1.right.right = new Node(9);
        root1.right.left.left = new Node(4);
        root1.right.left.right = new Node(6);
        System.out.println(isBST(root1));
    }
}
