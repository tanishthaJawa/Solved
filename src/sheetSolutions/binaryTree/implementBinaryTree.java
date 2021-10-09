package sheetSolutions.binaryTree;

public class implementBinaryTree {
    Node root;
    implementBinaryTree(int key){
        root= new Node(key);
    }
   implementBinaryTree(){
        root=null;
   }

    public static void main(String[] args) {
        implementBinaryTree tree= new implementBinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);

    }
}
