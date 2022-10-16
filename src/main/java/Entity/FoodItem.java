package Entity;

/**
 *
 * @author Pham Nhat Quang
 */
public class FoodItem {
    String name;
    double totalWeight;
    double totalCal;
    double proteinWeight;
    double fatWeight;
    double carbWeight;

    public FoodItem(String name, double totalWeight, double totalCal, double proteinWeight, double fatWeight, double carbWeight) {
        this.name = name;
        this.totalWeight = totalWeight;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    public double getProteinWeight() {
        return proteinWeight;
    }

    public void setProteinWeight(double proteinWeight) {
        this.proteinWeight = proteinWeight;
    }

    public double getFatWeight() {
        return fatWeight;
    }

    public void setFatWeight(double fatWeight) {
        this.fatWeight = fatWeight;
    }

    public double getCarbWeight() {
        return carbWeight;
    }

    public void setCarbWeight(double carbWeight) {
        this.carbWeight = carbWeight;
    }

    @Override
    public String toString() {
        return "FoodItem{" + "name=" + name + ", totalWeight=" + totalWeight + ", totalCal=" + totalCal + ", proteinWeight=" + proteinWeight + ", fatWeight=" + fatWeight + ", carbWeight=" + carbWeight + '}';
    }
    
    
    
    
    
}
