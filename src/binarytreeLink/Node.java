
package binarytreeLink;

public class Node implements Cloneable{
    private int val;
    public Link left = new Link();
    public Link right = new Link();

    public Node() {
    }

    
    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    public boolean equals(Object obj){
        
        if(obj == this){
            return true;
        }
        Node o = (Node)obj;
        return ( (this.val==o.val)&& 
                 (left.equals(o.left))&&
                 (right.equals(o.right))
                );
    }
    
    public Node clone(){
        Node res = new Node();
        res.setVal(val);
        if(left.x!=null){
            res.left.x = left.x.clone();
        }
        if(right.x!=null){
            res.right.x = right.x.clone();
        }
      
        return res;
    }
}
