
package binarytree;


public class Tree {
    private Node rt = null;
    private int count = 0;

    public void addNode(int val){
        count++;
        rt = stree(rt, rt, val);
    }
    public void addNode(int[] a){
        for(int val: a ){
            addNode(val);
        }
    }
    
    public void inOrder(){
 //       funInOrder(rt);
 //       preorder(rt);
        print_tree(rt, 0);
    }
    
    public void inWidth(){
 //       funInOrder(rt);
        System.out.println("");
        preorder(rt);

    }
    public int getHeight(){
        return height(rt);   
    }
    public int getWidth(){
        return width(rt);   
    }
    
    private int height(Node node){
        if (node == null) {      return 0;                            }
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
    
    private int width(Node node){
        if (node == null) {      return 0;                            }
        else {
            return (int) Math.pow(2, Math.min(width(node.left), width(node.right)));
        }
    }

    public int getCount() {
        return count;
    }
    
    
    private Node stree( Node root, Node r, int val)
    {   
        if(r==null) 
        {   
            r = new Node(val);

            if(root == null) return r;
            if(val < root.val) root.left = r;
            else root.right = r;
            return r;
        }
        if( val < r.val ) stree(r, r.left, val);
        else stree(r, r.right, val);
        return root;
    }
     
    private void funInOrder( Node root){
        if( root == null ) return;
        
        funInOrder(root.left);
        System.out.print(" " + root.val);
        funInOrder(root.right);
    }
    private void print_tree( Node root, int l){       
        if( root == null ) return;
        
        print_tree(root.right, l+1);
        for (int i = 0; i < l; i++) {
            System.out.print("\t");
        }
        System.out.print(" " + root.val+"\n");
        print_tree(root.left, l+1);
    }
    
    
    private void preorder(Node root){
        
        if( root == null ) return;
        
        preorder(root.left);
        preorder(root.right);
        System.out.print(" " + root.val);
    }
}
class Node{
        int val;
        Node left;
        Node right;

    public Node() {
    }
        
    public Node(int val) {
        this.val = val;
    }
        
    }