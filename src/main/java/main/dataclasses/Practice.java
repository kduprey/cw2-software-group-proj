package main.dataclasses;

import main.Database;

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
