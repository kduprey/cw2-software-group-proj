package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class Practice {

    private int teacherId;
    private int dialogueId;
    private int studentId;
    private String practiceDateTime;
    private Database db;
    private boolean added;

    public Practice(Database db,
                    int teacherId,
                    int dialogueId,
                    int studentId,
                    String practiceDateTime){
        this.db = db;
        this.teacherId = teacherId;
        this.dialogueId = dialogueId;
        this.studentId = studentId;
        this.practiceDateTime = practiceDateTime;
    }

    public void update(int teacherId, int dialogueId, int studentId, String practiceDateTime){
        if(this.added) {
            String query = "UPDATE Practice SET " +
                    "teacherId = '" + teacherId + "'," +
                    "dialogueId = '" + dialogueId + "'," +
                    "studentId = '" + studentId + "'," +
                    "practiceDateTime = '" + practiceDateTime + "'" +
                    " WHERE " +
                    "teacherId = '" + this.teacherId + "' and dialogueId = '"+this.dialogueId+"' and studentId = '"+this.studentId+"' and practiceDateTime = '"+this.practiceDateTime+"';";
            this.db.update(query);
            this.teacherId = teacherId;
            this.dialogueId = dialogueId;
            this.studentId = studentId;
            this.practiceDateTime = practiceDateTime;
        }else{
            System.out.println("Unable to update Practice, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Practice WHERE teacherId = '" + this.teacherId + "' and dialogueId = '"+this.dialogueId+"' and studentId = '"+this.studentId+"' and practiceDateTime = '"+this.practiceDateTime+"';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Practice, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Practice " +
                    "('teacherId', 'dialogueId', 'studentId', 'practiceDateTime')" +
                    " VALUES (" +
                    "'" + this.teacherId + "'," +
                    "'" + this.dialogueId + "'," +
                    "'" + this.studentId + "'," +
                    "'" + this.practiceDateTime + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
        }else{
            System.out.println("Unable to insert Practice, the object is already in the database...");
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

    public int getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(int dialogueId) {
        this.dialogueId = dialogueId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPracticeDateTime() {
        return practiceDateTime;
    }

    public void setPracticeDateTime(String practiceDateTime) {
        this.practiceDateTime = practiceDateTime;
    }

}
