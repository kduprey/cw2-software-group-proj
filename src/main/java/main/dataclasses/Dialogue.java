package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class Dialogue {

    private int dialogueId;
    private String dialogueContext;
    private String dialogueSubContext;
    private String dialogueKeyVocab;
    private String dialogueGrammarStructure;
    private String dialogueLevel;
    private int languageId;
    private Database db;
    private boolean added;

    public Dialogue(Database db,
                    String dialogueContext,
                    String dialogueSubContext,
                    String dialogueKeyVocab,
                    String dialogueGrammarStructure,
                    String dialogueLevel,
                    int languageId){
        this.db = db;
        this.dialogueContext = dialogueContext;
        this.dialogueSubContext = dialogueSubContext;
        this.dialogueKeyVocab = dialogueKeyVocab;
        this.dialogueGrammarStructure = dialogueGrammarStructure;
        this.dialogueLevel = dialogueLevel;
        this.languageId = languageId;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Dialogue SET " +
                    "dialogueContext = '" + this.dialogueContext + "'," +
                    "dialogueSubContext = '" + this.dialogueSubContext + "'," +
                    "dialogueKeyVocab = '" + this.dialogueKeyVocab + "'," +
                    "dialogueLevel = '" + this.dialogueLevel + "'," +
                    "dialogueGrammarStructure = '" + this.dialogueGrammarStructure + "'," +
                    "languageId = '" + this.languageId + "'" +
                    " WHERE " +
                    "dialogueId = '" + this.dialogueId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Dialogue, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Dialogue WHERE dialogueId = '" + this.dialogueId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Dialogue, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Dialogue " +
                    "('dialogueContext', 'dialogueSubContext', 'dialogueKeyVocab', 'dialogueGrammarStructure', 'languageId', 'dialogueLevel')" +
                    " VALUES (" +
                    "'" + this.dialogueContext + "'," +
                    "'" + this.dialogueSubContext + "'," +
                    "'" + this.dialogueKeyVocab + "'," +
                    "'" + this.dialogueGrammarStructure + "'," +
                    "'" + this.languageId + "'," +
                    "'" + this.dialogueLevel + "'" +
                    ");";
            this.db.update(query);
            ResultSet set = this.db.query("SELECT * from Dialogue order by dialogueId DESC LIMIT 1;");
            try {
                this.dialogueId = set.getInt("dialogueId");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.added = true;
        }else{
            System.out.println("Unable to insert Dialogue, the object is already in the database...");
        }
    }

    /*
    GETTERS AND SETTERS
     */

    public String getDialogueLevel() {
        return dialogueLevel;
    }

    public void setDialogueLevel(String dialogueLevel) {
        this.dialogueLevel = dialogueLevel;
    }

    public int getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(int dialogueId) {
        this.dialogueId = dialogueId;
    }

    public String getDialogueContext() {
        return dialogueContext;
    }

    public void setDialogueContext(String dialogueContext) {
        this.dialogueContext = dialogueContext;
    }

    public String getDialogueSubContext() {
        return dialogueSubContext;
    }

    public void setDialogueSubContext(String dialogueSubContext) {
        this.dialogueSubContext = dialogueSubContext;
    }

    public String getDialogueKeyVocab() {
        return dialogueKeyVocab;
    }

    public void setDialogueKeyVocab(String dialogueKeyVocab) {
        this.dialogueKeyVocab = dialogueKeyVocab;
    }

    public String getDialogueGrammarStructure() {
        return dialogueGrammarStructure;
    }

    public void setDialogueGrammarStructure(String dialogueGrammarStructure) {
        this.dialogueGrammarStructure = dialogueGrammarStructure;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
