
package binarytreeLink;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Tree implements Cloneable{
    Link root = new Link();
    
    public void addNode(int val){
        insNode(root, new Node(val));
    }
    
    public void addNode(int[] a){
        for(int val: a ){
            insNode(root, new Node(val));
        }
    }
    
    private void insNode(Link r, Node p) {
        if( r.x == null ){
            r.x = p;
        }
        else
            if( p.getVal() < r.x.getVal()){
                insNode(r.x.left, p);
            }
            else
            {
                insNode(r.x.right, p);
            }
    }
    
    public void delNode(int val){
        Link curr = findPrevNode(root, val);
        if(curr.x!=null)
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
    
    public void printToSOUT(){
        nPrint(root);
    }; 
    private void nPrint(Link r) {
        if( r.x != null )
        {
            nPrint(r.x.left);
            System.out.print(" "+r.x.getVal());
            nPrint(r.x.right);
        }
    }
    
    public int[] toArray(){
        countArr = 0;
        int[] a = new int[getCount()];
        
        nArray(root, a);
        return a;
    }
    private int countArr;
    private void nArray(Link r, int[] a) {
        if( r.x != null )
        {
            nArray(r.x.left, a);
            a[countArr++] = r.x.getVal();
            nArray(r.x.right, a);
        }
    }
    
    public void printLikeTree(){
        print_tree(root,0);
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
    
    public int getCount(){
        return nCount(root);
    }
    
    private int nCount(Link r) {
        int res = 0;
        if ( r.x != null ){
            res = 1 + nCount(r.x.left) + nCount(r.x.right);
        }
        return res;
    }
    
    public int getHeight(){
        return height(root);
    }
    private int height(Link r){
        if (r.x == null) {      return 0;                            }
        else {
            return 1 + Math.max(height(r.x.left), height(r.x.right));
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

   private Link searchDnLeft(Link r) {
        while (r.x.left.x != null) {
            r = r.x.left;
        }
        return r;
    }
      
    public boolean equals(Object obj)
    {
        if(obj == this){
            return true;
        }

        /* obj ссылается на null */

        if(obj == null){
            return false;
        }

        /* Удостоверимся, что ссылки имеют тот же самый тип */

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Tree tmp = (Tree)obj;
            if(compare(this.root, tmp.root))
                return true;
            else
                return false;
        }
    }
    
    public Tree clone(){
        Tree nTree = new Tree();
        if (root != null){
            nTree.setRoot(root.clone());
	}

        return nTree;
    }
    
    private void nClone(Link r, Tree nTree) {
        if( r.x != null )
        {
            nTree.addNode(r.x.getVal());
            nClone(r.x.right, nTree);
            nClone(r.x.left , nTree);
            
        }
    }

    public void random() {
        int n = 150;
        root = new Link();
        addNode(n/2);
        for (int i = 0; i < 20; i++) {
             addNode((int)(n-Math.random()*n));
        }
    }
    
    public void showTree(JPanel p) {
        stree(p.getGraphics(), 0 , p.getWidth(), DY, root, 0);

    }
    final int DY = 50;
    private void stree(Graphics g, int x1, int x2, int y, Link r, int direction) {
        final int R = 40;
        
        if(r.x!=null)
        {
            int x = (x1+x2)/2;
            if(direction == 0){
                g.drawLine(x, y-10, x, y);
            }
            if(direction == -1){
                g.drawLine(x2, y-(DY-R), x, y);
            }
            if(direction == 1){
                g.drawLine(x1, y-(DY-R), x, y);
            }
            g.drawOval(x-R/2, y, R, R);
            g.drawString(""+r.x.getVal(), x-R/4, y+R/2+5);
            stree( g, x1, x, y+DY, r.x.left, -1);
            
            stree( g, x, x2, y+DY, r.x.right, 1);
        }
    }
    private boolean res = true;
    private boolean compare(Link r1, Link r2) {
        if(!res) return false;
        if(r1.x == r2.x){
            return true;
        }
        if(r1.x.getVal()!=r2.x.getVal())    res = false;
        res = compare(r1.x.left, r2.x.left);
        res = compare(r1.x.right, r2.x.right);
        return res;
    }

    public Link getRoot() {
        return root;
    }

    public void setRoot(Link root) {
        this.root = root;
    }
    
   
}
