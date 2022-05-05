package main.gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 700;

    public static void main(String args[]){
        new GUI();
    }

    public GUI(){
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ScreenSwitch screenSwitch = new ScreenSwitch();

        MainPage main = new MainPage(screenSwitch);
        Signup signup = new Signup(screenSwitch);
        Login login = new Login(screenSwitch);

        screenSwitch.add(signup, "signup");
        screenSwitch.add(login, "login");
        screenSwitch.add(main, "main");

        screenSwitch.show("main");

        this.add(screenSwitch);

        this.setVisible(true);
    }

}
