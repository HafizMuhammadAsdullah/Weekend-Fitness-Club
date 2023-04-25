package WFC;

import java.util.*;

public class Day {

    private String name;
    private List<Lesson> lessons;
    
    public Day(String name) {
        this.name = name;
        this.lessons = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Lesson> getLessons() {
        return lessons;
    }
    
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
    
    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }
    
    public List<Lesson> getLessonsByType(String type) {
        List<Lesson> result = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getType().equals(type)) {
                result.add(lesson);
            }
        }
        return result;
    }
    
    public int getNumCustomers() {
        int result = 0;
        for (Lesson lesson : lessons) {
            result += lesson.getNumCustomers();
        }
        return result;
    }
    
    public double getTotalRevenue() {
        double result = 0.0;
        for (Lesson lesson : lessons) {
            result += lesson.getTotalPrice();
        }
        return result;
    }
    
    public double getAverageRating() {
        double result = 0.0;
        int count = 0;
        for (Lesson lesson : lessons) {
            result += lesson.getAverageRating();
            count++;
        }
        return count > 0 ? result / count : 0.0;
    }
}
