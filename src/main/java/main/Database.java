package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String db_url;
    private Connection connection;

    public static void main(String args[]){
        String dbpath = "/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/softTechDB.db";
        Database db = new Database(dbpath);
        DatabaseInitiator.baseInit(db.getConnection());
        UserStudent student = new UserStudent(
                1,
                "archimond",
                "pass123",
                "A1",
                "English",
                1,
                1);
        db.update(student.generateInsertString());
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

    }
}
