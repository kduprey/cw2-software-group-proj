package main;

import main.dataclasses.Admin;
import main.dataclasses.Student;

import javax.xml.crypto.Data;
import java.sql.*;

/**
 *
 * @author Anastasiia Mazur
 */
public class Database {
    private String db_url;
    private Connection connection;

    public Database(){
        this("/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/softTechDB.db");
    }

    public Database(String dbpath){
        this.db_url = "jdbc:sqlite:" + dbpath;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Lite module can not be found.");
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(this.db_url);
        } catch (SQLException e) {
            System.out.println("Not able to connect to db...");
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
    
    public ResultSet query(String query){
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Not able to create an update statement...");
            throw new RuntimeException(e);
        }
        ResultSet set;
        try {
            set = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute sql query...");
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public void update(String query){
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Not able to create an update statement...");
            throw new RuntimeException(e);
        }

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute sql query...");
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
