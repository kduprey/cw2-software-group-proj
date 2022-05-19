package main.gui;

import main.Database;
import main.dataclasses.Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.HashMap;

public class AdministratorUserData extends BasePanel {

    private JLabel mostPracticed;

    private JLabel leastPracticed;

    private JLabel header;


//    private JButton

    public AdministratorUserData(ScreenSwitch screenSwitch) {
        super(screenSwitch, "menu");

        this.getMainPanel().setLayout(new BorderLayout());
        this.getMainPanel().add(new JLabel(" "), BorderLayout.NORTH);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.SOUTH);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.WEST);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.EAST);
    }

    public void draw() {
        System.out.println("Made it here");

        System.out.println(this.getScreenSwitch().getUserId());



        if (this.getScreenSwitch().getUserType().equals("Student")) {

            this.getScreenSwitch().show("menu");
        }

    }



}
