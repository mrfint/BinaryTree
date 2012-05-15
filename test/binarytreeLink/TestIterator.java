
package binarytreeLink;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class TestIterator {
    
     @Test
     public void testIterator(){
         Tree<Integer> tree = new Tree<Integer>();
         Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
            new Integer(11),new Integer(110),new Integer(80),
            new Integer(26),new Integer(9),new Integer(57),
            new Integer(36)
        };
        tree.addNode(a);
        
        Iterator it = tree.iterator();
         while (it.hasNext()) {
             System.out.print(" "+it.next());
             
         }
     }
}
