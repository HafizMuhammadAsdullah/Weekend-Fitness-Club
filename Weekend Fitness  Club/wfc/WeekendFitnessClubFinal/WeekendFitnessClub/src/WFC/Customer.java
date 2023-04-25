package WFC;

import java.util.*;

public class Customer {

    private String name;
    private List<Lesson> bookings;
    private List<Review> reviews;
    //private List<Lesson> bookedLessons;
    
    public Customer(String name) {
        this.name = name;
        this.bookings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        //this.bookedLessons = new ArrayList<>();
    }

    public Lesson bookLesson(Lesson lesson) {
        if (bookings.contains(lesson)) {
            System.out.println("You have already booked this lesson.");
        } else if (lesson.getSpaces() == 0) {
            System.out.println("Sorry, this lesson is fully booked.");
        } else {
            bookings.add(lesson);
            lesson.bookSpace();
            System.out.println("Lesson booked successfully!");
        }
        return lesson;
    }
    
    public String getName() {
        return name;
    }

    // getBookings() method
    public List<Lesson> getBookings() {
        return bookings;
    }

    public void cancelBooking(Lesson lesson) {
        if (!bookings.contains(lesson)) {
            System.out.println("You have not booked this lesson.");
        } else {
            bookings.remove(lesson);
            lesson.cancelSpace();
            System.out.println("Booking canceled successfully!");
        }
    }

    public void changeBooking(Lesson oldLesson, Lesson newLesson) {
        if (!bookings.contains(oldLesson)) {
            System.out.println("You have not booked this lesson.");
        } else if (newLesson.getSpaces() == 0) {
            System.out.println("Sorry, this lesson is fully booked.");
        } else {
            bookings.remove(oldLesson);
            oldLesson.cancelSpace();
            bookings.add(newLesson);
            newLesson.bookSpace();
            System.out.println("Booking changed successfully!");
        }
    }
    
    public void addReviewRating(Lesson lesson, String review, int rating) {
        if (bookings.contains(lesson)) {
            reviews.add(new Review(lesson.getName(), review, rating));
            lesson.addRating(rating);
            System.out.println("Thank you for your review and rating!");
        } else {
            System.out.println("Sorry, you have not attended this lesson yet.");
        }
    }
    
    public void printBookings() {
        System.out.println(name + "'s bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings.");
        } else {
            for (Lesson lesson : bookings) {
                System.out.println("- " + lesson.toString());
            }
        }
    }
    
    private class Review {
        
        private String lessonName;
        private String review;
        private int rating;
        
        public Review(String lessonName, String review, int rating) {
            this.lessonName = lessonName;
            this.review = review;
            this.rating = rating;
        }
        
        public String getLessonName() {
            return lessonName;
        }
        
        public String getReview() {
            return review;
        }
        
        public int getRating() {
            return rating;
        }
    }
}
