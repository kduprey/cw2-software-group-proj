package main.gui;

import main.Database;
import main.dataclasses.Student;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends BasePanel implements ActionListener {

    private JLabel title, emailLabel, passwordLabel, helpMessage;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton login;
    private ArrayList<JTextComponent> fields;

    public Login(ScreenSwitch screenSwitch){
        super(screenSwitch, "main");
        fields = new ArrayList<>();
        title = new JLabel("Login into your account!", SwingConstants.CENTER);

        emailLabel = new JLabel("Email", SwingConstants.CENTER);
        passwordLabel = new JLabel("Password", SwingConstants.CENTER);
        helpMessage = new JLabel("", SwingConstants.CENTER);

        emailField = new JTextField();
        passwordField = new JPasswordField();

        fields.add(emailField);
        fields.add(passwordField);

        login = new JButton("Login");
        login.addActionListener(this);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setBackground(new Color(245, 120, 118));

        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(new Color(245, 120, 118));

        helpMessage.setForeground(new Color(255, 0, 0));

        this.getMainPanel().setLayout(new GridLayout(17, 1));

        for(int i = 0; i < 5; i++){
            this.getMainPanel().add(new JLabel(""));
        }
        this.getMainPanel().add(title);
        this.getMainPanel().add(emailLabel);
        this.getMainPanel().add(emailField);
        this.getMainPanel().add(passwordLabel);
        this.getMainPanel().add(passwordField);
        this.getMainPanel().add(login);
        this.getMainPanel().add(helpMessage);
        for(int i = 0; i < 5; i++){
            this.getMainPanel().add(new JLabel(""));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean error = false;

        for(JTextComponent component: fields){
            if(component.getText().equals("")){
                error = true;
                helpMessage.setText("Please fill in all of the fields!");
                break;
            }
        }
        if(!error) {
            helpMessage.setText("");
            Database db = new Database();
            boolean check = Student.loginCheck(db, emailField.getText(), passwordField.getText());
            if(!check){
                helpMessage.setText("The username or password is incorrect");
            }else{
                for(JTextComponent field: fields){
                    field.setText("");
                }
                this.getScreenSwitch().show("menu");
            }
        }
    }


}
