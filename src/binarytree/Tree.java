
package binarytree;

public class Tree {
    private Node root = null;
    private int count = 0;

    public void addNode(int val){
        count++;
        if(root==null)
        {
            root = new Node(val);
        }
        else
        {
            insNode(root, new Node(val));
        }
    }
    
    private void insNode( Node r, Node p )
    {   
        if(p.getVal() < r.getVal() ) 
        {   
            if(r.left == null){
                r.left = p ;
            }
            else insNode(r.left, p);
        }
        else
        {
            if(r.right == null){
                r.right = p ;
            }
            else insNode(r.right, p);
        }
    }
    
    public void addNode(int[] a){
        for(int val: a ){
            addNode(val);
        }
    }
 
    public int getCount() {
        return count;
    }
   public void delNode(int key){
        Node prev = findPrevNode(root, key);
        if( count==1 && root.getVal() == key) {     // find root, count = 1
            root = null;
            count--;
        }
        if( prev == null) return;                  // find nothing
        //******************************************// find something
        Node curr = null;
        if( prev.left!=null && prev.left.getVal()==key ){
            curr = prev.left;
        }
        else{
            curr = prev.right;
        }

        if(curr!=null)
        {
            if(curr.right==curr.left)
            {
                if(prev.left!=null && prev.left.getVal()==key){
                    prev.left = null;
                }
                else {
                    prev.right = null;
                }
            }
            else
            {
                if(curr.right == null)
                {
                    if(prev.left!=null && prev.left.getVal()==key){
                        prev.left = curr.left.left;
                    }
                    else {
                        prev.right = curr.left.left;
                    }
                }
                else
                {
                    Node dnLeft = searchDnLeft(curr.right);
                    dnLeft.left = curr.left;
                    curr.setVal(curr.right.getVal());
                    curr.left  = curr.right.left;
                    curr.right = curr.right.right;
                }
            }
        }
        count--;
    }
    
    public void print(){
        nPrint(root);
    }
    ;
    public int[] toArray(){
        countArr = 0;
        int[] a = new int[getCount()];
        
        nArray(root, a);
        return a;
    }
    private int countArr;
    private void nArray(Node r, int[] a) {
        if( r != null )
        {
            nArray(r.left, a);
            a[countArr++] = r.getVal();
            nArray(r.right, a);
        }
    }
    
    public void printLikeTree(){
        print_tree(root,0);
    }
    private void print_tree(Node root, int l) {
        if( root == null ) return;
        
        print_tree(root.right, l+1);
        for (int i = 0; i < l; i++) {
            System.out.print("\t");
        }
        System.out.print(" " + root.getVal()+"\n");
        print_tree(root.left, l+1);
    }
    
    public int getHeight(){
        return height(root);
    }

    private void nPrint(Node r) {
        if( r != null )
        {
            nPrint(r.left);
            System.out.print(" "+r.getVal());
            nPrint(r.right);
        }
    }

    private Node findPrevNode(Node r, int key) {
        if (r == null) 
        {
            return r;
        }

        while (true) 
        {   
            if (key < r.getVal())
            {
                if( (r.left!=null) && (r.left.getVal() == key) ){
                    return r;
                }
                r = r.left;
            }
            else
            {
                if( (r.right!=null) && (r.right.getVal() == key) ){
                    return r;
                }
                r = r.right;
            }
            if(r == null) break;
        }
        return r;
    }

    

    private Node searchDnLeft(Node r) {
        while (r.left != null) 
        {
            r = r.left;
        }
        return r;
    }
    
     private int height(Node r){
        if (r == null) {      return 0;                            }
        else {
            return 1 + Math.max(height(r.left), height(r.right));
        }
    }
}
