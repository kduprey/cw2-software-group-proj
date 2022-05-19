package main.gui;

import main.Database;
import main.dataclasses.Student;
import main.dataclasses.Teacher;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Signup extends BasePanel implements ActionListener{

    private JLabel title, usernameLabel, nameLabel, surnameLabel, passwordLabel, helpMessage, userTypeLabel;
    private JTextField usernameField, nameField, surnameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeField;
    private JButton signUp;
    private ArrayList<JTextComponent> fields;

    public Signup(ScreenSwitch screenSwitch){
        super(screenSwitch, "main");
        fields = new ArrayList<>();
        title = new JLabel("Create an account here!", SwingConstants.CENTER);
        String[] userOptions = {"Teacher", "Student"};

        usernameLabel = new JLabel("Username", SwingConstants.CENTER);
        nameLabel = new JLabel("Name", SwingConstants.CENTER);
        surnameLabel = new JLabel("Surname", SwingConstants.CENTER);
        passwordLabel = new JLabel("Password", SwingConstants.CENTER);
        userTypeLabel = new JLabel("User Type", SwingConstants.CENTER);
        helpMessage = new JLabel("", SwingConstants.CENTER);

        usernameField = new JTextField();
        nameField = new JTextField();
        surnameField = new JTextField();
        passwordField = new JPasswordField();
        userTypeField = new JComboBox<>(userOptions);
        userTypeField.setBounds(80, 50, 140, 20);

        fields.add(usernameField);
        fields.add(nameField);
        fields.add(surnameField);
        fields.add(passwordField);

        signUp = new JButton("Create Account");
        signUp.addActionListener(this);
        signUp.setOpaque(true);
        signUp.setBorderPainted(false);
        signUp.setBackground(new Color(245, 120, 118));

        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(new Color(245, 120, 118));

        helpMessage.setForeground(new Color(255, 0, 0));

        this.getMainPanel().setLayout(new GridLayout(21, 1));

        this.getMainPanel().add(title);
        this.getMainPanel().add(usernameLabel);
        this.getMainPanel().add(usernameField);
        this.getMainPanel().add(nameLabel);
        this.getMainPanel().add(nameField);
        this.getMainPanel().add(surnameLabel);
        this.getMainPanel().add(surnameField);
        this.getMainPanel().add(passwordLabel);
        this.getMainPanel().add(passwordField);
        this.getMainPanel().add(userTypeLabel);
        this.getMainPanel().add(userTypeField);
        this.getMainPanel().add(signUp);
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

//          Implemented alternate db handling of user storage - Kenton Duprey
            if (userTypeField.getSelectedItem().toString().equals("Teacher")) {
                ArrayList<HashMap<Integer, String>> languages = db.query("SELECT *" +
                        "      FROM Language\n" +
                        "      WHERE languageName='Spanish'\n" +
                        "      LIMIT 501");
                Teacher teacher = new Teacher(db, usernameField.getText(), String.valueOf(passwordField.getPassword()), Integer.parseInt(languages.get(0).get("languageID")));
                teacher.insert();
            } else {
                ArrayList<HashMap<Integer, String>> languages = db.query("SELECT *" +
                        "      FROM Language\n" +
                        "      WHERE languageName='Spanish'\n" +
                        "      LIMIT 501");
                Student student = new Student(db, usernameField.getText(), nameField.getText(), surnameField.getText(), String.valueOf(passwordField.getPassword()), "level", "Spanish", -1, Integer.parseInt(languages.get(0).get("languageID")));
                student.insert();
            }
            for(JTextComponent component: fields){
                component.setText("");
            }
            this.getScreenSwitch().show("login");

        }
    }
}
