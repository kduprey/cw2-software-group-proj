package main.dataclasses;

import main.Database;

/**
 *
 * @author Anastasiia Mazur
 */
public class StudentLangChoice {

    private int studentId;
    private int languageId;
    private Database db;
    private boolean added;

    public StudentLangChoice(Database db,
                             int studentId,
                             int languageId){
        this.db = db;
        this.studentId = studentId;
        this.languageId = languageId;
        this.added = false;
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
