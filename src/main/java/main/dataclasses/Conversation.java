package main.dataclasses;

import main.Database;

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
