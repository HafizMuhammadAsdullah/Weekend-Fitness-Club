package WFC;

public class FitnessLesson {
    
    private String name;
    private double price;
    private String type;
    private String day;
    private int spaces;
    
    public FitnessLesson(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    // getDay() method 
    public String getDay() {
        return day;
    }

    // getSpaces() method
    public int getSpaces() {
        return spaces;
    }
}
