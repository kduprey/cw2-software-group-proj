package main.dataclasses;

import main.Database;

public class Teacher {

    private int teacherId;
    private String teacherUsername;
    private String teacherPassword;
    private String teacherLanguage;
    private Database db;
    private boolean added;

    public Teacher(Database db,
                   String teacherUsername,
                   String teacherPassword,
                   String teacherLanguage){
        this.teacherUsername = teacherUsername;
        this.teacherPassword = teacherPassword;
        this.teacherLanguage = teacherLanguage;
        this.db = db;
        this.added = false;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherLanguage() {
        return teacherLanguage;
    }

    public void setTeacherLanguage(String teacherLanguage) {
        this.teacherLanguage = teacherLanguage;
    }
}
