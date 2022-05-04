package main.gui;

import javax.swing.*;

public class GUI extends JFrame {

    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 700;

    public static void main(String args[]){
        new GUI();
    }

    public GUI(){
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        BasePanel panel = new BasePanel();
        Signup panel = new Signup();
        this.add(panel);

        this.setVisible(true);
    }

}
