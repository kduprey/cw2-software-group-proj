package main.dataclasses;


import main.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class Student {

    private int studentId;
    private String studentUsername;
    private String studentPassword;
    private String studentLevel;
    private String studentLanguages;
    private int studentPracticeID;
    private int languageId;
    private Database db;
    private boolean added;

    public Student(Database db,
                   String studentUsername,
                   String studentPassword,
                   String studentLevel,
                   String studentLanguages,
                   int studentPracticeID,
                   int languageId){
        this.db = db;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
        this.studentLevel = studentLevel;
        this.studentLanguages = studentLanguages;
        this.studentPracticeID = studentPracticeID;
        this.languageId = languageId;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE userStudent SET " +
                    "username = '" + this.studentUsername + "'," +
                    "password = '" + this.studentPassword + "'," +
                    "studentLevel = '" + this.studentLevel + "'," +
                    "studentLanguages = '" + this.studentLanguages + "'," +
                    "studentPracticeID = '" + this.studentPracticeID + "'," +
                    "languageCode = '" + this.languageId + "'" +
                    " WHERE " +
                    "userID = '" + this.studentId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update user student, the user has to be inserted into db first...");
        }
    }

    public void delete(){
        if(this.added){
            String query = "DELETE FROM userStudent WHERE userId = '" + this.studentId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete user student, the user has to be inserted into db first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO userStudent " +
                    "('username', 'password', 'studentLevel', 'studentLanguages', 'studentPracticeID', 'languageCode')" +
                    " VALUES (" +
                    "'" + this.studentUsername + "'," +
                    "'" + this.studentPassword + "'," +
                    "'" + this.studentLevel + "'," +
                    "'" + this.studentLanguages + "'," +
                    "'" + this.studentPracticeID + "'," +
                    "'" + this.languageId + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
            ResultSet set = this.db.query("SELECT * from userStudent order by userID DESC LIMIT 1;");
            try {
                this.studentId = set.getInt("userID");
            } catch (SQLException e) {
                System.out.println("Unable to get the id of the inserted user");
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Unable to insert user student, the user is already in the db...");
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

    public int getStudentPracticeID() {
        return studentPracticeID;
    }

    public void setStudentPracticeID(int studentPracticeID) {
        this.studentPracticeID = studentPracticeID;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
