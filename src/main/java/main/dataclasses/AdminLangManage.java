package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void update(int adminId, int languageId){
        if(this.added) {
            String query = "UPDATE AdminLangManage SET " +
                    "adminId = '" + adminId + "'," +
                    "languageId = '" + languageId + "'" +
                    " WHERE " +
                    "adminId = '" + this.adminId + "' and languageId = '"+this.languageId+"';";
            this.db.update(query);
            this.adminId = adminId;
            this.languageId = languageId;
        }else{
            System.out.println("Unable to update AdminLangManage, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM AdminLangManage WHERE adminId = '" + this.adminId + "' and languageId = '"+this.languageId+"';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete AdminLangManage, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO AdminLangManage " +
                    "('adminId', 'languageId')" +
                    " VALUES (" +
                    "'" + this.adminId + "'," +
                    "'" + this.languageId + "'" +
                    ");";
            this.db.update(query);
            this.added = true;
        }else{
            System.out.println("Unable to insert user AdminLangManage, the object is already in the database...");
        }
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
