package main;

import main.dataclasses.*;

public class Main {

    public static void main(String args[]){
        String dbpath = "/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/softTechDB.db";
        Database db = new Database(dbpath);
        DatabaseInitiator.baseInit(db.getConnection());

//        Admin admin = new Admin(db,"vovik", "pass123", "main", 12);
//        admin.insert();
//        admin.setAdminPassword("newPass123");
//        admin.update();
//        admin.delete();

//        AdminLangManage manage = new AdminLangManage(db, 1, 2);
//        manage.insert();
//        manage.update(134, manage.getLanguageId());
//        manage.delete();

//        Conversation conversation = new Conversation(db, "hello friend", "privet dryg", 1);
//        conversation.insert();
//        conversation.setConversationTranslation("pruvit dryge");
//        conversation.update();
//        conversation.delete();

//        Dialogue dialogue = new Dialogue(db,
//                "some context",
//                "some sub context",
//                "vocab",
//                "structure",
//                1);
//        dialogue.insert();
//        dialogue.setLanguageId(23);
//        dialogue.update();
//        dialogue.delete();

//        Language language = new Language(db, "Ukrainian", "A1");
//        language.insert();
//        language.setLanguageLevel("B1");
//        language.update();
//        language.delete();

//        Practice practice = new Practice(db, 1, 2, 3, "19/04/2022-06:30:00");
//        practice.insert();
//        practice.update(practice.getTeacherId(), practice.getDialogueId(), 123, practice.getPracticeDateTime());
//        practice.delete();

//        Progress progress = new Progress(db,
//                "task_frequency",
//                "performance: bad",
//                "topics",
//                1,
//                2);
//        progress.insert();
//        progress.setProgressTopics("History of Royal Family");
//        progress.update();
//        progress.delete();

//        Student student = new Student(db, "username", "pass123", "A2", "English", -1, 2);
//        student.insert();
//        student.setStudentPassword("123456");
//        student.update();
//        student.delete();

//        StudentLangChoice choice = new StudentLangChoice(db, 1, 2);
//        choice.insert();
//        choice.update(choice.getStudentId(), 123);
//        choice.delete();

        Teacher teacher = new Teacher(db, "mrgrigorovich", "password", "English");
        teacher.insert();
        teacher.setTeacherPassword("ihatemystudents");
        teacher.update();
        teacher.delete();

    }

}
