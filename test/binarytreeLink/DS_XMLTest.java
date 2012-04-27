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
import org.xml.sax.SAXException;


public class DS_XMLTest {
    
    @Test
    public void testSaveMethod() throws IOException {
        int[] a = new int[]{50,25,10,30,100,11,110,80,26,9,57,36};
        Tree tree = new Tree();
        tree.addNode(a);
        DS_XML.save(tree);
    }
    
    @Test
    public void testLoadMethod() throws IOException, ParserConfigurationException, SAXException {
        Tree tree = DS_XML.load();
        tree.printLikeTree();
    }
}
