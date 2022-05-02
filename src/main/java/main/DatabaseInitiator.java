package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anastasiia Mazur
 */
public class DatabaseInitiator {

    public static void baseInit(Connection connection){
        ArrayList<String> queries = new ArrayList<>();

        queries.add("CREATE TABLE IF NOT EXISTS Student ("
                + "studentId INTEGER PRIMARY KEY,"
                + "studentUsername VARCHAR(30),"
                + "studentPassword VARCHAR(30),"
                + "studentLevel VARCHAR(2),"
                + "studentLanguages VARCHAR(100),"
                + "studentPracticeId INT,"
                + "languageId INT);");

        queries.add("CREATE TABLE IF NOT EXISTS Admin ("
                + "adminId INTEGER PRIMARY KEY,"
                + "adminUsername VARCHAR(30),"
                + "adminPassword VARCHAR(30),"
                + "adminType VARCHAR(20),"
                + "languageId INT) ;");

        queries.add("CREATE TABLE IF NOT EXISTS Teacher ("
                + "teacherId INTEGER PRIMARY KEY,"
                + "teacherUsername VARCHAR(30),"
                + "teacherPassword VARCHAR(30),"
                + "teacherLanguage VARCHAR(100));");

        queries.add("CREATE TABLE IF NOT EXISTS Language ("
                + "languageID INTEGER PRIMARY KEY,"
                + "languageName VARCHAR(30),"
                + "languageLevel VARCHAR(2));");

        queries.add("CREATE TABLE IF NOT EXISTS Progress ("
                + "progressId INTEGER PRIMARY KEY,"
                + "progressTaskFrequency VARCHAR(30),"
                + "progressStudentPerformance VARCHAR(30),"
                + "progressTopics VARCHAR(30),"
                + "studentId INT,"
                + "teacherId INT);");

        queries.add("CREATE TABLE IF NOT EXISTS Practice ("
                + "practiceDateTime VARCHAR(30),"
                + "dialogueId INT,"
                + "studentId INT,"
                + "teacherID INT);");

        queries.add("CREATE TABLE IF NOT EXISTS Dialogue ("
                + "dialogueId INTEGER PRIMARY KEY,"
                + "dialogueContext VARCHAR(100),"
                + "dialogueSubContext VARCHAR(100),"
                + "dialogueKeyVocab VARCHAR(200),"
                + "dialogueGrammarStructure VARCHAR(150),"
                + "languageId INT);");

        queries.add("CREATE TABLE IF NOT EXISTS Conversation ("
                + "conversationId INTEGER PRIMARY KEY,"
                + "conversationText VARCHAR(500),"
                + "conversationTranslation VARCHAR(150),"
                + "dialogueId INT);");

        queries.add("CREATE TABLE IF NOT EXISTS AdminLangManage ("
                + "adminId INT,"
                + "languageId INT);");

        queries.add("CREATE TABLE IF NOT EXISTS StudentLangChoice ("
                + "studentId INT,"
                + "languageId INT);");

        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Not able to create a statement...");
            throw new RuntimeException(e);
        }
        for(String query: queries){
//            System.out.println(query);
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("Failed to execute sql statements...");
                throw new RuntimeException(e);
            }
        }
    }
}
