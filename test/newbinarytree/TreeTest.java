/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newbinarytree;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nick
 */
public class TreeTest {
    
    @Test
    public void testSomeMethod() {
        int[] a = new int[]{50,25,10,30,100,11,110,80,26,9,57,36};
        Tree tree = new Tree();
        tree.addNode(a);
        tree.print();
        System.out.println("");
        tree.printLikeTree();
        System.out.println("");
        tree.delNode(80);
        System.out.println("\nheight = "+tree.getHeight());
        System.out.println("");
        tree.printLikeTree();
    }
}
