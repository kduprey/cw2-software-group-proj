package main;

import main.dataclasses.UserStudent;

public class Main {

    public static void main(String args[]){
        String dbpath = "/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/softTechDB.db";
        Database db = new Database(dbpath);
        DatabaseInitiator.baseInit(db.getConnection());

        UserStudent student = new UserStudent(db,"armextos", "afewrfasdf123", "A1", "English", 1, 1);
        student.insert();
        student.setPassword("Pass123");
        student.update();
        student.delete();

//        UserAdmin admin = new UserAdmin(db,"vovik", "pass123", "main", 12);
//        admin.insert();
//        admin.setPassword("newPass123");
//        admin.update();
//        admin.delete();

    }

}
