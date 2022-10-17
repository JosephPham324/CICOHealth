package Entity;

/**
 *
 * @author Pham Nhat Quang
 */
public class ExerciseType {
    private int exerciseID;
    private String exerciseName;
    private String description;
    private double calPerHour;

    public ExerciseType(int exerciseID, String exerciseName, String description, double calPerHour) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.description = description;
        this.calPerHour = calPerHour;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalPerHour() {
        return calPerHour;
    }

    public void setCalPerHour(double calPerHour) {
        this.calPerHour = calPerHour;
    }

    
    
    
}
