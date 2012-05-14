
package binarytreeLink;

import binarytreeLink.Tree;
import org.junit.*;
import static org.junit.Assert.*;


public class TreeTest {
    Tree<Integer> tree = null;
    @Before
    public void setUp(){
        
        tree = new Tree<Integer>();
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
      Integer[] a  = tree.toArray();
      assertEquals(0, a.length);
    }
    //************************************************ One element
    @Test
    public void testOneSize(){
        tree.addNode(new Integer(50));
        assertEquals(1, tree.getCount());
    }
    @Test
    public void testOneHight(){
        tree.addNode(new Integer(50));
        assertEquals(1, tree.getHeight());
    }
    @Test
    public void testOneDelNodeByKey(){
        tree.addNode(new Integer(50));
        tree.delNode(new Integer(50));
        assertEquals(0, tree.getCount());
    }
    @Test
    public void tesOneToArray(){
      tree.addNode(new Integer(50));
      assertArrayEquals(new Integer[]{50}, tree.toArray());
    }
    
   //********************************************** Test Many 
    @Test
    public void testManySize(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
            new Integer(11),new Integer(110),new Integer(80),
            new Integer(26),new Integer(9),new Integer(57),
            new Integer(36)
        };
        tree.addNode(a);
        assertEquals(12, tree.getCount());
    }
    @Test
    public void testManyHight(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
            new Integer(11),new Integer(110),new Integer(80),
            new Integer(26),new Integer(9),new Integer(57),
            new Integer(36)
        };
        tree.addNode(a);
        assertEquals(4, tree.getHeight());
    }  
    @Test
    public void tesManyToArray(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
        };
        tree.addNode(a);
        Integer[] b = new Integer[]{new Integer(10),new Integer(25),
            new Integer(30),new Integer(50),new Integer(100),
        };

        assertArrayEquals(b, tree.toArray());
    }
//    
//    @Test
//    public void testManyDelLeafNodeByKey(){
//        int[] a = new int[]{50,25,10,30,100,11};
//        tree.addNode(a);
//        tree.delNode(11);
//        assertArrayEquals(new int[]{10, 25, 30, 50, 100}, tree.toArray());
//    }
//    
//    @Test
//    public void testManyDelRootNodeByKey(){
//        int[] a = new int[]{50,25,10,30,100,11};
//        tree.addNode(a);
//        tree.delNode(50);
//        assertArrayEquals(new int[]{10, 11, 25, 30, 100}, tree.toArray());
//    }
//    
    @Test
    public void testManyEqualsNode(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
        };
        Tree<Integer> tree2 = new Tree<Integer>();
        tree.addNode(a);
        tree2.addNode(a);
        assertEquals(tree, tree2);
    }
    
    @Test
    public void testManyFalseEqualsTree(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
        };
        tree.addNode(a);
        Tree tree2 = new Tree();
        Integer[] a2 = new Integer[]{new Integer(50),new Integer(26),
            new Integer(10),new Integer(30),new Integer(100),
        };
        tree2.addNode(a2);
        assertFalse(tree.equals(tree2));
    }
    @Test
    public void testManyCloneTree(){
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
        };
        tree.addNode(a);

        Tree tree2 = tree.clone();
        assertEquals(tree, tree2);
    }
    
   
}
