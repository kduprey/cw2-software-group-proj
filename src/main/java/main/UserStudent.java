package main;


/**
 *
 * @author Anastasiia Mazur
 */
public class UserStudent {

    private int userId;
    private String username;
    private String password;
    private String studentLevel;
    private String studentLanguages;
    private int studentPracticeID;
    private int languageCode;

    public UserStudent(int userId,
                       String username,
                       String password,
                       String studentLevel,
                       String studentLanguages,
                       int studentPracticeID,
                       int languageCode){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.studentLevel = studentLevel;
        this.studentLanguages = studentLanguages;
        this.studentPracticeID = studentPracticeID;
        this.languageCode = languageCode;
    }

    public String generateUpdateQuery(){
        return "UPDATE userData SET " +
                "username = '"+this.username+"'," +
                "password = '"+this.password+"'," +
                "studentLevel = '"+this.studentLevel+"'," +
                "studentLanguages = '"+this.studentLanguages+"'," +
                "studentPracticeID = '"+this.studentPracticeID+"'," +
                "languageCode = '"+this.languageCode+"'," +
                " WHERE " +
                "userId = '"+this.userId+"'";
    }

    public String generateDeleteQuery(){
        return "DELETE FROM userStudent WHERE userId = '" + this.userId + "';" ;
    }

    public String generateInsertQuery(){
        return "INSERT INTO userStudent " +
                "('username', 'password', 'studentLevel', 'studentLanguages', 'studentPracticeID', 'languageCode')" +
                " VALUES (" +
                "'"+this.username+"'," +
                "'"+this.password+"'," +
                "'"+this.studentLevel+"'," +
                "'"+this.studentLanguages+"'," +
                "'"+this.studentPracticeID+"'," +
                "'"+this.languageCode+"'" +
                ");";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String userLevel) {
        this.studentLevel = userLevel;
    }

    public String getStudentLanguages() {
        return studentLanguages;
    }

    public void setStudentLanguages(String studentLanguages) {
        this.studentLanguages = studentLanguages;
    }

    public int getStudentPracticeID() {
        return studentPracticeID;
    }

    public void setStudentPracticeID(int studentPracticeID) {
        this.studentPracticeID = studentPracticeID;
    }

    public int getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(int languageCode) {
        this.languageCode = languageCode;
    }
}
