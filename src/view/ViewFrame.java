
package view;

import binarytreeLink.Tree;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewFrame extends JFrame{
    public static final int DEFAULT_WIDTH=1000;
    public static final int DEFAULT_HEIGHT=600;
    private JButton btInit, btStart;
    Tree tree = null;
    
    public ViewFrame(Tree tree){
        //Create and set up the window.
        super("VisualTree");
        //Register model
        this.tree = tree;
        //setLocationRelativeTo(this);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Create and set up the content pane.
        addContentPane(getContentPane());
        
    }

    
    private void addContentPane(Container contentPane) {      
      
        final JPanel jpFace = new JPanel();
        
        // Init buttons
        JButton btn = new JButton("Random");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tree.random();
                tree.showTree(jpFace);               
            }
        });
        JButton clr = new JButton("Clear");
        clr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();              
            }
        });
        JPanel buttons = new JPanel();
        buttons.add(clr);
        buttons.add(btn);
        
        contentPane.add(jpFace, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.SOUTH);
    }

}
