
package binarytreeLink.controller;


import binarytreeLink.Link;
import binarytreeLink.Tree;
import binarytreeLink.ds.DS_XML;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import binarytreeLink.view.ViewFrame;


public class Controller {
    
    private ViewFrame mf;
    private Tree tree = null;

    public Controller(ViewFrame mf) {
        this.mf = mf;
        tree = new Tree();
        mf.addBtnsListeners(initButtonsListeners());
    }
    
    private ActionListener[] initButtonsListeners() {
        
        ActionListener btnClear = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                mf.getJpFace().repaint();              
            }
        };
        ActionListener btnRand = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRandomTree();
                tree.showTree(mf.getJpFace());               
            }
        };
        ActionListener btnSave = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)  {
                try {
                    DS_XML.save(tree);
                } catch (IOException ex) {
                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ActionListener btnLoad = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                try {
                    tree = DS_XML.load();
                } catch (Exception ex) {
                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                tree.showTree(mf.getJpFace());             
            }
        };
        
        return new ActionListener[]{btnClear,btnRand,btnSave,btnLoad}; 
    }
    
    private void setRandomTree() {
        int n = 150;
        tree = new Tree();
        tree.addNode(n/2);
        for (int i = 0; i < 20; i++) {
             tree.addNode((int)(n-Math.random()*n));
        }
    }
}
