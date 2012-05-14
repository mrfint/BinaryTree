
package binarytreeLink;

public class Link<T> implements Cloneable{
    Node<T> x = null;

    public Node<T> getX() {
        return x;
    }

    public void setX(Node<T> x) {
        this.x = x;
    }
    public boolean equals(Object obj){       

        if(x==((Link<T>)obj).x ){
            return true;
        }
        else{
            return x.equals(((Link<T>)obj).x);
        }    
        
    }
    
    public Link<T> clone(){
        Link<T> res = new Link<T>();
        res.setX(this.x.clone());
        
        return res;
    }
    
    
}
