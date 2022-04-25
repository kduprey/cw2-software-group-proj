/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softtechapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lina_
 */
public class databaseCrud {
    
   
     public static void insertUserStudent(Integer userID, String username, String password, String level, String languages, String practiceID, String langCode) {

        Connection con = ConnectToDB.getConnection();
        Statement stmt = null;
        
        Integer studentID = userID;
        String studentUsername = username;
        String studentPassword = password;
        String studentLevel = level;
        String studentLanguages = languages;
        String studentPracticeID = practiceID;
        String studentLangCode = langCode;
        
        String sqlString = "INSERT INTO userStudent (userID, username, password, studentLevel, studentLanguages, studentPracticeID, languageCode) VALUES ('" + studentID + "'," + studentUsername + "," + studentPassword + ",'" + studentLevel + ",'" + studentLanguages + ",'" + studentPracticeID + ",'" + studentLangCode + "')";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
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
     
     
        public static void insertUserAdmin(Integer userID, String username, String password, String type, Integer langCode) {

        Connection con = ConnectToDB.getConnection();
        Statement stmt = null;
        
        Integer adminID = userID;
        String adminUsername = username;
        String adminPassword = password;
        String adminType = type;
        Integer adminLangCode = langCode;
        
        String sqlString = "INSERT INTO userAdmin (userID, username, password, adminType, languageCode) VALUES ('" + adminID + "'," + adminUsername + "," + adminPassword + ",'" + adminType + ",'" + adminLangCode + "')";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
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
        
    
    public static void insertUserTeacher(Integer userID, String username, String password, String language) {

        Connection con = ConnectToDB.getConnection();
        Statement stmt = null;
        
        Integer teacherID = userID;
        String teacherUsername = username;
        String teacherPassword = password;
        String teacherLang = language;
        
        String sqlString = "INSERT INTO userTeacher (userID, username, password, spokenLanguage) VALUES ('" + teacherID + "'," + teacherUsername + "," + teacherPassword + ",'" + teacherLang + "')";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
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
         
         
        public static void delUser(int userID, String tableSelection) {

        Connection con = ConnectToDB.getConnection();
        Statement stmt = null;
        String sqlString = "DELETE from " + tableSelection + " WHERE userID=" + userID;
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
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

         
     public static void showAll(String tableSelection) {
        Connection con = ConnectToDB.getConnection();
        Statement stmt = null;
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from " + tableSelection);        

            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + rs.getObject(i));
                }

                System.out.println("");
            }

            rs.close();
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
      public static void main(String[] args) {
        insertUserAdmin(21, "username", "password", "TypeA",3);
        //showAll("userStudent");
        //delUser( ,userStudent);
        showAll("userAdmin");
    }    

     
}


