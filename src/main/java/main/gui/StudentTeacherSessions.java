package main.gui;

import main.Database;
import main.dataclasses.Practice;
import main.dataclasses.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTeacherSessions extends BasePanel{

    public StudentTeacherSessions(ScreenSwitch screenSwitch) {
        super(screenSwitch, "menu");
        this.getMainPanel().setBackground(new Color(0, 125, 125));
        this.getMainPanel().setLayout(new BorderLayout());
        this.getMainPanel().add(new JLabel(" "), BorderLayout.NORTH);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.SOUTH);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.WEST);
        this.getMainPanel().add(new JLabel(" "), BorderLayout.EAST);


    }

    public void draw(){
//        this.setMainPanel(new JPanel());
        ArrayList<Practice> practices = Practice.getByStudentId(new Database(), this.getScreenSwitch().getUserId());
        HashMap<String, Integer> values = new HashMap<>();
        for(Practice practice: practices){
            if(values.keySet().contains(practice.getPracticeDateTime())){
                values.put(practice.getPracticeDateTime(), values.get(practice.getPracticeDateTime()) + 1);
            }else{
                values.put(practice.getPracticeDateTime(), 1);
            }
        }
        String[] names = values.keySet().toArray(new String[0]);
        Integer[] totals = values.values().toArray(new Integer[0]);
        while(this.getMainPanel().getComponents().length > 2) {
            this.getMainPanel().remove(2);
        }
        this.getMainPanel().add(new BarChart(totals, names, "Student - Teacher Sessions"), BorderLayout.CENTER);
        this.getMainPanel().revalidate();
        this.getMainPanel().repaint();
//        this.getMainPanel().setVisible(true);
    }


}

class DrawPanel extends JPanel{

    public void paint(Graphics g){
        g.drawRect(100, 100, 200, 200);
    }

    public void paintComponent(Graphics g){
        g.drawRect(2, 4, 200, 100);
    }

}
