package Entity;

/**
 *
 * @author Pham Nhat Quang
 */
public class ExerciseType {
    private int exerciseID;
    private String exerciseName;
    private double calPerHour;
    private String description;


    public ExerciseType(int exerciseID, String exerciseName) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
    }

    public ExerciseType(int exerciseID, String exerciseName, double calPerHour, String description) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.calPerHour = calPerHour;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExerciseType{" + "exerciseID=" + exerciseID + ", exerciseName=" + exerciseName + ", calPerHour=" + calPerHour + ", description=" + description + '}';
    }
    
    

    
    
    
}
