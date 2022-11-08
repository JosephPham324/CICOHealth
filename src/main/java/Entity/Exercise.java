package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE161130  Nguyen Le Quang Thinh (Leader)
 * CE170036  Pham Nhat Quang
 * CE160464  Nguyen The Lu
 * CE161096  Nguyen Ngoc My Quyen
 * CE161025  Tran Thi Ngoc Hieu
 */
public class Exercise {

    private Date dateTime;                      //Datetime of exercise
    private int userID;                         //ID of user
    private double duration;                    //Duration of exercise
    private double calorie;                     //Calorie of exercise
    private ExerciseType exerciseType;          //Type of exercise
    private String dateFormat = "yyyy-MM-dd";   //Format of date
    private String timeFormat = "HH:mm:ss";     //Format of time
    private SimpleDateFormat formatter;         //Simple date format

    /**
     * Constructor
     * @param dateTime Datetime of exercise
     * @param userID ID of user
     * @param duration Duration of exercise
     * @param calorie Calorie of exercise
     * @param exerciseType Type of exercise
     */
    public Exercise(Date dateTime, int userID, double duration, double calorie, ExerciseType exerciseType) {
        this.dateTime = dateTime;
        this.userID = userID;
        this.duration = duration;
        this.calorie = calorie;
        this.exerciseType = exerciseType;
    }

    /**
     * Constructor
     * @param dateTime Date time of exercise
     * @param userID ID of user
     * @param duration Duration of exercise
     * @param calorie Calorie of exercise
     * @param exerciseTypeID ID of type exercise
     * @param exerciseName Name of exercise
     */
    public Exercise(Date dateTime, int userID, double duration, double calorie, int exerciseTypeID, String exerciseName) {
        this.dateTime = dateTime;
        this.userID = userID;
        this.duration = duration;
        this.calorie = calorie;
        this.exerciseType = new ExerciseType(exerciseTypeID, exerciseName);
    }

    /**
     * Get date time
     * @return dateTime Date time of exercise
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Set date time
     * @param dateTime Date time of exercise
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Get user ID
     * @return userID ID of user
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set user ID
     * @param userID ID of user
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get duration 
     * @return duration duration of exercise
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Set duration
     * @param duration duration of exercise
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Get calorie
     * @return calorie calorie of exercise
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Set calorie 
     * @param calorie calorie of exercise
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    /**
     * Get exercise type
     * @return exerciseType Type of exercise
     */
    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    /**
     * Set exercise type
     * @param exerciseType Type of exercise
     */
    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
    
    /**
     * Get date
     * @return dateTime date time of exercise
     */
    public String getDate(){
        this.formatter = new SimpleDateFormat(dateFormat);
        
        return formatter.format(this.dateTime);
    }

    /**
     * Get time
     * @return dateTime date time of exercise
     */
    public String getTime(){
        this.formatter = new SimpleDateFormat(timeFormat);
        
        return formatter.format(this.dateTime);
    }
    
    /**
     * Get exercise ID
     * @return String getExerciseID
     */
    public String getExerciseID(){
        return this.exerciseType.getExerciseID() + "";
    }
    
    /**
     * Get name
     * @return String getExerciseName
     */
    public String getName(){
        return this.exerciseType.getExerciseName();
    }
}
