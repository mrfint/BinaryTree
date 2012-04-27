
package view;

import binarytreeLink.Tree;
import binarytreeLink.ds.DS_XML;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ViewFrame extends JFrame{
    public static final int DEFAULT_WIDTH=1000;
    public static final int DEFAULT_HEIGHT=600;
    private JPanel jpFace = null;
    private JPanel buttons = null;
    private String[] captionBut = new String[]{"Clear", "Random","Save","Load"};
    
    
    public ViewFrame(){
        //Create and set up the window.
        super("VisualTree");

        //setLocationRelativeTo(this);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Create and set up the content pane.
        addContentPane(getContentPane());
        
    }

    
    private void addContentPane(Container contentPane) {       
        jpFace = new JPanel();
        // Init buttons
        buttons = new JPanel();
        for (int i = 0; i < captionBut.length; i++) {
            JButton b = new JButton(captionBut[i]);
            buttons.add(b);
        }
       
        contentPane.add(jpFace, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.SOUTH);
    }

    public void addBtnsListeners(ActionListener[] inButLs) {
        for (int i = 0; i < buttons.getComponentCount(); i++) {
            ((JButton)buttons.getComponent(i)).addActionListener(inButLs[i]);
        }
    }

    public JPanel getJpFace() {
        return jpFace;
    }
    

}
