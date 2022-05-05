/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectltc;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Nilofar Jafari 
 */
public class theGUI extends JFrame {
    
    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 700;
    
    public static void main(String args[]){
        theGUI theGUI = new theGUI();
    }
    
    public theGUI(){
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        SelectLTC panel = new SelectLTC() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        this.add(panel);
        
        this.setVisible(true);
    } 
    
}
