package main.dataclasses;

import main.Database;

/**
 *
 * @author Anastasiia Mazur
 */
public class Progress {

    private int progressId;
    private String progressTaskFrequency;
    private String progressStudentPerformance;
    private String progressTopics;
    private int studentId;
    private int teacherId;
    private Database db;

    public Progress(Database db,
                    String progressTaskFrequency,
                    String progressStudentPerformance,
                    String progressTopics,
                    int studentId,
                    int teacherId
    ) {
        this.db = db;
        this.progressTaskFrequency = progressTaskFrequency;
        this.progressStudentPerformance = progressStudentPerformance;
        this.progressTopics = progressTopics;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    /*
     GETTERS AND SETTERS
     */

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public String getProgressTaskFrequency() {
        return progressTaskFrequency;
    }

    public void setProgressTaskFrequency(String progressTaskFrequency) {
        this.progressTaskFrequency = progressTaskFrequency;
    }

    public String getProgressStudentPerformance() {
        return progressStudentPerformance;
    }

    public void setProgressStudentPerformance(String progressStudentPerformance) {
        this.progressStudentPerformance = progressStudentPerformance;
    }

    public String getProgressTopics() {
        return progressTopics;
    }

    public void setProgressTopics(String progressTopics) {
        this.progressTopics = progressTopics;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
