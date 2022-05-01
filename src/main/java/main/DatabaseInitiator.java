package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseInitiator {

    public static void baseInit(Connection connection){
        ArrayList<String> queries = new ArrayList<>();
        queries.add("CREATE TABLE IF NOT EXISTS userStudent ("
                + "userID INTEGER PRIMARY KEY,"
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
        queries.add("CREATE TABLE IF NOT EXISTS dialogue ("
                + "dialogueCode INT PRIMARY KEY,"
                + "dialogueContext VARCHAR(100),"
                + "dialogueSubContext VARCHAR(100),"
                + "dialogueKeyVocab VARCHAR(200),"
                + "dialogueGrammarStructure VARCHAR(150),"
                + "languageCode INT);");
        queries.add("CREATE TABLE IF NOT EXISTS conversation ("
                + "convCode INT PRIMARY KEY,"
                + "convText VARCHAR(500),"
                + "convTranslation VARCHAR(150),"
                + "dialogueCode INT);");

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
}
