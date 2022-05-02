package main.dataclasses;

import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anastasiia Mazur
 */
public class UserAdmin {

    private int userID;
    private String username;
    private String password;
    private String adminType;
    private int languageCode;
    private Database db;
    private boolean added;

    public UserAdmin(Database db,
                     String username,
                     String password,
                     String adminType,
                     int languageCode){
        this.username = username;
        this.password = password;
        this.adminType = adminType;
        this.languageCode = languageCode;
        this.db = db;
        this.added = false;
    }

    public void update(){
        if(this.added) {
            String query = "UPDATE userAdmin SET " +
                    "username = '" + this.username + "'," +
                    "password = '" + this.password + "'," +
                    "adminType = '" + this.adminType + "'," +
                    "languageCode = '" + this.languageCode + "'" +
                    " WHERE " +
                    "userID = '" + this.userID + "';";
            this.db.update(query);
        }else{
            System.out.println("Unable to update user student, the object has to be added to database first...");
        }
    }

    public void delete(){
        if(this.added) {
            String query = "DELETE FROM userAdmin WHERE userID = '" + this.userID + "';";
            this.db.update(query);
            this.added = false;
        }else{
            System.out.println("Unable to delete user student, the object has to be added to database first...");
        }
    }

    public void insert(){
        if(!this.added) {
            String query = "INSERT INTO userAdmin " +
                    "('username', 'password', 'adminType', 'languageCode')" +
                    " VALUES (" +
                    "'" + this.username + "'," +
                    "'" + this.password + "'," +
                    "'" + this.adminType + "'," +
                    "'" + this.languageCode + "'" +
                    ");";
            this.db.update(query);
            ResultSet set = this.db.query("SELECT * from userAdmin order by userID DESC LIMIT 1;");
            try {
                this.userID = set.getInt("userID");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.added = true;
        }else{
            System.out.println("Unable to insert user student, the object is already in the database...");
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public int getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(int languageCode) {
        this.languageCode = languageCode;
    }
}
