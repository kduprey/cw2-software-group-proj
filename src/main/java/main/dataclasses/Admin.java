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
public class Admin {

    private int adminId;
    private String adminType;
    private String adminUsername;
    private String adminPassword;

    private int languageId;
    private Database db;
    private boolean added;

    public Admin(Database db,
                     String adminUsername,
                     String adminPassword,
                     String adminType,
                     int languageId){
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminType = adminType;
        this.languageId = languageId;
        this.db = db;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE Admin SET " +
                    "adminUsername = '" + this.adminUsername + "'," +
                    "adminPassword = '" + this.adminPassword + "'," +
                    "adminType = '" + this.adminType + "'," +
                    "languageId = '" + this.languageId + "'" +
                    " WHERE " +
                    "adminId = '" + this.adminId + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update Admin, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM Admin WHERE adminId = '" + this.adminId + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete Admin, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO Admin " +
                    "('adminUsername', 'adminPassword', 'adminType', 'languageId')" +
                    " VALUES (" +
                    "'" + this.adminUsername + "'," +
                    "'" + this.adminPassword + "'," +
                    "'" + this.adminType + "'," +
                    "'" + this.languageId + "'" +
                    ");";
            this.db.update(query);
            ArrayList<HashMap<String, String>> list = this.db.query("SELECT * from Admin order by adminId DESC LIMIT 1;");
            this.adminId = Integer.parseInt(list.get(0).get("adminId"));
            this.added = true;
        }else{
            System.out.println("Unable to insert Admin, the object is already in the database...");
        }
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
