package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import WFC.*;

class DayTest {

    private Day day;
    private Lesson lesson1;
    private Lesson lesson2;
    private Lesson lesson3;

    @BeforeEach
    void SetUp(){
        day = new Day("Monday");
        lesson1 = new Lesson("Bandra", "Spin", 10, "Saturday", 5);
        lesson2 = new Lesson("yash", "Yoga", 12, "Sunday", 10);
        lesson3 = new Lesson("Neymar", "BodySculpt", 14, "Saturday", 2);
    }

    @Test
    void getName() {
        assertEquals("Bandra", day.getName());
    }

    @Test
    void getLessons() {
        assertTrue(day.getLessons().isEmpty());
        day.addLesson(lesson1);
        day.addLesson(lesson2);
        assertFalse(day.getLessons().isEmpty());
        assertEquals(2, day.getLessons().size());
        assertEquals(lesson1, day.getLessons().get(0));
        assertEquals(lesson2, day.getLessons().get(1));
    }

    @Test
    void addLesson() {
        assertTrue(day.getLessons().isEmpty());
        day.addLesson(lesson1);
        assertFalse(day.getLessons().isEmpty());
        assertEquals(1, day.getLessons().size());
        assertEquals(lesson1, day.getLessons().get(0));
    }


    @Test
    void getLessonsByType() {
        assertTrue(day.getLessonsByType("Cardio").isEmpty());
        day.addLesson(lesson1);
        day.addLesson(lesson2);
        assertFalse(day.getLessonsByType("Cardio").isEmpty());
        assertEquals(1, day.getLessonsByType("Cardio").size());
        assertEquals(lesson1, day.getLessonsByType("Cardio").get(0));
    }

    @Test
    void getTotalRevenue() {
        assertEquals(0.0, day.getTotalRevenue());
        day.addLesson(lesson1);
        day.addLesson(lesson2);
        assertEquals(35.0, day.getTotalRevenue());
    }

     void testToString() {
        day.addLesson(lesson1);
        day.addLesson(lesson2);
        assertEquals("Monday:\n- Spin at 10 - Cardio ($20.0 per person)\n- Yoga at 12 - Flexibility ($15.0 per person)\n", day.toString());
    }

}