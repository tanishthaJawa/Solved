package GeeksForGeeks.LinkedList;
//Converting a b tree to circular doubly linked list
public class TreeToList {
    static class TreeNode{
       private TreeNode left, right;//left means prev, right means next
       private int element;
        TreeNode(int data){
            element=data;
            left=right=null;
        }
    }
 static TreeNode root;
    TreeToList(){
        root=null;
    }

    public TreeNode concatenate(TreeNode leftList,TreeNode rightList){
        if(leftList==null)
            return rightList;
        if(rightList==null)
            return leftList;
        TreeNode leftLast = leftList.left;
        TreeNode rightLast = rightList.left;
        /*Here leftList is head and left is prev. Previous of leftList will be last node
        of leftList in a circular doubly Linked List.
         */
        leftLast.right=rightList;// Connect the last nodes of lists with each other
        rightList.left=leftLast;
        rightLast.right=leftList;//Make lists circular
        leftList.left=rightLast;
        return leftList;
    }
    public TreeNode bTreeToCList(TreeNode root){
        if(root==null)
            return null;
        TreeNode left = bTreeToCList(root.left);//Find left and right
        TreeNode right = bTreeToCList(root.right);
        root.left=root.right=root;// make node point to itself
        return concatenate(concatenate(left,root),right);// Join the lists in inorder traversal
    }
    public void display(TreeNode head) {
        TreeNode curr = head;
        do {
            System.out.print(curr.element + " ");
            curr = curr.right;
        } while (curr != head);
        System.out.println();
    }
        public static void main(String[] args) {
            TreeToList bTree = new TreeToList();
            root=new TreeNode(10);
          root.left=new TreeNode(12);
            root.right=new TreeNode(15);
            root.left.left=new TreeNode(25);
           root.left.right=new TreeNode(30);
            root.right.left=new TreeNode(36);
            TreeNode ans = bTree.bTreeToCList(root);
            bTree.display(ans);
        }

}

