package sheetSolutions.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This program aims to find the left view of binary tree.
public class leftViewOfBinaryTree {
    static ArrayList<Integer> leftView(Node root){
        if(root==null)
            return new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        ArrayList<Integer> result= new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()){
            int count=q.size(); // number of nodes at current level
            for (int i = 0; i < count ; i++) { // Traverse all nodes of current level
                Node temp= q.poll(); //current node
                if(i==0){
                   result.add(temp.data);   // Print the left most element at the level
                }
                if(temp.left!=null){ // Add all the children of node
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return result;
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

        System.out.println(leftView(root));
    }
}
