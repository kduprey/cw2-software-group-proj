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
    private int studentPracticeId;
    private int languageId;
    private Database db;
    private boolean added;

    public Student(Database db,
                   String studentUsername,
                   String studentPassword,
                   String studentLevel,
                   String studentLanguages,
                   int studentPracticeId,
                   int languageId) {
        this.db = db;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
        this.studentLevel = studentLevel;
        this.studentLanguages = studentLanguages;
        this.studentPracticeId = studentPracticeId;
        this.languageId = languageId;
        this.added = false;
    }

    public static boolean loginCheck(Database db, String username, String password){
        String query = "select * from student where studentUsername='"+username+"' and studentPassword='"+password+"';";
        ResultSet result = db.query(query);
        try {
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Student SET " +
                    "studentUsername = '" + this.studentUsername + "'," +
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
                    "('studentUsername', 'studentPassword', 'studentLevel', 'studentLanguages', 'studentPracticeId', 'languageId')" +
                    " VALUES (" +
                    "'" + this.studentUsername + "'," +
                    "'" + this.studentPassword + "'," +
                    "'" + this.studentLevel + "'," +
                    "'" + this.studentLanguages + "'," +
                    "'" + this.studentPracticeId + "'," +
                    "'" + this.languageId + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
            ResultSet set = this.db.query("SELECT * from Student order by studentId DESC LIMIT 1;");
            try {
                this.studentId = set.getInt("studentId");
            } catch (SQLException e) {
                System.out.println("Unable to get the id of the inserted user");
                throw new RuntimeException(e);
            }
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
