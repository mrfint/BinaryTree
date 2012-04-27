
package binarytreeLink.ds;

import binarytreeLink.Link;
import binarytreeLink.Tree;

public class Converter{
    
    private StringBuilder sb = null;
    
    public String toXML(Tree tree){
        sb = new StringBuilder("");
        if(tree.getRoot()!=null) nPrintXML(tree.getRoot());
        return sb.toString();
    }
    
    private void nPrintXML(Link r) {
        if( r.getX() != null )
        {   sb.append("<Node>");
                sb.append("<val>").append(""+r.getX().getVal()).append("</val>");       
            nPrintXML(r.getX().left);
            nPrintXML(r.getX().right);           
            sb.append("</Node>");
        }
    }
}
