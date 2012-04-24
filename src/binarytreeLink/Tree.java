
package binarytreeLink;

import java.awt.Graphics;
import javax.swing.JPanel;

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

    public void random() {
        int n = 100;
        root = new Link();
        addNode(n/2);
        for (int i = 0; i < 20; i++) {
             addNode((int)(n-Math.random()*100));
        }
//        int[] a = new int[]{50,25,10,30,100,11,120,130,115,125};
//        addNode(a);
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
}
