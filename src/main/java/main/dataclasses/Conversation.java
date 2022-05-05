package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Anastasiia Mazur
 */

public class Conversation {

    private int conversationId;
    private String conversationText;
    private String conversationTranslation;
    private int dialogueId;
    private Database db;
    private boolean added;

    public Conversation(Database db,
                        String conversationText,
                        String conversationTranslation,
                        int dialogueId){
        this.db = db;
        this.conversationText = conversationText;
        this.conversationTranslation = conversationTranslation;
        this.dialogueId = dialogueId;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Conversation SET " +
                    "conversationText = '" + this.conversationText + "'," +
                    "conversationTranslation = '" + this.conversationTranslation + "'," +
                    "dialogueId = '" + this.dialogueId + "'" +
                    " WHERE " +
                    "conversationId = '" + this.conversationId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Conversation, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Conversation WHERE conversationId = '" + this.conversationId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Conversation, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Conversation " +
                    "('conversationText', 'conversationTranslation', 'dialogueId')" +
                    " VALUES (" +
                    "'" + this.conversationText + "'," +
                    "'" + this.conversationTranslation + "'," +
                    "'" + this.dialogueId + "'" +
                    ");";
            this.db.update(query);
            ArrayList<HashMap<String, String>> list = this.db.query("SELECT * from Conversation order by conversationId DESC LIMIT 1;");
            this.conversationId = Integer.parseInt(list.get(0).get("conversationId"));
            this.added = true;
        }else{
            System.out.println("Unable to insert Conversation, the object is already in the database...");
        }
    }

    /*
    GETTERS AND SETTERS
     */

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationText() {
        return conversationText;
    }

    public void setConversationText(String conversationText) {
        this.conversationText = conversationText;
    }

    public String getConversationTranslation() {
        return conversationTranslation;
    }

    public void setConversationTranslation(String conversationTranslation) {
        this.conversationTranslation = conversationTranslation;
    }

    public int getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(int dialogueId) {
        this.dialogueId = dialogueId;
    }
}
