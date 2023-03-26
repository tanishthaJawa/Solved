package sheetSolutions.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostorderAndInorder {
    public Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hs = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            hs.put(inorder[idx], idx);
        }
        System.out.println("Hi");

        return constructTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1, hs);
    }

    private Node constructTree(int[] postorder, int postOrderStartIdx, int postOrderEndIdx, int inorderStartIdx, int inorderEndIDx, Map<Integer, Integer> hs) {
        if (postOrderEndIdx < postOrderStartIdx ||inorderEndIDx< inorderStartIdx ) {
            return null;
        }
        System.out.println("hello");
        Node root = new Node(postorder[postOrderEndIdx]);
        System.out.print(postorder[postOrderEndIdx]);
        int rootIdx = hs.get(root.data);
        System.out.print(rootIdx);
        int nodesToTheLeftIdx = rootIdx - inorderStartIdx;
        root.left = constructTree(postorder, postOrderStartIdx + 1, nodesToTheLeftIdx + postOrderStartIdx, inorderStartIdx, rootIdx - 1, hs);
        root.right = constructTree(postorder, nodesToTheLeftIdx + postOrderStartIdx + 1, postOrderEndIdx, rootIdx + 1, inorderEndIDx, hs);
        return root;
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        BinaryTreeFromPostorderAndInorder treeFromPreorderAndInorder = new BinaryTreeFromPostorderAndInorder();

        Node root = treeFromPreorderAndInorder.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        treeFromPreorderAndInorder.preOrder(root);
    }


}
