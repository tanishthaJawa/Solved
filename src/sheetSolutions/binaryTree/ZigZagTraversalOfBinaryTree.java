package sheetSolutions.binaryTree;

import java.util.*;
import java.util.stream.Collectors;

/*
The idea is to keep track of current level and is similar like level order traversal
 */
public class ZigZagTraversalOfBinaryTree {
    public ArrayList<Integer> zigZagTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> zigZagTraversal = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRightTraversal = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Node> nodesAtCurrentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                nodesAtCurrentLevel.add(currNode);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

            }

            if (!leftToRightTraversal) {
                Collections.reverse(nodesAtCurrentLevel);
            }


            for (Node currNode : nodesAtCurrentLevel) {
                zigZagTraversal.add(currNode.data);
            }

            leftToRightTraversal = !leftToRightTraversal;
        }

        return zigZagTraversal;
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

        ZigZagTraversalOfBinaryTree traversalOfBinaryTree = new ZigZagTraversalOfBinaryTree();
        System.out.println(traversalOfBinaryTree.zigZagTraversal(root).stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
