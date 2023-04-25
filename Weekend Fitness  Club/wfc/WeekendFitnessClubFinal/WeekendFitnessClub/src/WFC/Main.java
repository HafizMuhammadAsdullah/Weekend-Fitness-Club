package WFC;

import java.util.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Create a list of fitness lessons
        List<FitnessLesson> lessons = new ArrayList<>();
        lessons.add(new FitnessLesson("SPIN", 30.0));
        lessons.add(new FitnessLesson("YOGA", 20.0));
        lessons.add(new FitnessLesson("BODYSCULPT", 25.0));
        lessons.add(new FitnessLesson("ZUMBA", 25.0));

        // Create a timetable for 8 weekends
        int numWeekends = 8;
        Timetable timetable = new Timetable();
        for (int i = 1; i <= numWeekends; i++) {
            timetable.addDay(new Day("Saturday"));
            timetable.addDay(new Day("Sunday"));
        }

        // Add lessons to the timetable
        int lessonCount = 0;
        for (Day day : timetable.getDays()) {
            for (FitnessLesson lesson : lessons) {
                if (lessonCount >= 4) {
                    day.addLesson(new Lesson(lesson.getName(), lesson.getType(), 5, lesson.getDay(), lesson.getSpaces()));
                    day.addLesson(new Lesson(lesson.getName(), lesson.getType(), 5, lesson.getDay(), lesson.getSpaces()));
                }
            lessonCount++;
            }
        }

        // Create some customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Marie Bane"));
        customers.add(new Customer("Ryan Holl"));
        customers.add(new Customer("Bob Marley"));
        customers.add(new Customer("Alice Smith"));

        try (// Create a scanner to get user input
        Scanner scanner = new Scanner(System.in)) {
            // Print the menu
            System.out.println("Welcome to the fitness center booking system!");
            System.out.println("Please choose an option:");
            System.out.println("1. View the timetable by day");
            System.out.println("2. View the timetable by fitness type");
            System.out.println("3. Book a lesson");
            System.out.println("4. Change a booking");
            System.out.println("5. Cancel a booking");
            System.out.println("6. Write a review");
            System.out.println("7. Print the timetable");
            System.out.println("8. Print the lessons booked by each customer");
            System.out.println("9. Print the structured report");

            // Get the user's choice
            int choice = scanner.nextInt();

            // Process the user's choice
            switch (choice) {
                case 1:
                    // Print the list of days
                    System.out.println("Please choose a day:");
                    List<Day> days = timetable.getDays();
                    for (int i = 0; i < days.size(); i++) {
                        System.out.println((i + 1) + ". " + days.get(i).getName());
                    }

                    // Get the user's choice of day
                    int dayChoice = scanner.nextInt();
                    Day day = days.get(dayChoice - 1);

                    // Print the lessons on the selected day
                    List<Lesson> lessonsByDay = timetable.getLessonsByDay(day.getName());
                    for (Lesson l : lessonsByDay) {
                        System.out.println(l.getName() + " at " + l.getTime() + " - " + l.getType() + " (" + l.getSpaces() + " spaces available)");
                    }
                    break;
                case 2:
                    // Print the list of fitness types
                    System.out.println("Please choose a fitness type:");
                    List<String> fitnessTypes = new ArrayList<>();
                    for (FitnessLesson l : lessons) {
                        if (!fitnessTypes.contains(l.getType())) {
                            fitnessTypes.add(l.getType());
                        }
                    }
                    for (int i = 0; i < fitnessTypes.size(); i++) {
                        System.out.println((i + 1) + ". " + fitnessTypes.get(i));
                    }

                    // Get the user's choice of fitness type
                    int fitnessTypeChoice = scanner.nextInt();
                    String fitnessType = fitnessTypes.get(fitnessTypeChoice - 1);

                    // Print the lessons of the selected fitness type
                    List<Lesson> lessonsByFitnessType = timetable.getLessonsByType(fitnessType);
                    for (Lesson l : lessonsByFitnessType) {
                        System.out.println(l.getName() + " at " + l.getTime() + " - " + l.getType() + " (" + l.getSpaces() + " spaces available)");
                    }
                    break;
                case 3:
                    // Print the list of customers
                    System.out.println("Please choose a customer:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i).getName());
                    }

                    // Get the user's choice of customer
                    int customerChoice = scanner.nextInt();
                    Customer customer = customers.get(customerChoice - 1);

                    // Print the list of lessons
                    System.out.println("Please choose a lesson:");
                    List<Lesson> lessonsAvailable = timetable.getLessons();
                    for (int i = 0; i < lessonsAvailable.size(); i++) {
                        Lesson lesson = lessonsAvailable.get(i);
                        System.out.println((i + 1) + ". " + lesson.getName() + " at " + lesson.getTime() + " - " + lesson.getType() + " (" + lesson.getSpaces() + " spaces available)");
                    }

                    // Get the user's choice of lesson
                    int lessonChoice = scanner.nextInt();
                    Lesson lesson = lessonsAvailable.get(lessonChoice - 1);

                    // Book the lesson for the customer
                    customer.bookLesson(lesson);
                    System.out.println("Lesson booked successfully!");
                    break;
                case 4:
                    // Print the list of customers
                    System.out.println("Please choose a customer:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i).getName());
                    }

                    // Get the user's choice of customer
                    int customerChoice2 = scanner.nextInt();
                    Customer customer2 = customers.get(customerChoice2 - 1);

                    // Print the list of booked lessons
                    System.out.println("Please choose a lesson to change:");
                    List bookings = customer2.getBookings();
                    for (int i = 0; i < bookings.size(); i++) {
                    Lesson bookedLesson = (Lesson) bookings.get(i);
                    System.out.println((i + 1) + ". " + bookedLesson.getName() + " at " + bookedLesson.getTime() + " - " + bookedLesson.getType());
                    }

                    // Get the user's choice of lesson to change
                    int lessonChoice2 = scanner.nextInt();
                    Lesson oldLesson = (Lesson) bookings.get(lessonChoice2 - 1);

                    // Print the list of available lessons
                    System.out.println("Please choose a new lesson:");
                    List<Lesson> lessonsAvailable2 = timetable.getLessons();
                    for (int i = 0; i < lessonsAvailable2.size(); i++) {
                        Lesson lesson2 = lessonsAvailable2.get(i);
                        if (lesson2.getType().equalsIgnoreCase(oldLesson.getType()) && lesson2.getDay().equalsIgnoreCase(oldLesson.getDay())) {
                            System.out.println((i + 1) + ". " + lesson2.getName() + " at " + lesson2.getTime() + " - " + lesson2.getType() + " (" + lesson2.getSpaces() + " spaces available)");
                        }
                    }

                    // Get the user's choice of new lesson
                    int newLessonChoice = scanner.nextInt();
                    Lesson newLesson = lessonsAvailable2.get(newLessonChoice - 1);

                    // Change the booking for the customer
                    customer2.changeBooking(oldLesson, newLesson);
                    break;
                case 5:
                    // Print the list of customers
                    System.out.println("Please choose a customer:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i).getName());
                    }

                    // Get the user's choice of customer
                    int customerChoice3 = scanner.nextInt();
                    Customer customer3 = customers.get(customerChoice3 - 1);

                    // Print the list of booked lessons
                    System.out.println("Please choose a lesson to cancel:");
                    List<Lesson> bookings2 = customer3.getBookings();
                    for (int i = 0; i < bookings2.size(); i++) {
                        Lesson bookedLesson = bookings2.get(i);
                        System.out.println((i + 1) + ". " + bookedLesson.getName() + " at " + bookedLesson.getTime() + " - " + bookedLesson.getType());
                    }

                    // Get the user's choice of lesson to cancel
                    int lessonChoice3 = scanner.nextInt();
                    Lesson lesson3 = bookings2.get(lessonChoice3 - 1);

                    // Cancel the booking for the customer
                    customer3.cancelBooking(lesson3);
                    break;
                    case 6:
                    // Print the list of customers
                    System.out.println("Please choose a customer:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i).getName());
                    }
                
                    // Get the user's choice of customer
                    int customerChoice4 = scanner.nextInt();
                    Customer customer4 = customers.get(customerChoice4 - 1);
                
                    // Print the list of booked lessons
                    System.out.println("Please choose a lesson to review:");
                    List<Lesson> bookings3 = customer4.getBookings();
                    if (bookings3.isEmpty()) {
                        System.out.println("No lessons booked for this customer.");
                    } else {
                        for (int i = 0; i < bookings3.size(); i++) {
                            Lesson bookedLesson = bookings3.get(i);
                            System.out.println((i + 1) + ". " + bookedLesson.getName() + " at " + bookedLesson.getTime() + " - " + bookedLesson.getType());
                        }
                
                        // Get the user's choice of lesson to review
                        int lessonChoice4 = scanner.nextInt();
                        Lesson lesson4 = bookings3.get(lessonChoice4 - 1);
                
                        // Check if the lesson has already been reviewed by the customer
                        if (lesson4.hasBeenReviewed()) {
                            System.out.println("You have already reviewed this lesson.");
                        } else {
                            // Get the review and rating from the user
                            System.out.println("Please write a review for the lesson:");
                            String review = scanner.next();
                            System.out.println("Please provide a rating from 1 to 5 (1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied):");
                            int rating = scanner.nextInt();
                
                            // Add the review and rating to the lesson
                            lesson4.addReview(review, rating);
                            System.out.println("Review added successfully!");
                        }
                    }
                    break;
                case 7:
                    timetable.print();
                    break;
                case 8:
                    for (Customer c : customers) {
                        c.printBookings();
                    }
                    break;
                case 9:
                    // Print the report containing the number of customers per lesson on each day, along with the average rating of each lesson
                    System.out.println("Report 1: Number of customers per lesson on each day, along with the average rating of each lesson");
                    for (Day d : timetable.getDays()) {
                    System.out.println(d.getName() + ":");
                    //List lessonsByDay2 = timetable.getLessonsByDay(d.getName());
                    List<Lesson> lessonsByDay2 = d.getLessons();
                    for (Lesson l : lessonsByDay2) {
                        int count = 0;
                        for (Customer c : customers) {
                            if (c.getBookings().contains(l)) {
                                count++;
                            }
                        }
                        System.out.println("- " + l.getName() + " (" + l.getType() + "): " + count + " customers, average rating " + l.getAverageRating());
                        }
                    }

                    // Print the report containing the total revenue for each fitness type
                    System.out.println("Report 2: Total revenue for each fitness type");
                    Map<String, Double> revenueByFitnessType = new HashMap<>();
                    for (FitnessLesson l : lessons) {
                        double revenue = 0.0;
                        for (Day d : timetable.getDays()) {
                            List<Lesson> lessonsByDay3 = d.getLessons();
                            for (Lesson l2 : lessonsByDay3) {
                                if (l2.getName().equalsIgnoreCase(l.getName())) {
                                    revenue += l2.getTotalPrice();
                                }
                            }
                        }
                        if (revenueByFitnessType.containsKey(l.getType())) {
                            revenueByFitnessType.put(l.getType(), revenueByFitnessType.get(l.getType()) + revenue);
                        } else {
                            revenueByFitnessType.put(l.getType(), revenue);
                        }
                    }
                    for (String type : revenueByFitnessType.keySet()) {
                        System.out.println("- " + type + ": $" + revenueByFitnessType.get(type));
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
                    }
        }
        
    }
}