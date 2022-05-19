package main.gui;

import main.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AdministratorUserData extends BasePanel {

    private JLabel mostPracticed = new JLabel();

    private JLabel leastPracticed = new JLabel();

    private JLabel header = new JLabel();


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

        JPanel adminPanel = new JPanel();

        Database db = new Database();

        ArrayList<HashMap<String, Integer>> studentIDCounts = db.query("select studentId from Practice;");
        if (studentIDCounts.size() > 0) {
            HashMap<Integer, Integer> studentProgress = new HashMap<Integer, Integer>();

            studentIDCounts.forEach((e) -> {
                if (studentProgress.get(e.get("studentId")) == null)
                    studentProgress.put(e.get("studentId"), 1);
                else
                    studentProgress.put(e.get("studentId"), studentProgress.get(e.get("studentId")) + 1);
            });


            HashMap.Entry<Integer, Integer> maxEntry = null;

            for (HashMap.Entry<Integer, Integer> entry : studentProgress.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }

            HashMap.Entry<Integer, Integer> minEntry = null;

            for (HashMap.Entry<Integer, Integer> entry : studentProgress.entrySet()) {
                if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                    minEntry = entry;
                }
            }

            ArrayList<HashMap<String, String>> maxStudentInfo = db.query("select studentName, studentSurname from Student where studentId='" + maxEntry.getKey() + "'");
            ArrayList<HashMap<String, String>> minStudentInfo = db.query("select studentName, studentSurname from Student where studentId='" + minEntry.getKey() + "'");


            mostPracticed.setText("Most progress lessons is " + maxEntry.getValue() + " by student: " + maxStudentInfo.get(0).get("studentName"));

            leastPracticed.setText("Least progress lessons is " + minEntry.getValue() + " by student: " + minStudentInfo.get(0).get("studentName"));
        } else {
            mostPracticed.setText("Most progress lessons is " + 0 + " by student: " + 0);

            leastPracticed.setText("Least progress lessons is " + 0 + " by student: " + 0);
        }




        header.setText("Student Analytics");
        JPanel studentData = new JPanel();
        studentData.add(header);
        studentData.add(mostPracticed);
        studentData.add(leastPracticed);
        studentData.setLayout(new BoxLayout(studentData, BoxLayout.Y_AXIS));

        JPanel adminTasks = new JPanel();
        JLabel adminHeader = new JLabel("Admin Tasks");
        adminTasks.add(adminHeader);
        JButton clearProgress = new JButton("Clear Student Progress");
        adminTasks.add(clearProgress);


        JTextField removeStudentId = new JTextField();
        JButton removeStudent = new JButton("Remove Student");

        removeStudentId.setSize(40, 20);

        JPanel removeStudentPanel = new JPanel();
        removeStudentPanel.add(removeStudentId);
        removeStudentPanel.add(removeStudent);
        removeStudentPanel.setLayout(new BoxLayout(removeStudentPanel, BoxLayout.Y_AXIS));

        adminTasks.add(removeStudentPanel);
        removeStudent.setEnabled(false);
        adminTasks.setLayout(new BoxLayout(adminTasks, BoxLayout.Y_AXIS));


        adminPanel.add(studentData);
        adminPanel.add(adminTasks);

        getMainPanel().add(adminPanel);

        removeStudentId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!removeStudentId.getText().equals(""))
                    removeStudent.setEnabled(true);
            }
        });
        clearProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like clear this data?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

                switch (confirm) {
                    case JOptionPane.NO_OPTION:
                        break;

                    case JOptionPane.CANCEL_OPTION:
                        break;

                    case JOptionPane.OK_OPTION:
                        db.update("delete from Practice");
                        JOptionPane.showMessageDialog(null, "Data has been removed.");
                        mostPracticed.setText("Most progress lessons is " + 0 + " by student: " + 0);

                        leastPracticed.setText("Least progress lessons is " + 0 + " by student: " + 0);
                        break;
                }
            }
        });

        removeStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isCharcter = false;
                char[] chars = removeStudentId.getText().toCharArray();
                for (char c : chars) {
                    if (!Character.isDigit(c))
                        isCharcter = true;
                }

                if (removeStudentId.getText().equals("") || isCharcter) {
                    JOptionPane.showMessageDialog(null, "Please enter a student ID");
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you would like clear this student?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

                switch (confirm) {
                    case JOptionPane.NO_OPTION:
                        break;

                    case JOptionPane.CANCEL_OPTION:
                        break;

                    case JOptionPane.OK_OPTION:
                        db.update("delete from Student where studentId is " + removeStudentId.getText());
                        JOptionPane.showMessageDialog(null, "Data has been removed.");
                        ArrayList<HashMap<String, Integer>> studentIDCounts = db.query("select studentId from Practice;");
                        if (studentIDCounts.size() > 0) {
                            HashMap<Integer, Integer> studentProgress = new HashMap<Integer, Integer>();

                            studentIDCounts.forEach((a) -> {
                                if (studentProgress.get(a.get("studentId")) == null)
                                    studentProgress.put(a.get("studentId"), 1);
                                else
                                    studentProgress.put(a.get("studentId"), studentProgress.get(a.get("studentId")) + 1);
                            });


                            HashMap.Entry<Integer, Integer> maxEntry = null;

                            for (HashMap.Entry<Integer, Integer> entry : studentProgress.entrySet()) {
                                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                                    maxEntry = entry;
                                }
                            }

                            HashMap.Entry<Integer, Integer> minEntry = null;

                            for (HashMap.Entry<Integer, Integer> entry : studentProgress.entrySet()) {
                                if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                                    minEntry = entry;
                                }
                            }

                            ArrayList<HashMap<String, String>> maxStudentInfo = db.query("select studentName, studentSurname from Student where studentId='" + maxEntry.getKey() + "'");
                            ArrayList<HashMap<String, String>> minStudentInfo = db.query("select studentName, studentSurname from Student where studentId='" + minEntry.getKey() + "'");


                            mostPracticed.setText("Most progress lessons is " + maxEntry.getValue() + " by student: " + maxStudentInfo.get(0).get("studentName"));

                            leastPracticed.setText("Least progress lessons is " + minEntry.getValue() + " by student: " + minStudentInfo.get(0).get("studentName"));
                        } else {
                            mostPracticed.setText("Most progress lessons is " + 0 + " by student: " + 0);

                            leastPracticed.setText("Least progress lessons is " + 0 + " by student: " + 0);
                        }
                        break;
                }
            }
        });


    }




}
