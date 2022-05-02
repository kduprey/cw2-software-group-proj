package main.dataclasses;


import main.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class UserStudent {

    private int userID;
    private String username;
    private String password;
    private String studentLevel;
    private String studentLanguages;
    private int studentPracticeID;
    private int languageCode;
    private Database db;
    private boolean added;

    public UserStudent(Database db,
                       String username,
                       String password,
                       String studentLevel,
                       String studentLanguages,
                       int studentPracticeID,
                       int languageCode){
        this.db = db;
        this.username = username;
        this.password = password;
        this.studentLevel = studentLevel;
        this.studentLanguages = studentLanguages;
        this.studentPracticeID = studentPracticeID;
        this.languageCode = languageCode;
        this.added = false;
    }

    public static String generateLastRecordQuery(){
        return "SELECT * from userStudent order by userID DESC LIMIT 1;";
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE userStudent SET " +
                    "username = '" + this.username + "'," +
                    "password = '" + this.password + "'," +
                    "studentLevel = '" + this.studentLevel + "'," +
                    "studentLanguages = '" + this.studentLanguages + "'," +
                    "studentPracticeID = '" + this.studentPracticeID + "'," +
                    "languageCode = '" + this.languageCode + "'" +
                    " WHERE " +
                    "userID = '" + this.userID + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update user student, the user has to be inserted into db first...");
        }
    }

    public void delete(){
        if(this.added){
            String query = "DELETE FROM userStudent WHERE userId = '" + this.userID + "';";
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
                    "'" + this.username + "'," +
                    "'" + this.password + "'," +
                    "'" + this.studentLevel + "'," +
                    "'" + this.studentLanguages + "'," +
                    "'" + this.studentPracticeID + "'," +
                    "'" + this.languageCode + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
            ResultSet set = this.db.query("SELECT * from userStudent order by userID DESC LIMIT 1;");
            try {
                this.userID = set.getInt("userID");
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
    public int getUserId() {
        return userID;
    }

    public void setUserId(int userId) {
        this.userID = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String userLevel) {
        this.studentLevel = userLevel;
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

    public int getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(int languageCode) {
        this.languageCode = languageCode;
    }
}
