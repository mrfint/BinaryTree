
package binarytreeLink;

import java.util.Iterator;

public class Node<T> implements Cloneable, Iterable{
    private T val;
    public Link<T> left = new Link<T>();
    public Link<T> right = new Link<T>();

    public Node() {
    }

    
    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
    
    public boolean equals(Object obj){
        
        if(obj == this){
            return true;
        }
        Node<T> o = (Node<T>)obj;
        return ( (this.val==o.val)&& 
                 (left.equals(o.left))&&
                 (right.equals(o.right))
                );
    }
    
    public Node clone(){
        Node<T> res = new Node<T>();
        res.setVal(val);
        if(left.x!=null){
            res.left.x = left.x.clone();
        }
        if(right.x!=null){
            res.right.x = right.x.clone();
        }
      
        return res;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator<T>(this);
    }

    

}
