package main.gui;

import javax.swing.*;
import java.awt.*;

public class ScreenSwitch extends JPanel {

    private CardLayout layout;

    public ScreenSwitch(){
        CardLayout cards = new CardLayout();
        this.layout = cards;
        this.setLayout(cards);
    }

    public void show(String card){
        this.layout.show(this, card);
    }

}
