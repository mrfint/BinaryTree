/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeLink;

import binarytreeLink.ds.DS_XML;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.xml.sax.SAXException;


public class DS_XMLTest {
    
    @Test
    public void testSaveMethod() throws IOException {
        Integer[] a = new Integer[]{new Integer(50),new Integer(25),
            new Integer(10),new Integer(30),new Integer(100),
            new Integer(11),new Integer(110),new Integer(80),
            new Integer(26),new Integer(9),new Integer(57),
            new Integer(36)
        };
        Tree<Integer> tree = new Tree();
        tree.addNode(a);
        DS_XML.save(tree);
    }
    
    @Test
    public void testLoadMethod() throws IOException, ParserConfigurationException, SAXException {
        Tree<Integer> tree = DS_XML.load();
        tree.printLikeTree();
    }
}
