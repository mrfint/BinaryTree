
package binarytree;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class TreeTest {
    
   
    @Test
    public void testSomeMethod() {
        int[] a = new int[]{50,25,10,30,100,11,110,80,26,9,57,36};
        Tree tree = new Tree();
        tree.addNode(a);
        tree.inOrder();
        
        System.out.println("");
        tree.inWidth();
        System.out.println("count = "+tree.getCount());
        System.out.println("height = "+tree.getHeight());
        System.out.println("width = "+tree.getWidth());
    }
}
