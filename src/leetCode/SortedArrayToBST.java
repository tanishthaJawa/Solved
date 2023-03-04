package leetCode;

import sheetSolutions.binarySearchTree.Node;
/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a --height-balanced binary search tree.
 */
public class SortedArrayToBST {
    public Node sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private Node createBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        Node root = new Node(nums[mid]);
        root.left = createBST(nums, left, mid - 1);
        root.right = createBST(nums, mid + 1, right);
        return root;
    }
}
