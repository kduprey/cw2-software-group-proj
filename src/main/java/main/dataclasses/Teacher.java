package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Teacher {

    private int teacherId;
    private String teacherUsername;
    private String teacherPassword;
    private Integer teacherLanguage;
    private Database db;
    private boolean added;

    public Teacher(Database db,
                   String teacherUsername,
                   String teacherPassword,
                   Integer teacherLanguage){
        this.teacherUsername = teacherUsername;
        this.teacherPassword = teacherPassword;
        this.teacherLanguage = teacherLanguage;
        this.db = db;
        this.added = false;
    }

    public static boolean loginCheck(Database db, String username, String password){
        String query = "select * from teacher where teacherUsername='"+username+"' and teacherPassword='"+password+"';";
        ArrayList result = db.query(query);
        return result.size() > 0;
    }

    public static String getId(Database db, String username, String password){
        String query = "select * from teacher where teacherUsername='"+username+"' and teacherPassword='"+password+"';";
        ArrayList<HashMap<String, String>> result = db.query(query);
        return result.get(0).get("teacherId");
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Teacher SET " +
                    "teacherUsername = '" + this.teacherUsername + "'," +
                    "teacherPassword = '" + this.teacherPassword + "'," +
                    "teacherLanguage = '" + this.teacherLanguage + "'" +
                    " WHERE " +
                    "teacherId = '" + this.teacherId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Teacher, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Teacher WHERE teacherId = '" + this.teacherId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Teacher, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Teacher " +
                    "('teacherUsername', 'teacherPassword', 'teacherLanguage')" +
                    " VALUES (" +
                    "'" + this.teacherUsername + "'," +
                    "'" + this.teacherPassword + "'," +
                    "'" + this.teacherLanguage + "'" +
                    ");";
            this.db.update(query);
            ArrayList<HashMap<String, String>> list = this.db.query("SELECT * from Teacher order by teacherId DESC LIMIT 1;");
            this.teacherId = Integer.parseInt(list.get(0).get("teacherId"));
            this.added = true;
        }else{
            System.out.println("Unable to insert Teacher, the object is already in the database...");
        }
    }

    /*
    GETTERS AND SETTERS
     */

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

    public Integer getTeacherLanguage() {
        return teacherLanguage;
    }

    public void setTeacherLanguage(Integer teacherLanguage) {
        this.teacherLanguage = teacherLanguage;
    }
}
