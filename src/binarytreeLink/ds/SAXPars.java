
package binarytreeLink.ds;

import binarytreeLink.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXPars<T> extends DefaultHandler{
    Tree tree = new Tree();
    String thisElement ;
    
    public Tree getResult(){
        return tree;
    }
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int lenght) throws SAXException
    {   
        if(thisElement.equals("val")){
            tree.addNode(Integer.parseInt(new String(ch, start, lenght)));          
        }
    }    
}
