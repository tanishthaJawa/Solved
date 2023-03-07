package sheetSolutions.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalOfBinaryTree {
    public ArrayList<Integer> diagonalTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> diagonalTraversal = new ArrayList<>();
        Queue<Node> leftNodes = new LinkedList<>();
        Node curr = root;
        while (curr != null) {
            diagonalTraversal.add(curr.data);
            if (curr.left != null) {
                leftNodes.add(curr.left);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                if (!leftNodes.isEmpty()) {
                    curr = leftNodes.poll();
                } else {
                    curr = null;
                }
            }
        }
        return diagonalTraversal;
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
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.right.left = new Node(5);
        node.right.right = new Node(6);
        node.right.left.left = new Node(7);
        node.right.left.right = new Node(8);

        DiagonalTraversalOfBinaryTree traversalOfBinaryTree = new DiagonalTraversalOfBinaryTree();
        traversalOfBinaryTree.diagonalTraversal(node).forEach(System.out::println);
    }


}
