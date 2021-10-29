package sheetSolutions.binaryTree;
/*
Given a Binary Tree  Convert this to a tree where each node contains the sum of the left and right sub- trees of the original tree.
The values of leaf nodes are changed to 0.

Example 1:

Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5
Output:
            20
          /    \
        4        12
       /  \     /  \
     0     0   0    0

Explanation:

           (4-2+12+6)
          /           \
      (8-4)          (7+5)
       /   \         /  \
      0     0       0    0

 */
public class convertToSumTree {
    static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
    public static void toSumTree(Node root){
        //add code here.
        sum(root);
    }
    private static int sum(Node root){
        if(root==null)
            return 0;
        int oldValue= root.data;// to get previous value for sum
        root.data =sum(root.left)+sum(root.right);// set the sum at the node
        return oldValue+ root.data;// return previous value of root as well so that they can be used for summation
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        inOrder(root);
        System.out.println();
        toSumTree(root);
        inOrder(root);
    }
}
