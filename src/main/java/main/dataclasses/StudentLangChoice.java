package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void update(int studentId, int languageId){
        if(this.added) {
            String query = "UPDATE StudentLangChoice SET " +
                    "studentId = '" + studentId + "'," +
                    "languageId = '" + languageId + "'" +
                    " WHERE " +
                    "languageId = '" + this.languageId + "' and studentId = '"+this.studentId+"';";
            this.db.update(query);
            this.studentId = studentId;
            this.languageId = languageId;
        }else{
            System.out.println("Unable to update StudentLangChoice, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM StudentLangChoice WHERE languageId = '" + this.languageId + "' and studentId = '"+this.studentId+"';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete StudentLangChoice, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO StudentLangChoice " +
                    "('languageId', 'studentId')" +
                    " VALUES (" +
                    "'" + this.languageId + "'," +
                    "'" + this.studentId + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
        }else{
            System.out.println("Unable to insert StudentLangChoice, the object is already in the database...");
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
