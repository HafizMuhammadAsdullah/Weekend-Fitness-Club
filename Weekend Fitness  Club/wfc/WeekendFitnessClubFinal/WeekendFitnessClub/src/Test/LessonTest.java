package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import WFC.*;

class LessonTest {

    @Test
    void addReview() {
        // Create a new lesson
        Lesson lesson = new Lesson("Dane", "Yoga", 10, "Saturday", 5);

        // Add a review to the lesson
        lesson.addReview("Great class!", 4);

        // Assert that the review was added correctly
        assertEquals(1, lesson.getReviews().size());
        assertEquals("Great class!", lesson.getReviews().get(0).getBytes());
        assertEquals(4, lesson.getReviews().get(0).getBytes());
    }

    @Test
    void getAverageRating() {
        // Create a new lesson
        Lesson lesson = new Lesson("Dane", "Yoga", 10, "Saturday", 5);

        // Add some reviews to the lesson
        lesson.addReview("Great class!", 4);
        lesson.addReview("Not bad", 3);
        lesson.addReview("Terrible", 1);

        // Assert that the average rating is calculated correctly
        assertEquals(2.67, lesson.getAverageRating(), 0.01);
    }
}