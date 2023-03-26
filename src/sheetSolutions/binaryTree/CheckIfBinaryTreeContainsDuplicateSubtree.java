package sheetSolutions.binaryTree;

import java.util.HashSet;

/*
[ Method 1]
A simple solution is that, we pick every node of tree and try to find is any sub-tree of given tree is present in tree which is
identical with that sub-tree.

[Method 2 ]( Efficient solution )
An Efficient solution based on tree serialization and hashing. The idea is to serialize subtrees as strings and store the
strings in hash table. Once we find a serialized tree (which is not a leaf) already existing in hash-table, we return true.
 */
public class CheckIfBinaryTreeContainsDuplicateSubtree {
    public int dupSub(Node root) {
        HashSet<String> subtrees = new HashSet<>();

        if (dupSubUtil(root, subtrees).equals("")) {
            return 1;
        }
        return 0;
    }

    private String dupSubUtil(Node root, HashSet<String> subtrees) {
        String s = "";

        // If current node is NULL, return marker
        if (root == null)
            return s + '$';

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left, subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right, subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        // Append random char in between the value to differentiate from 11,1 and 1,11
        s = s + root.data + "%" + lStr + "%" + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 7 (3+4 accounting for special chars appended)
        // as it has two marker
        // nodes.
        if (s.length() > 7 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left = new Node('D');
        CheckIfBinaryTreeContainsDuplicateSubtree duplicateSubtree = new CheckIfBinaryTreeContainsDuplicateSubtree();
        System.out.println(duplicateSubtree.dupSub(root));
    }
}
