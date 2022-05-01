package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private final String db_url = "jdbc:sqlite:/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/softTechDB.db";
    private Connection connection;

    public static void main(String args[]){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Database db = new Database();
    }

    public Database(){
        try {
            connection = DriverManager.getConnection(this.db_url);
        } catch (SQLException e) {
            System.out.println("Not able to connect to db...");
            throw new RuntimeException(e);
        }
        initTables();
    }

    private void initTables(){
        ArrayList<String> queries = new ArrayList<>();
        queries.add("CREATE TABLE IF NOT EXISTS userStudent ("
                + "userID INT PRIMARY KEY,"
                + "username VARCHAR(30),"
                + "password VARCHAR(30),"
                + "studentLevel VARCHAR(2),"
                + "studentLanguages VARCHAR(100),"
                + "studentPracticeID INT,"
                + "languageCode INT);");
        queries.add("CREATE TABLE IF NOT EXISTS userAdmin ("
                + "userID INT PRIMARY KEY,"
                + "username VARCHAR(30),"
                + "password VARCHAR(30),"
                + "adminType VARCHAR(20),"
                + "languageCode INT) ;");
        queries.add("CREATE TABLE IF NOT EXISTS userTeacher ("
                + "userID INT PRIMARY KEY,"
                + "username VARCHAR(30),"
                + "password VARCHAR(30),"
                + "spokenLanguage VARCHAR(100));");
        queries.add("CREATE TABLE IF NOT EXISTS language ("
                + "languageCode INT PRIMARY KEY,"
                + "languageName VARCHAR(30),"
                + "languageLevel VARCHAR(2));");
        queries.add("CREATE TABLE IF NOT EXISTS progress ("
                + "progressCode INT PRIMARY KEY,"
                + "taskFrequency VARCHAR(30),"
                + "studentPerformance VARCHAR(30),"
                + "topics VARCHAR(30),"
                + "studentID INT,"
                + "teacherID INT);");
        queries.add("CREATE TABLE IF NOT EXISTS practice ("
                + "dateTimePractice DATETIME PRIMARY KEY,"
                + "dialogueCode INT,"
                + "studentUserID INT,"
                + "teacherUserID INT);");

        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Not able to create a statement...");
            throw new RuntimeException(e);
        }
        for(String query: queries){
            System.out.println(query);
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("Failed to execute sql statements...");
                throw new RuntimeException(e);
            }
        }

    }

    private void initData(){

    }
}
