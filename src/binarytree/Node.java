
package binarytree;

public class Node{
    private int val;
    public Node left;
    public Node right;

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
    
}