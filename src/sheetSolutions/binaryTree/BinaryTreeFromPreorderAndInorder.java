package sheetSolutions.binaryTree;

import java.util.*;

/*
Works if there is only unique values.
 */
public class BinaryTreeFromPreorderAndInorder {
    public Node build(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderNodes = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            inorderNodes.put(inorder[idx], idx);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderNodes);
    }

    private Node buildTree(int[] preorder, int preStartIdx, int preEndIdx, int inStartIdx, int inEndIdx, Map<Integer, Integer> inorderNodes) {
        if (preStartIdx > preEndIdx || inStartIdx > inEndIdx) {
            return null;
        }
        Node root = new Node(preorder[preStartIdx]);
        int rootIdx = inorderNodes.get(root.data);
        int nodesToTheLeftIdx = rootIdx - inStartIdx;
        root.left = buildTree(preorder, preStartIdx + 1, preStartIdx + nodesToTheLeftIdx, inStartIdx, rootIdx - 1, inorderNodes);
        root.right = buildTree(preorder, preStartIdx + nodesToTheLeftIdx + 1, preEndIdx, rootIdx + 1, inEndIdx, inorderNodes);
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

    /*
    Another approach:
     */
    public Node build1(int[] preorder, int[] inorder) {
        Stack<Node> st = new Stack<>();
        Set<Node> set = new HashSet<>();
        for (int pre = 0, in = 0; pre < preorder.length; pre++) {
            Node root = null;
            Node node;
            do {

                node = new Node(preorder[pre]);
                if (root == null) {
                    root = node;
                }
                if (!st.isEmpty()) {
                    if (set.contains(node)) {
                        set.remove(st.peek());
                        st.pop().right = node;
                    } else {
                        st.peek().left = node;
                    }
                }
                st.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);
//            while(in<inorder.length && preorder[pre]==inorder[in])
        }
    }

    public static void main(String[] args) {
        BinaryTreeFromPreorderAndInorder treeFromPreorderAndInorder = new BinaryTreeFromPreorderAndInorder();

        Node root = treeFromPreorderAndInorder.build(new int[]{1, 3, 7, 11, 3, 17, 18}, new int[]{7, 3, 11, 1, 17, 3, 18});
        treeFromPreorderAndInorder.preOrder(root);
    }
}
