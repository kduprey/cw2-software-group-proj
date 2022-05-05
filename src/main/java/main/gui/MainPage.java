package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends BasePanel {

    private ScreenSwitch screenSwitch;
    private JLabel title;
    private JButton login, signup;
    
    public MainPage(ScreenSwitch screenSwitch){
        super(screenSwitch, "main");
        this.screenSwitch = screenSwitch;

        title = new JLabel("Create an account here!", SwingConstants.CENTER);

        signup = new JButton("Sign Up");
        login = new JButton("Login");

        signup.addActionListener(new SignupActionListener(screenSwitch));
        login.addActionListener(new LoginActionListener(screenSwitch));

        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(new Color(245, 120, 118));
        for(int i = 0; i < 5; i++){
            this.getMainPanel().add(new JLabel(""));
        }
        this.getMainPanel().add(title);
        this.getMainPanel().add(login);
        this.getMainPanel().add(signup);
        this.getMainPanel().setLayout(new GridLayout(13, 1));
        for(int i = 0; i < 5; i++){
            this.getMainPanel().add(new JLabel(""));
        }

    }

}

class LoginActionListener implements ActionListener{

    private ScreenSwitch screenSwitch;

    public LoginActionListener(ScreenSwitch screenSwitch){
        this.screenSwitch = screenSwitch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.screenSwitch.show("login");
    }
}

class SignupActionListener implements ActionListener{

    private ScreenSwitch screenSwitch;

    public SignupActionListener(ScreenSwitch screenSwitch){
        this.screenSwitch = screenSwitch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.screenSwitch.show("signup");
    }
}