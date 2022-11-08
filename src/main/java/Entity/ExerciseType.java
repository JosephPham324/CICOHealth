package Entity;

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
public class ExerciseType {
    private int exerciseID;         //ID of exercise
    private String exerciseName;    //Name of exercise
    private double calPerHour;      //Calorie in an hour
    private String description;     //Description of exercise

    /**
     * Type of exercise
     * @param exerciseID ID of exercise
     * @param exerciseName Name of exercise
     */
    public ExerciseType(int exerciseID, String exerciseName) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
    }

    /**
     * Type of exercise
     * @param exerciseID ID of exercise
     * @param exerciseName Name of exercise
     * @param calPerHour Calorie in an hour
     * @param description Description of exercise
     */
    public ExerciseType(int exerciseID, String exerciseName, double calPerHour, String description) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.calPerHour = calPerHour;
        this.description = description;
    }

    /**
     * Get exercise ID
     * @return exerciseID ID of exercise
     */
    public int getExerciseID() {
        return exerciseID;
    }

    /**
     * Set exercise ID
     * @param exerciseID ID of exercise
     */
    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    /**
     * Get name of exercise
     * @return exerciseName name of exercise
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     *Set exercise name
     * @param exerciseName name of exercise
     */
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    /**
     * Get calorie in an hour
     * @return calPerHour calorie in an hour
     */
    public double getCalPerHour() {
        return calPerHour;
    }

    /**
     * Set calorie in an hour
     * @param calPerHour calorie in an hour
     */
    public void setCalPerHour(double calPerHour) {
        this.calPerHour = calPerHour;
    }

    /**
     * Get description
     * @return description description of exercise
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     * @param description description of exercise
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * To string
     * @return ExerciseType
     */
    @Override
    public String toString() {
        return "ExerciseType{" + "exerciseID=" + exerciseID + ", exerciseName=" + exerciseName + ", calPerHour=" + calPerHour + ", description=" + description + '}';
    }
    
    

    
    
    
}
