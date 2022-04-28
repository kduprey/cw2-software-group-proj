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
import java.util.Date;

/**
 *
 * @author lina_
 */

//Methods for altering database
public class databaseCrud {
    
   
    //Inserting a new Student user
    public static void insertUserStudent(int userID, String username, String password, String level, String languages, String practiceID, int langCode) {

       Connection con = softtechapplication.ConnectToDB.getConnection();
       Statement stmt = null;

       int studentID = userID;
       String studentUsername = username;
       String studentPassword = password;
       String studentLevel = level;
       String studentLanguages = languages;
       String studentPracticeID = practiceID;
       int studentLangCode = langCode;

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

    //Inserting a new Admin
    public static void insertUserAdmin(int userID, String username, String password, String type, int langCode) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;

        int adminID = userID;
        String adminUsername = username;
        String adminPassword = password;
        String adminType = type;
        int adminLangCode = langCode;

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
        
    //Inserting a new teacher
    public static void insertUserTeacher(int userID, String username, String password, String language) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        
        int teacherID = userID;
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
    
    //Inserting a new language
    public static void insertLanguage(int langCode, String langName, String langLevel) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        
        int code = langCode;
        String name = langName;
        String level = langLevel;
        
        String sqlString = "INSERT INTO language (languageCode, languageName, languageLevel) VALUES ('" + code + "'," + name + ",'" + level + "')";
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
    
    
    //Inserting a new practice
    //Need to find the correct data type for date and time
    public static void insertPractice(Date practice, int dialogueCode, int studentID, int teacherID) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        
        Date dateTime = practice;
        int dCode = dialogueCode;
        int sID = studentID;
        int tID = teacherID;
        
        String sqlString = "INSERT INTO practice (dateTimePractice, dialogueCode, studentUserID, teacherUserID) VALUES ('" + dateTime + "'," + dCode + ",'" + sID + "'," + tID + "')";
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
    
    //Inserting a new progress
    public static void insertProgress(int progCode, String taskFreq, String sPerformance, String topics, int studentID, int teacherID) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        
        int pCdode = progCode;
        String frequency = taskFreq;
        String sPerform = sPerformance;
        String pTopics = topics;
        int sID = studentID;
        int tID = teacherID;
        
        String sqlString = "INSERT INTO progress (progressCode, taskFrequency, studentPerformance, topics, studentID, teacherID) VALUES ('" + progCode + "'," + taskFreq + ",'" + sPerformance + "'," + topics + "'," + sID + "'," + tID + "')";
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
    
    //Amending methods
         
    
    //Deleting a user     
    public static void delUser(int userID, String tableSelection) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
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
    
    //Deleting a language     
    public static void delLanguage(int langCode) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        String sqlString = "DELETE from language WHERE languageCode=" + langCode;
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
    
    //Deleting a practice    
    public static void delPractice(int dialogueCode) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        String sqlString = "DELETE from practice WHERE dialogueCode=" + dialogueCode;
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
    
    //Deleting a progress     
    public static void delProgress(int progCode) {

        Connection con = softtechapplication.ConnectToDB.getConnection();
        Statement stmt = null;
        String sqlString = "DELETE from progress WHERE progressCode=" + progCode;
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

         
    //Displaying all values from a choosen table
    public static void showAll(String tableSelection) {
        
        Connection con = softtechapplication.ConnectToDB.getConnection();
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
          
          //There is an issue with the insert methods!!
          
          
            //insertUserTeacher(21, "username", "password", "English");
            //showAll("userStudent");
            //delUser( ,userStudent);

            insertLanguage(123, "English", "A1");
            showAll("language");
    }    

     
}


