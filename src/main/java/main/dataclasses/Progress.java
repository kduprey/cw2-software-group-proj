package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class Progress {

    private int progressId;
    private String progressTaskFrequency;
    private String progressStudentPerformance;
    private String progressTopics;
    private int studentId;
    private int teacherId;
    private Database db;
    private boolean added;

    public Progress(Database db,
                    String progressTaskFrequency,
                    String progressStudentPerformance,
                    String progressTopics,
                    int studentId,
                    int teacherId
    ) {
        this.db = db;
        this.progressTaskFrequency = progressTaskFrequency;
        this.progressStudentPerformance = progressStudentPerformance;
        this.progressTopics = progressTopics;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Progress SET " +
                    "progressTaskFrequency = '" + this.progressTaskFrequency + "'," +
                    "progressStudentPerformance = '" + this.progressStudentPerformance + "'," +
                    "progressTopics = '" + this.progressTopics + "'," +
                    "studentId = '" + this.studentId + "'," +
                    "teacherId = '" + this.teacherId + "'" +
                    " WHERE " +
                    "progressId = '" + this.progressId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Progress, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Progress WHERE progressId = '" + this.progressId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Progress, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Progress " +
                    "('progressTaskFrequency', 'progressStudentPerformance', 'progressTopics', 'studentId', 'teacherId')" +
                    " VALUES (" +
                    "'" + this.progressTaskFrequency + "'," +
                    "'" + this.progressStudentPerformance + "'," +
                    "'" + this.progressTopics + "'," +
                    "'" + this.studentId + "'," +
                    "'" + this.teacherId + "'" +
                    ");";
            this.db.update(query);
            ResultSet set = this.db.query("SELECT * from Progress order by progressId DESC LIMIT 1;");
            try {
                this.progressId = set.getInt("progressId");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.added = true;
        }else{
            System.out.println("Unable to insert Progress, the object is already in the database...");
        }
    }

    /*
     GETTERS AND SETTERS
     */

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public String getProgressTaskFrequency() {
        return progressTaskFrequency;
    }

    public void setProgressTaskFrequency(String progressTaskFrequency) {
        this.progressTaskFrequency = progressTaskFrequency;
    }

    public String getProgressStudentPerformance() {
        return progressStudentPerformance;
    }

    public void setProgressStudentPerformance(String progressStudentPerformance) {
        this.progressStudentPerformance = progressStudentPerformance;
    }

    public String getProgressTopics() {
        return progressTopics;
    }

    public void setProgressTopics(String progressTopics) {
        this.progressTopics = progressTopics;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
