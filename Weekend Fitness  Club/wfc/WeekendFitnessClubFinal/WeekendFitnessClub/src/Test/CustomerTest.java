package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import WFC.*;
class CustomerTest {

    @Test
    void bookLesson() {
        // Create a customer and a lesson
        Customer customer = new Customer("Alice Smith");
        FitnessLesson yoga = new FitnessLesson("Yoga", 20.0);
        Day monday = new Day("Monday");

        // Book the lesson for the customer
        Lesson bookedLesson = customer.bookLesson(new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces()));
    }

    @Test
    void getName() {
    }

    @Test
    void getBookings() {
    }

    @Test
    void cancelBooking() {
        // Create a customer and a lesson
        Customer customer = new Customer("Alice Smith");
        FitnessLesson yoga = new FitnessLesson("Yoga", 20.0);
        Day monday = new Day("Monday");
        Lesson bookedLesson = new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces());
        customer.bookLesson(bookedLesson);

        // Cancel the booking for the customer
        customer.cancelBooking(bookedLesson);

        // Assert that the booking was cancelled successfully
        assertFalse(customer.getBookings().contains(bookedLesson));
    }

    @Test
    void addReviewRating() {
    }
}