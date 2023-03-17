package sheetSolutions.binaryTree;

import java.util.ArrayList;
/*
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.

 The boundary includes :

left boundary (nodes on left excluding leaf nodes)
leaves (consist of only the leaf nodes)
right boundary (nodes on right excluding leaf nodes)
The left boundary is defined as the path from the root to the left-most node. The right boundary is defined as the path from
the root to the right-most node. If the root doesn’t have left subtree or right subtree, then the root itself is left boundary
or right boundary. Note this definition only applies to the input binary tree, and not apply to any subtrees.
 */
public class BoundaryTraversal {
    public ArrayList<Integer> boundary(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> boundaryTraversal = new ArrayList<>();
        boundaryTraversal.add(root.data);

        printLeftNodes(root.left, boundaryTraversal);

        // for left subtrees and right subtrees we need to have two separate calls
        printLeaves(root.left, boundaryTraversal);
        printLeaves(root.right, boundaryTraversal);

        printRightNodes(root.right, boundaryTraversal);
        return boundaryTraversal;

    }

    private void printRightNodes(Node root, ArrayList<Integer> boundaryTraversal) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            // to ensure bottom up order, first call for right subtree, then print this node
            printRightNodes(root.right, boundaryTraversal);
            boundaryTraversal.add(root.data);

        } else if (root.left != null) {
            printRightNodes(root.left, boundaryTraversal);
            boundaryTraversal.add(root.data);
        }
    }

    private void printLeaves(Node root, ArrayList<Integer> boundaryTraversal) {
        if (root == null) {
            return;
        }
        printLeaves(root.left, boundaryTraversal);

        if (root.left == null && root.right == null) {
            boundaryTraversal.add(root.data);
        }
        printLeaves(root.right, boundaryTraversal);
    }

    private void printLeftNodes(Node root, ArrayList<Integer> boundaryTraversal) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            // to ensure top down order, print the node before calling itself for left subtree
            boundaryTraversal.add(root.data);

            printLeftNodes(root.left, boundaryTraversal);
        } else if (root.right != null) {
            boundaryTraversal.add(root.data);
            printLeftNodes(root.right, boundaryTraversal);
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

        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.boundary(root).forEach(System.out::println);
    }
}
