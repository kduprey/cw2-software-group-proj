package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class Language {

    private int languageId;
    private String languageName;
    private String languageLevel;
    private Database db;
    private boolean added;

    public Language(Database db,
                    String languageName,
                    String languageLevel){
        this.db = db;
        this.languageName = languageName;
        this.languageLevel = languageLevel;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Language SET " +
                    "languageName = '" + this.languageName + "'," +
                    "languageLevel = '" + this.languageLevel + "'" +
                    " WHERE " +
                    "languageId = '" + this.languageId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Language, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Language WHERE languageId = '" + this.languageId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Language, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Language " +
                    "('languageName', 'languageLevel')" +
                    " VALUES (" +
                    "'" + this.languageName + "'," +
                    "'" + this.languageLevel + "'" +
                    ");";
            this.db.update(query);
            ResultSet set = this.db.query("SELECT * from Language order by languageId DESC LIMIT 1;");
            try {
                this.languageId = set.getInt("languageId");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.added = true;
        }else{
            System.out.println("Unable to insert Language, the object is already in the database...");
        }
    }

    /*
    GETTERS AND SETTERS
     */

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }
}
