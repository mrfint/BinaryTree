
package view;

import binarytreeLink.Tree;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) {
       Tree tree = new Tree();
       ViewFrame mf = new ViewFrame(tree);

       mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       mf.setVisible(true);
    }
}
