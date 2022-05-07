package main.dataclasses;


import main.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Anastasiia Mazur
 */
public class Student {

    private int studentId;
    private String studentUsername;

    private String studentName;

    private String studentSurname;
    private String studentPassword;
    private String studentLevel;
    private String studentLanguages;
    private int studentPracticeId;
    private int languageId;
    private Database db;
    private boolean added;

    public Student(Database db,
                   String studentUsername,
                   String studentName,
                   String studentSurname,
                   String studentPassword,
                   String studentLevel,
                   String studentLanguages,
                   int studentPracticeId,
                   int languageId) {
        this.db = db;
        this.studentUsername = studentUsername;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentPassword = studentPassword;
        this.studentLevel = studentLevel;
        this.studentLanguages = studentLanguages;
        this.studentPracticeId = studentPracticeId;
        this.languageId = languageId;
        this.added = false;
    }

    public static boolean loginCheck(Database db, String username, String password){
        String query = "select * from student where studentUsername='"+username+"' and studentPassword='"+password+"';";
        ArrayList result = db.query(query);
        return result.size() > 0;
    }

    public static String getId(Database db, String username, String password){
        String query = "select * from student where studentUsername='"+username+"' and studentPassword='"+password+"';";
        ArrayList<HashMap<String, String>> result = db.query(query);
        return result.get(0).get("studentId");
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Student SET " +
                    "studentUsername = '" + this.studentUsername + "'," +
                    "studentName = '" + this.studentName + "'," +
                    "studentSurname = '" + this.studentSurname + "'," +
                    "studentPassword = '" + this.studentPassword + "'," +
                    "studentLevel = '" + this.studentLevel + "'," +
                    "studentLanguages = '" + this.studentLanguages + "'," +
                    "studentPracticeId = '" + this.studentPracticeId + "'," +
                    "languageId = '" + this.languageId + "'" +
                    " WHERE " +
                    "studentId = '" + this.studentId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Student, the user has to be inserted into db first...");
        }
    }

    public void delete(){
        if(this.added){
            String query = "DELETE FROM Student WHERE studentId = '" + this.studentId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete user student, the user has to be inserted into db first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Student " +
                    "('studentUsername', 'studentName', 'studentSurname', 'studentPassword', 'studentLevel', 'studentLanguages', 'studentPracticeId', 'languageId')" +
                    //"('studentUsername', 'studentPassword', 'studentLevel', 'studentLanguages', 'studentPracticeId', 'languageId')" +
                    " VALUES (" +
                    "'" + this.studentUsername + "'," +
                    "'" + this.studentName + "'," +
                    "'" + this.studentSurname + "'," +
                    "'" + this.studentPassword + "'," +
                    "'" + this.studentLevel + "'," +
                    "'" + this.studentLanguages + "'," +
                    "'" + this.studentPracticeId + "'," +
                    "'" + this.languageId + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
            ArrayList<HashMap<String, String>> list = this.db.query("SELECT * from Student order by studentId DESC LIMIT 1;");
            this.studentId = Integer.parseInt(list.get(0).get("studentId"));
        }else{
            System.out.println("Unable to insert Student, the user is already in the db...");
        }
    }
    /*
     GETTERS AND SETTERS
     */

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getStudentLanguages() {
        return studentLanguages;
    }

    public void setStudentLanguages(String studentLanguages) {
        this.studentLanguages = studentLanguages;
    }

    public int getStudentPracticeId() {
        return studentPracticeId;
    }

    public void setStudentPracticeId(int studentPracticeId) {
        this.studentPracticeId = studentPracticeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
