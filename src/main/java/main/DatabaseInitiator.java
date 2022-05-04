package main;

import main.dataclasses.Dialogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Anastasiia Mazur
 */
public class DatabaseInitiator {

    public static void initData(Database db){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("dialogues.csv");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            for (String line; (line = reader.readLine()) != null;) {
                if(line.startsWith("Level")) {
                    continue;
                }
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(",")));
                for(int i = 0; i<values.size(); i++){
                    values.set(i, values.get(i).replace("<c>", ",").replace("'", "''"));
                }
                Dialogue dialogue = new Dialogue(db, values.get(1), values.get(2), values.get(4), values.get(3), values.get(0), 1);
                dialogue.insert();

            }
        } catch (IOException e) {
            System.out.println("Unable to initialise database values...");
            throw new RuntimeException(e);
        }

    }

    public static void dropTables(Connection connection){
        ArrayList<String> queries = new ArrayList<>();
        queries.add("DROP TABLE Student;");
        queries.add("DROP TABLE Admin;");
        queries.add("DROP TABLE Teacher;");
        queries.add("DROP TABLE Language;");
        queries.add("DROP TABLE Progress;");
        queries.add("DROP TABLE Practice;");
        queries.add("DROP TABLE Dialogue;");
        queries.add("DROP TABLE Conversation;");
        queries.add("DROP TABLE AdminLangManage;");
        queries.add("DROP TABLE StudentLangChoice;");
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Not able to create a statement...");
            throw new RuntimeException(e);
        }
        for(String query: queries){
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("Failed to execute sql statements...");
                throw new RuntimeException(e);
            }
        }
    }

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
                + "dialogueLevel VARCHAR(10),"
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
