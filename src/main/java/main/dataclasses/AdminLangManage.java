package main.dataclasses;

import main.Database;

/**
 *
 * @author Anastasiia Mazur
 */
public class AdminLangManage {

    private int adminId;
    private int languageId;
    private Database db;
    private boolean added;

    public AdminLangManage(Database db,
                           int adminId,
                           int languageId){
        this.db = db;
        this.adminId = adminId;
        this.languageId = languageId;
        this.added = false;
    }

    /*
    GETTERS AND SETTERS
     */

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
