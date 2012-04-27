
package binarytreeLink;

public class Link implements Cloneable{
    Node x = null;

    public Node getX() {
        return x;
    }

    public void setX(Node x) {
        this.x = x;
    }
    public boolean equals(Object obj){       

        if(x==((Link)obj).x ){
            return true;
        }
        else{
            return x.equals(((Link)obj).x);
        }    
        
    }
    
    public Link clone(){
        Link res = new Link();
        res.setX(this.x.clone());
        
        return res;
    }
    
    
}
