
package binarytreeLink.bin;

import binarytreeLink.Tree;
import binarytreeLink.controller.Controller;
import binarytreeLink.view.ViewFrame;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) {

       ViewFrame mf = new ViewFrame();
       Controller controller = new Controller(mf);
       mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       mf.setVisible(true);
    }
}
