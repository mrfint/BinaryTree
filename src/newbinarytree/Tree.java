
package newbinarytree;

public class Tree {
    Link root = new Link();
    
    public void addNode(int val){
        insNode(root, new Node(val));
    }
    
    public void addNode(int[] a){
        for(int val: a ){
            insNode(root, new Node(val));
        }
    }
    
    public void delNode(int val){
        Link curr = findPrevNode(root, val);
        if(curr!=null)
        {
            if(curr.x.right.x==curr.x.left.x)
            {
                curr.x = null;
            }
            else
            {
                if(curr.x.right.x == null)
                {
                    curr.x.setVal(curr.x.left.x.getVal());
                    curr.x.left  = curr.x.left.x.left;
                }
                else
                {
                    Link dnLeft = searchDnLeft(curr.x.right);
                    dnLeft.x.left = curr.x.left;
                    
                    curr.x.setVal(curr.x.right.x.getVal());
                    curr.x.left  = curr.x.right.x.left;
                    curr.x.right = curr.x.right.x.right;
                }
            }
        }
    }
    
    public void print(){
        nPrint(root);
    }
    public void printLikeTree(){
        print_tree(root,0);
    }
    public int getCount(){
        return nCount(root);
    }
    
    public int getHeight(){
        return height(root);
    }
    private void insNode(Link r, Node p) {
        if( r.x == null )
        {
            r.x = p;
        }
        else
            if( p.getVal() < r.x.getVal())
            {
                insNode(r.x.left, p);
            }
            else
            {
                insNode(r.x.right, p);
            }
                
    }

    private int nCount(Link r) {
        int res = 0;
        if ( r.x != null ) 
        {
            res = 1 + nCount(r.x.left) + nCount(r.x.right);
        }
        return res;
    }

    private void nPrint(Link r) {
        if( r.x != null )
        {
            nPrint(r.x.left);
            System.out.print(" "+r.x.getVal());
            nPrint(r.x.right);
        }
    }

    private Link findPrevNode(Link r, int key) {
        if (r.x == null) 
        {
            return r;
        }

        while (r.x.getVal()!= key) 
        {   
            if (key < r.x.getVal())
            {
                r = r.x.left;
            }
            else
            {
                r = r.x.right;
            }
            if(r.x == null) break;
        }
        return r;
    }

    private void print_tree(Link root, int l) {
        if( root.x == null ) return;
        
        print_tree(root.x.right, l+1);
        for (int i = 0; i < l; i++) {
            System.out.print("\t");
        }
        System.out.print(" " + root.x.getVal()+"\n");
        print_tree(root.x.left, l+1);
    }

    private Link searchDnLeft(Link r) {
        while (r.x.left.x != null) 
        {
            r = r.x.left;
            
        }
        return r;
    }
    
     private int height(Link r){
        if (r.x == null) {      return 0;                            }
        else {
            return 1 + Math.max(height(r.x.left), height(r.x.right));
        }
    }
}
