package sheetSolutions.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//
public class reverseLevelOrderOfBinaryTree {
    static ArrayList<Integer> reverseLevelOrder(Node node)
    {
        // code here
        if(node==null)
            return new ArrayList<>();
        Queue<Node> q= new LinkedList<>();
        ArrayList<Integer> result= new ArrayList<>();
        Stack<Node> s = new Stack<>();
        q.add(node);
        while(!q.isEmpty()){
            Node temp=q.poll();
            s.push(temp);
            if(temp.right!=null){
                q.add(temp.right);
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
        }
        while(!s.isEmpty()){
            result.add(s.pop().data);
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

        System.out.println(reverseLevelOrder(root));
    }
}
