
package binarytreeLink.ds;

import binarytreeLink.Tree;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DS_XML {
    public static void save(Tree tree) throws IOException{
        Converter converter = new Converter();
        FileWriter out = new FileWriter("D:\\111.xml");
        out.write("<document>\r\n");
            out.write(converter.toXML(tree));
        out.write("</document>");
        out.close();
    }
    
    public static Tree load() throws IOException, ParserConfigurationException, SAXException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXPars saxp = new SAXPars();
        parser.parse(new File("D:\\111.xml"), saxp);
        return saxp.getResult();
    }
}
