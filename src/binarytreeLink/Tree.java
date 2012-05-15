package binarytreeLink;

import java.awt.Graphics;
import java.util.Iterator;
import javax.swing.JPanel;

public class Tree<T extends Comparable> implements Cloneable, Iterable{
    Link<T> root = new Link<T>();
    
    public void addNode(T val){
        insNode(root, new Node<T>(val));
    }
    
    public void addNode(T[] a){
        for(T val: a ){
            insNode(root, new Node<T>(val));
        }
    }
    
    private void insNode(Link<T> r, Node<T> p) {
        if( r.x == null ){
            r.x = p;
        }
        else
            if( ((T)p.getVal()).compareTo((T)r.x.getVal()) == -1){
                insNode(r.x.left, p);
            }
            else
            {
                insNode(r.x.right, p);
            }
    }
    
    public void delNode(T val){
        Link<T> curr = findPrevNode(root, val);
        if(curr.x!=null)
        {
            if(curr.x.right.x==curr.x.left.x){
                curr.x = null;
            }
            else
            {
                if(curr.x.right.x == null){
                    curr.x.setVal(curr.x.left.x.getVal());
                    curr.x.left  = curr.x.left.x.left;
                }
                else
                {
                    Link<T> dnLeft = searchDnLeft(curr.x.right);
                    dnLeft.x.left = curr.x.left;
                    
                    curr.x.setVal(curr.x.right.x.getVal());
                    curr.x.left  = curr.x.right.x.left;
                    curr.x.right = curr.x.right.x.right;
                }
            }
        }
    }  
    
    private Link<T> findPrevNode(Link<T> r, T key) {
        if (r.x == null){
            return r;
        }
        while (!r.x.getVal().equals(key)){   
            if (key.compareTo((T)r.x.getVal())==-1){
                r = r.x.left;
            }
            else{
                r = r.x.right;
            }
            if(r.x == null) break;
        }
        return r;
    }
    
    private int countArr;
    public T[] toArray(){
        countArr = 0;
        int g = getCount();
        T[] a =(T[]) new Comparable[getCount()];          
        if (root.x != null){
          nArray(root, a);
        }
        return a;
    }
    private void nArray(Link<T> r, T[] a) {
        if( r.x != null )
        {
            nArray(r.x.left, a);
            a[countArr++] = (T)r.x.getVal();
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
    
    private int nCount(Link<T> r) {
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
   
    

   private Link<T> searchDnLeft(Link<T> r) {
        while (r.x.left.x != null) {
            r = r.x.left;
        }
        return r;
    }
    
    public void showTree(JPanel p) {     
        stree(p.getGraphics(), 0 , p.getWidth(), DY, root, 0);
    }
    
    private final int DY = 50;
    private final int R = 40;
    private void stree(Graphics g, int x1, int x2, int y, Link r, int d) {
       if(r.x!=null)
        {
            int x = (x1+x2)/2;

            g.drawLine((d==0)? x: (d == -1)? x2 : x1 , (d==0)? y-10: y-(DY-R), x, y);
            g.drawOval(x-R/2, y, R, R);
            g.drawString(""+r.x.getVal(), x-R/4, y+R/2+5);
            stree( g, x1, x, y+DY, r.x.left, -1);            
            stree( g, x, x2, y+DY, r.x.right, 1);
        }
    }
  
    public boolean equals(Object obj)
    {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        
        if(!(getClass() == obj.getClass())){
            return false;
        }
        else{
            return root.equals(((Tree)obj).root);
        }
    }
    
    public Tree clone(){
        Tree nTree = new Tree();
        nTree.setRoot(root.clone());

        return nTree;
    }

    public Link getRoot() {
        return root;
    }

    public void setRoot(Link<T> root) {
        this.root = root;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator<T>(root.x);
    }

    
}
