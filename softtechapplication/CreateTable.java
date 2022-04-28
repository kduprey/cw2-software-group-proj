/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softtechapplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lina_
 */
public class CreateTable {
    
    public static void main(String[] args) {
        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        String createString1;
        String createString2;
        String createString3;
        String createString4;
        String createString5;
        String createString6;
        
        //Creating the database tables
        //Cant figure out how to code the foreign keys
        
        createString1 = "CREATE TABLE if not exists userStudent (\n" 
                + "            userID     INT      PRIMARY KEY,\n"
                + "            username     VARCHAR (30) ,\n"
                + "            password  VARCHAR (30),\n"
                + "            studentLevel  VARCHAR (2),\n"
                + "            studentLanguages  VARCHAR (100),\n"
                + "            studentPracticeID  INT ,\n"
                + "            languageCode  INT \n" + ") ;";
        
        createString2 = "CREATE TABLE if not exists userAdmin (\n" 
                + "            userID     INT      PRIMARY KEY,\n"
                + "            username     VARCHAR (30) ,\n"
                + "            password  VARCHAR (30),\n"
                + "            adminType  VARCHAR (20),\n"
                + "            languageCode  INT \n" + ") ;";
        
        createString3 = "CREATE TABLE if not exists userTeacher (\n" 
                + "            userID     INT      PRIMARY KEY,\n"
                + "            username     VARCHAR (30) ,\n"
                + "            password  VARCHAR (30),\n"
                + "            spokenLanguage  VARCHAR (100)\n" + ") ;";
        
        createString4 = "CREATE TABLE if not exists language (\n" 
                + "            languageCode     INT      PRIMARY KEY,\n"
                + "            languageName     VARCHAR (30) ,\n"
                + "            languageLevel  VARCHAR (2)\n" + ") ;";
        
         createString5 = "CREATE TABLE if not exists progress (\n" 
                + "            progressCode     INT      PRIMARY KEY,\n"
                + "            taskFrequency     VARCHAR (30) ,\n"
                + "            studentPerformance     VARCHAR (30) ,\n"
                + "            topics     VARCHAR (30) ,\n"
                + "            studentID  INT  ,\n"
                + "            teacherID  INT \n" + ") ;";
                //+ "                    FOREIGN KEY (studentID) REFERENCES userStudent(userID)";
         
         createString6 = "CREATE TABLE if not exists practice (\n" 
                + "            dateTimePractice     DATETIME      PRIMARY KEY,\n"
                + "            dialogueCode     INT  ,\n"
                + "            studentUserID     INT  ,\n"
                + "            teacherUserID  INT   \n" + ") ;";
        
                
        
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString1);
            stmt.executeUpdate(createString2);
            stmt.executeUpdate(createString3);
            stmt.executeUpdate(createString4);
            stmt.executeUpdate(createString5);
            stmt.executeUpdate(createString6);
          
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
                
        
        
        
    }
    
}
