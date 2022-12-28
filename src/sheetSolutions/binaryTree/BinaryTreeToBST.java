package sheetSolutions.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BinaryTreeToBST {


        // The given root is the root of the Binary Tree
        // Return the root of the generated BST
        Node binaryTreeToBST(Node root)
        {
            // Your code here
            List<Integer> ar = new ArrayList<>();
            inOrder(root,ar);
            Collections.sort(ar);
            return createBinaryTree(ar,0,ar.size()-1);

        }

        void inOrder(Node root, List<Integer> list){

            if(root==null){
                return ;
            }
            inOrder(root.left,list);
            list.add(root.data);
            inOrder(root.right,list);
        }

        Node createBinaryTree( List<Integer> ar , int left, int right){
            if(left>right) return null;

            int mid = (left+right)/2;

            Node newNode = new Node(ar.get(mid));

            newNode.left = createBinaryTree(ar,left,mid-1);
            newNode.right = createBinaryTree(ar,mid+1,right);
            return newNode;
        }

}
