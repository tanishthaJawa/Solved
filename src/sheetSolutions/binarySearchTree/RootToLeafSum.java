package sheetSolutions.binarySearchTree;

public class RootToLeafSum {
    static boolean  hasPathSum(Node root, int S) {
        // Your code here
        if(root==null){
            return false;
        }
        int subSum= S-root.data;

        if( subSum ==0 && root.left==null && root.right==null){
            return true;
        }

        return hasPathSum(root.left,subSum) || hasPathSum(root.right,subSum);
    }

    public static void main(String[] args) {

    }
}
