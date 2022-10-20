package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pham Nhat Quang
 */
public class Exercise {

    private Date dateTime;
    private int userID;
    private double duration;
    private double calorie;
    private ExerciseType exerciseType;
    private String dateFormat = "yyyy-MM-dd";
    private String timeFormat = "HH:mm:ss";
    private SimpleDateFormat formatter;

    public Exercise(Date dateTime, int userID, double duration, double calorie, ExerciseType exerciseType) {
        this.dateTime = dateTime;
        this.userID = userID;
        this.duration = duration;
        this.calorie = calorie;
        this.exerciseType = exerciseType;
    }

    public Exercise(Date dateTime, int userID, double duration, double calorie, int exerciseTypeID, String exerciseName) {
        this.dateTime = dateTime;
        this.userID = userID;
        this.duration = duration;
        this.calorie = calorie;
        this.exerciseType = new ExerciseType(exerciseTypeID, exerciseName);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
    
    public String getDate(){
        this.formatter = new SimpleDateFormat(dateFormat);
        
        return formatter.format(this.dateTime);
    }

    public String getTime(){
        this.formatter = new SimpleDateFormat(timeFormat);
        
        return formatter.format(this.dateTime);
    }
    
    public String getName(){
        return this.exerciseType.getExerciseName();
    }
}
