package WFC;

import java.util.*;

public class Timetable {
    private List<Day> days;
    
    public Timetable() {
        this.days = new ArrayList<>();
    }
    
    public void addDay(Day day) {
        this.days.add(day);
    }
    
    public List<Day> getDays() {
        return this.days;
    }

    public List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        for (Day day : this.days) {
            lessons.addAll(day.getLessons());
        }
        return lessons;
    }
    
    public List<Lesson> getLessonsByDay(String day) {
        List<Lesson> lessons = new ArrayList<>();
        for (Day d : days) {
        if (d.getName().equalsIgnoreCase(day)) {
            lessons.addAll(d.getLessons());
        }
    }
        return lessons;
    }
    
    public List<Lesson> getLessonsByType(String type) {
        List<Lesson> lessons = new ArrayList<>();
        for (Day day : this.days) {
            for (Lesson lesson : day.getLessons()) {
                if (lesson.getName().equalsIgnoreCase(type)) {
                    lessons.add(lesson);
                }
            }
        }
        return lessons;
    }

    public Lesson getLessonByName(String name) {
        List<Lesson> lessons = new ArrayList<>();
        for (Day day : this.days) {
            for (Lesson lesson : day.getLessons()) {
                if (lesson.getName().equals(name)) {
                    lessons.add(lesson);
                }
            }
        }
        return lessons.get(0);
    }

    public void print() {
        for (Day day : days) {
            System.out.println(day.getName() + " lessons: ");
            System.out.println("-------------");
            List<Lesson> lessons = getLessonsByDay(day.getName());
            if (!lessons.isEmpty()) {
                for (Lesson lesson : lessons) {
                    System.out.println(lesson.getName() + " at " + lesson.getTime() + " - " + lesson.getType());
                }
            } else {
                System.out.println("No lessons found.");
            }
        }
    }
    
    public void printReports() {
        // Calculate the number of customers and the average rating per lesson on each day
        Map<String, Map<String, List<Integer>>> dayReports = new HashMap<>();
        for (Day day : this.days) {
            Map<String, List<Integer>> lessonReports = new HashMap<>();
            for (Lesson lesson : day.getLessons()) {
                List<Integer> ratings = lesson.getRatings();
                if (!ratings.isEmpty()) {
                    lessonReports.put(lesson.getName(), ratings);
                }
            }
            if (!lessonReports.isEmpty()) {
                dayReports.put(day.getName(), lessonReports);
            }
        }
        System.out.println("Report 1: Number of customers and average rating per lesson on each day:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry<String, Map<String, List<Integer>>> dayReport : dayReports.entrySet()) {
            System.out.println(dayReport.getKey() + ":");
            for (Map.Entry<String, List<Integer>> lessonReport : dayReport.getValue().entrySet()) {
                double avgRating = lessonReport.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0);
                System.out.println("- " + lessonReport.getKey() + ": " + lessonReport.getValue().size() + " customers, average rating: " + avgRating);
            }
        }
        
        // Calculate the type of fitness lessons which has generated the highest income
        Map<String, Double> typeIncomes = new HashMap<>();
        for (Day day : this.days) {
            for (Lesson lesson : day.getLessons()) {
                double price = lesson.getPrice();
                if (price > 0.0) {
                    typeIncomes.put(lesson.getName(), typeIncomes.getOrDefault(lesson.getName(), 0.0) + price);
                }
            }
        }
        System.out.println("Report 2: Type of fitness lessons which has generated the highest income:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        double maxIncome = 0.0;
        String maxIncomeType = "";
        for (Map.Entry<String, Double> typeIncome : typeIncomes.entrySet()) {
            if (typeIncome.getValue() > maxIncome) {
                maxIncome = typeIncome.getValue();
                maxIncomeType = typeIncome.getKey();
            }
        }
        System.out.println(maxIncomeType);
    }

}

