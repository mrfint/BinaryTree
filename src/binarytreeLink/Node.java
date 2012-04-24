
package binarytreeLink;

public class Node {
    private int val;
    public Link left = new Link();
    public Link right = new Link();

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    
}
