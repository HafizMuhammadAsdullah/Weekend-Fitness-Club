package WFC;

import java.util.*;

public class Lesson {

    private String name;
    private String type;
    private double price;
    private List<Customer> customers;
    private List<Integer> ratings;
    private String day; 
    private String time;
    private List<String> reviews;
    private int spaces;
    
    public Lesson(String name, String type, double price,  String day, int spaces) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.customers = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.day = day;
        this.spaces = spaces;
        //this.time = time;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        if (time != null) {
            return time.substring(0, 5);
        } else {
            return "";
        }
    }

    public int getAvailableSpaces() {
        return 5 - customers.size();
    }


    public boolean addCustomer(Customer customer) {
        if (customers.size() < 5) {
            customers.add(customer);
            return true;
        }
        return false;
    }
    
    public boolean removeCustomer(Customer customer) {
        return customers.remove(customer);
    }
    
    public void addRating(int rating) {
        ratings.add(rating);
    }

    // addReview() 
    public void addReview(String review, int rating) {
        reviews.add(review);
        ratings.add(rating);
    }
    
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        } else {
            int sum = 0;
            for (int rating : ratings) {
                sum += rating;
            }
            return (double) sum / ratings.size();
        }
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public int getNumCustomers() {
        return customers.size();
    }

    public double getTotalPrice() {
        return price * customers.size();
    }
    
    public double getPrice() {
        return price;
    }
    
   
    public String toString() {
        return name + " (" + type + ") - $" + price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getDay() {
        if (day != null) {
            return day.substring(0, 3);
        } else {
            return "";
        }
    }

    // getSpaces() method
    public int getSpaces() {
        return spaces;
    }

    // cancelSpace() method
    public void cancelSpace() {
        if (spaces < 10) {
            spaces++;
        }
    }

    // bookSpace() method
    public boolean bookSpace() {
        if (spaces > 0) {
            spaces--;
            return true;
        } else {
            return false;
        }
        
    }

    public boolean hasBeenReviewed() {
       if (reviews.isEmpty()) {
           return false;
       } else {
           return true;
       }
    }

}
