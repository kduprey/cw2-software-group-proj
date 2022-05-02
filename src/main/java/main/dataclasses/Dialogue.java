package main.dataclasses;

import main.Database;

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
    private int languageId;
    private Database db;
    private boolean added;

    public Dialogue(Database db,
                    String dialogueContext,
                    String dialogueSubContext,
                    String dialogueKeyVocab,
                    String dialogueGrammarStructure,
                    int languageId){
        this.db = db;
        this.dialogueContext = dialogueContext;
        this.dialogueSubContext = dialogueSubContext;
        this.dialogueKeyVocab = dialogueKeyVocab;
        this.dialogueGrammarStructure = dialogueGrammarStructure;
        this.languageId = languageId;
        this.added = false;
    }

    /*
    GETTERS AND SETTERS
     */

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
