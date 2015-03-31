public class Food implements Comparable<Food>{    
    private String name;
    private int healthRate;
    private int tasteRate;
    
    public Food(String name, int healthRate, int tasteRate) {
        this.name = name;
        this.healthRate = healthRate;
        this.tasteRate = tasteRate;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHealthRate() {
        return healthRate;
    }
    
    public int getTasteRate() {
        return tasteRate;
    }
    
    @Override
    public String toString() {
        return name + " (" + healthRate + "," + tasteRate + ")";
    }
    
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Food)) return false;
        Food otherFood = (Food)other;
        return this.name.equals(otherFood.getName());
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    @Override
    public int compareTo(Food other) {
        if(!this.name.equals(other.name)) {
            return this.name.compareTo(other.name);
        }
        if(this.getHealthRate() != other.getHealthRate()) {
            return this.getHealthRate() - other.getHealthRate();
        }
        if(this.getTasteRate() != other.getTasteRate()) {
            return this.getTasteRate() - other.getTasteRate();
        }
        return 0;
    }
}