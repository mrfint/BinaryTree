
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
