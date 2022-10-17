package Entity;

/**
 *
 * @author Pham Nhat Quang
 */
public class ExerciseType {
    private int exerciseID;
    private String exerciseName;
    private double calPerHour;

    public ExerciseType(int exerciseID, String exerciseName, double calPerHour) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
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

    public double getCalPerHour() {
        return calPerHour;
    }

    public void setCalPerHour(double calPerHour) {
        this.calPerHour = calPerHour;
    }
    
    
}
