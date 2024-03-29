
package binarytree;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import org.junit.*;
import static org.junit.Assert.*;


public class TreeTest {
    private Tree tree = null;
    @Before
    public void setUp() throws InstantiationException, IllegalAccessException{
        
        tree = new Tree();
    }
    @After
    public void tearDown(){
        tree = null;
    }
    
    //******************************************** Test zero
    @Test
    public void testZeroCount(){
        assertEquals(0, tree.getCount());
    }
    @Test
    public void testZeroHight(){
        assertEquals(0, tree.getHeight());
    }
    @Test
    public void testZeroDelNodeByKey(){
      tree.delNode(10);
    }
    @Test
    public void testZeroToArray(){
      int[] a  = tree.toArray();
      assertEquals(0, a.length);
    }
    //************************************************ One element
    @Test
    public void testOneSize(){
        tree.addNode(50);
        assertEquals(1, tree.getCount());
    }
    @Test
    public void testOneHight(){
        tree.addNode(50);
        assertEquals(1, tree.getHeight());
    }
    @Test
    public void testOneDelNodeByKey(){
        tree.addNode(50);
        tree.delNode(50);
        assertEquals(0, tree.getCount());
    }
    @Test
    public void tesOneToArray(){
      tree.addNode(50);
      assertArrayEquals(new int[]{50}, tree.toArray());
    }
    
   //********************************************** Test Many 
    @Test
    public void testManySize(){
        int[] a = new int[]{50,25,10,30,100,11,110,80,26,9,57,36};
        tree.addNode(a);
        assertEquals(12, tree.getCount());
    }
    @Test
    public void testManyHight(){
        int[] a = new int[]{50,25,10,30,100,11,110,80,26,9,57,36};
        tree.addNode(a);
        assertEquals(4, tree.getHeight());
    }  
    @Test
    public void tesManyToArray(){
        int[] a = new int[]{50, 25, 10, 30, 100, 11, 110};
        tree.addNode(a);
        int[] b = tree.toArray();

        assertArrayEquals(new int[]{10, 11, 25, 30, 50, 100, 110}, tree.toArray());
    }
    
    @Test
    public void testManyDelLeafNodeByKey(){
        int[] a = new int[]{50,25,10,30,100,11};
        tree.addNode(a);
        tree.delNode(11);
        assertArrayEquals(new int[]{10, 25, 30, 50, 100}, tree.toArray());
    }
    @Test
    public void testManyDelNodeByKey(){
        int[] a = new int[]{50,25,10,30,100,11};
        tree.addNode(a);
        tree.printLikeTree();

        tree.delNode(25);

        assertArrayEquals(new int[]{10, 11, 30, 50, 100}, tree.toArray());
    }
    
    @Test
    public void testManyDelRootNodeByKey(){
        int[] a = new int[]{50,25,10,30,100,11};
        tree.addNode(a);
        tree.printLikeTree();

        tree.delNode(50);
        System.out.println("!!");
        tree.printLikeTree();
        assertArrayEquals(new int[]{10, 11, 25, 30, 100}, tree.toArray());
    }
   
}
