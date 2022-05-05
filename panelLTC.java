/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectltc;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nilofar Jafari 
 */
public class panelLTC extends JPanel {
    
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
   
    
    private BufferedImage logo;
    private final JLabel logoLabel;
    
    private final String imagePath = "";
    
    public panelLTC(){
        super();
        this.setLayout(new BorderLayout());
        
        mainPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        
        try{
            logo = ImageIO.read(new File(imagePath + "logo.png"));
        }
        catch(IOException e){
            System.out.println("IMAGE HAS FAILED TO LOAD");
            throw new RuntimeException(e);
            
        }
        
        logoLabel = new JLabel(new ImageIcon(fitimage(logo, 100, 50)));
        logoLabel.setSize(100,100);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
                
        
    }
    
    private Image fitimage(Image img, int h, int w){
        BufferedImage resizedimage = new BufferedImage (h,w,BufferedImage.TYPE_INT_RGB);
        return resizedimage;
                
    } 
    
    public JPanel getMainPanel(){
        return mainPanel;
    }
    
    public JPanel getTopPanel(){
        return topPanel;
    }
    
    public JPanel getBottomPanel(){
        return bottomPanel;
    }
    
    public void getMainPanel(JPanel mainPanel){
        this.mainPanel = mainPanel;
    }
    
    public void getTopPanel(JPanel topPanel){
        this.topPanel = topPanel;
    }
    
    public void getBottomPanel(JPanel bottomPanel){
        this.bottomPanel = bottomPanel;
    }
    
}
