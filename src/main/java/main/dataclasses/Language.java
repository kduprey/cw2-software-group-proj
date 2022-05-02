package main.dataclasses;

import main.Database;

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
