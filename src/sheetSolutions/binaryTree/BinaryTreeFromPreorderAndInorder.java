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
        return buildTree(preorder, 0, preorder.length , 0, inorder.length , inorderNodes);
    }

    private Node buildTree(int[] preorder, int preStartIdx, int preEndIdx, int inStartIdx, int inEndIdx, Map<Integer, Integer> inorderNodes) {
        if (preStartIdx >= preEndIdx || inStartIdx >= inEndIdx) {
            return null;
        }
        Node root = new Node(preorder[preStartIdx]);
        int rootIdx = inorderNodes.get(root.data);
        int nodesToTheLeftIdx = rootIdx - inStartIdx;
        root.left = buildTree(preorder, preStartIdx+1 , preStartIdx + nodesToTheLeftIdx, inStartIdx, rootIdx - 1, inorderNodes);
        root.right = buildTree(preorder, preStartIdx + nodesToTheLeftIdx +1, preEndIdx, rootIdx + 1, inEndIdx, inorderNodes);
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

    Here's how this implementation works:
1. We start by initializing the root of the binary tree to null, and creating a set and a stack to keep track of the nodes in the binary tree.
2. We loop over the elements of the preorder traversal, and for each element, we create a new node with that value, and add it to the stack.
3. If the stack is not empty, we check if the top element of the stack has been processed (i.e., its right subtree has been constructed).
 If it has been processed, we remove it from the set and the stack, and set its right child to be the current node.
  If it hasn't been processed, we set its left child to be the current node.
4. We continue this process until we encounter an element in the preorder traversal that matches the current element in the inorder traversal.
5. Once we find a match, we start popping elements from the stack and the inorder traversal, until we find the node whose value matches the
 current element in the inorder traversal. We then set that node as the current node, and add it back to the stack.
6. We repeat this process until we have processed all the elements in both the preorder and inorder traversals.
7.Finally, we return the root of the binary tree.

     */
    public Node build1(int[] preorder, int[] inorder) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        Set<Node> set = new HashSet<>();

        for (int pre = 0, in = 0; pre < preorder.length; ) {
            Node node;
            do {
                node = new Node(preorder[pre]);
                if (root == null) {
                    root = node;
                }
                if (!st.isEmpty()) {
                    if (set.contains(st.peek())) {
                        set.remove(st.peek());
                        st.pop().right = node;
                    } else {
                        st.peek().left = node;
                    }
                }
                st.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while (!st.isEmpty() && in < inorder.length && st.peek().data == inorder[in]  ) {
                node = st.pop();
                in++;
            }

            if(node!=null){
                set.add(node);
                st.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromPreorderAndInorder treeFromPreorderAndInorder = new BinaryTreeFromPreorderAndInorder();

        Node root = treeFromPreorderAndInorder.build(new int[]{1, 3, 7, 11, 3, 17, 18}, new int[]{7, 3, 11, 1, 17, 3, 18});
        treeFromPreorderAndInorder.preOrder(root);
        System.out.println();
        Node root1 = treeFromPreorderAndInorder.build1(new int[]{1, 3, 7, 11, 3, 17, 18}, new int[]{7, 3, 11, 1, 17, 3, 18});
        treeFromPreorderAndInorder.preOrder(root1);
    }
}
