package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends BasePanel{

    private JButton selectLanguage, selectTopic, administratorUserData, performanceOfStudent, studentTeacherSessions, monitorTopicConversation;

    public MainMenu(ScreenSwitch screenSwitch) {
        super(screenSwitch, "main");

        selectLanguage = new JButton("Select the teacher student and language");
        selectTopic = new JButton("Select topic level conversation for student and teacher");
        administratorUserData = new JButton("Administer users’ data with appropriate analytics");
        performanceOfStudent = new JButton("Monitor the performance of the student with appropriate analytics\n");
        studentTeacherSessions = new JButton("Monitor how often a teacher-student pair has engaged with a task with appropriate analytics");
        monitorTopicConversation = new JButton("Monitor how often different topics/conversations at various levels are invoked with appropriate analytics");

        selectLanguage.addActionListener(new MenuButtonsListener("selectLanguage", screenSwitch));
        selectTopic.addActionListener(new MenuButtonsListener("selectTopic", screenSwitch));
        administratorUserData.addActionListener(new MenuButtonsListener("administratorUserData", screenSwitch));
        performanceOfStudent.addActionListener(new MenuButtonsListener("performanceOfStudent", screenSwitch));
        studentTeacherSessions.addActionListener(new MenuButtonsListener("studentTeacherSessions", screenSwitch));
        monitorTopicConversation.addActionListener(new MenuButtonsListener("monitorTopicConversation", screenSwitch));

        this.getMainPanel().setLayout(new GridLayout(6, 1));

        this.getMainPanel().add(selectLanguage);
        this.getMainPanel().add(selectTopic);
        this.getMainPanel().add(administratorUserData);
        this.getMainPanel().add(performanceOfStudent);
        this.getMainPanel().add(studentTeacherSessions);
        this.getMainPanel().add(monitorTopicConversation);

    }
}

class MenuButtonsListener implements ActionListener {

    private String name;
    private ScreenSwitch screenSwitch;

    MenuButtonsListener(String name, ScreenSwitch screenSwitch){
        this.name = name;
        this.screenSwitch = screenSwitch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (name.equals("administratorUserData") && screenSwitch.getUserType().equals("Student")) {
            JOptionPane.showMessageDialog(null, "Students are not allowed to view this data.", "Not Allowed", JOptionPane.ERROR_MESSAGE);
        } else {
            screenSwitch.show(name);
        }

    }
}
