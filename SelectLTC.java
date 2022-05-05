/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectltc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nilofar Jafari 
 */
public abstract class SelectLTC extends panelLTC implements ActionListener {
    private final JLabel levelField;
    private final JLabel convoAndContextField;
    private final JButton a1Button ;
    private final JButton a2Button;
    private final JButton b1Button;
    private final JButton b2Button;
    private final JButton persAndUniBtn;
    private final JButton shoppingBtn;
    private final JButton medAndhealBtn;
    private final JButton basicsBtn;
    
    
    public SelectLTC(){
        super();
        levelField = new JLabel("Please select the level you want to try:", SwingConstants.CENTER);
        
        
        a1Button = new JButton("LEVEL A1");
        a1Button.addActionListener(this);
        a1Button.setOpaque(true);
        a1Button.setBorderPainted(true);
        a1Button.setBackground(Color.white);
        a1Button.setSize(10, 10);
        
    a1Button.addActionListener((ActionEvent e) -> {
        });
    
    a1Button.setVisible(true);
        
    
        a2Button = new JButton("LEVEL A2");
        a2Button.addActionListener(this);
        a2Button.setOpaque(true);
        a2Button.setBorderPainted(true);
        a2Button.setBackground(Color.white);
        a2Button.setSize(10, 10);
        
    a2Button.addActionListener((ActionEvent e) -> {
        });
    
    a2Button.setVisible(true);
        
    
        b1Button = new JButton("LEVEL B1");
        b1Button.addActionListener(this);
        b1Button.setOpaque(true);
        b1Button.setBorderPainted(true);
        b1Button.setBackground(Color.white);
        b1Button.setSize(10, 10);
        
    b1Button.addActionListener((ActionEvent e) -> {
        });
    
    b1Button.setVisible(true);
    
    
        b2Button = new JButton("LEVEL B2");
        b2Button.addActionListener(this);
        b2Button.setOpaque(true);
        b2Button.setBorderPainted(true);
        b2Button.setBackground(Color.white);
        b2Button.setSize(10, 10);
            
    b2Button.addActionListener((ActionEvent e) -> {
        });
    
    b2Button.setVisible(true);
    
        
        convoAndContextField = new JLabel("Please select the context of your conversation:");
        
        persAndUniBtn = new JButton("PERSONAL & UNI LIFE");
        persAndUniBtn.addActionListener(this);
        persAndUniBtn.setOpaque(true);
        persAndUniBtn.setBorderPainted(true);
        persAndUniBtn.setBackground(Color.white);
        persAndUniBtn.setSize(10, 10);
        
    persAndUniBtn.addActionListener((ActionEvent e) -> {
        });
    
    persAndUniBtn.setVisible(true);
        
    
        shoppingBtn = new JButton("SHOPPING");
        shoppingBtn.addActionListener(this);
        shoppingBtn.setOpaque(true);
        shoppingBtn.setBorderPainted(true);
        shoppingBtn.setBackground(Color.white);
        shoppingBtn.setSize(10, 10);
        
    shoppingBtn.addActionListener((ActionEvent e) -> {
        });
    
    shoppingBtn.setVisible(true);
        
    
        medAndhealBtn = new JButton("MEDICAL & HEALTH");
        medAndhealBtn.addActionListener(this);
        medAndhealBtn.setOpaque(true);
        medAndhealBtn.setBorderPainted(true);
        medAndhealBtn.setBackground(Color.white);
        medAndhealBtn.setSize(10, 10);
        
    medAndhealBtn.addActionListener((ActionEvent e) -> {
        });
    
    medAndhealBtn.setVisible(true);
    
    
        basicsBtn = new JButton("BASICS");
        basicsBtn.addActionListener(this);
        basicsBtn.setOpaque(true);
        basicsBtn.setBorderPainted(true);
        basicsBtn.setBackground(Color.white);
        basicsBtn.setSize(10, 10);
        
    basicsBtn.addActionListener((ActionEvent e) -> {
        });
    
    basicsBtn.setVisible(true);
        
        
        levelField.setFont(new Font("Serif", Font.PLAIN, 15));
        convoAndContextField.setFont(new Font("Serif", Font.PLAIN, 15));
        
        this.getMainPanel().setLayout(new GridLayout(15, 1));
        this.getMainPanel().add(levelField);
        this.getMainPanel().add(convoAndContextField);
        this.getMainPanel().add(a1Button);
        this.getMainPanel().add(a2Button);
        this.getMainPanel().add(b1Button);
        this.getMainPanel().add(b2Button);
        this.getMainPanel().add(persAndUniBtn);
        this.getMainPanel().add(shoppingBtn);
        this.getMainPanel().add(medAndhealBtn);
        this.getMainPanel().add(basicsBtn);
        
    }
    
}
