package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import WFC.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class TimetableTest {

    @Test
    void addDay() {
        // Create a new timetable
        Timetable timetable = new Timetable();

        // Add a new day to the timetable
        timetable.addDay(new Day("Monday"));

        // Assert that the day was added correctly
        assertEquals(1, timetable.getDays().size());
        assertEquals("Monday", timetable.getDays().get(0).getName());
    }

    @Test
    void getDays() {
    }

    @Test
    void getLessons() {
        // Create a new timetable
        Timetable timetable = new Timetable();

        // Add a new day to the timetable
        Day day = new Day("Monday");
        timetable.addDay(day);

        // Add a new lesson to the day
        FitnessLesson lesson = new FitnessLesson("Yoga", 20.0);
        day.addLesson(new Lesson(lesson.getName(), lesson.getType(), 10, day.getName(), lesson.getSpaces()));

        // Assert that the lesson was added correctly
        assertEquals(1, timetable.getLessons().size());
        assertEquals("Yoga", timetable.getLessons().get(0).getName());
        assertEquals("Monday", timetable.getLessons().get(0).getDay());
    }

    @Test
    void getLessonsByDay() {
        // Create a new timetable
        Timetable timetable = new Timetable();

        // Add some days to the timetable
        Day monday = new Day("Monday");
        Day tuesday = new Day("Tuesday");
        timetable.addDay(monday);
        timetable.addDay(tuesday);

        // Add some lessons to the days
        FitnessLesson yoga = new FitnessLesson("Yoga", 20.0);
        FitnessLesson spin = new FitnessLesson("Spin", 25.0);
        monday.addLesson(new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces()));
        monday.addLesson(new Lesson(spin.getName(), spin.getType(), 10, monday.getName(), spin.getSpaces()));
        tuesday.addLesson(new Lesson(yoga.getName(), yoga.getType(), 10, tuesday.getName(), yoga.getSpaces()));

        // Get the lessons for Monday
        List<Lesson> lessonsByDay = timetable.getLessonsByDay("Monday");

        // Assert that the correct lessons were returned
        assertEquals(2, lessonsByDay.size());
        assertTrue(lessonsByDay.contains(new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces())));
        assertTrue(lessonsByDay.contains(new Lesson(spin.getName(), spin.getType(), 10, monday.getName(), spin.getSpaces())));
        assertFalse(lessonsByDay.contains(new Lesson(yoga.getName(), yoga.getType(), 10, tuesday.getName(), yoga.getSpaces())));
    }

    @Test
    void getLessonsByType() {
        // Create a new timetable
        Timetable timetable = new Timetable();

        // Add some days to the timetable
        Day monday = new Day("Monday");
        Day tuesday = new Day("Tuesday");
        timetable.addDay(monday);
        timetable.addDay(tuesday);

        // Add some lessons to the days
        FitnessLesson yoga = new FitnessLesson("Yoga", 20.0);
        FitnessLesson spin = new FitnessLesson("Spin", 25.0);
        monday.addLesson(new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces()));
        monday.addLesson(new Lesson(spin.getName(), spin.getType(), 10, monday.getName(), spin.getSpaces()));
        tuesday.addLesson(new Lesson(yoga.getName(), yoga.getType(), 10, tuesday.getName(), yoga.getSpaces()));

        // Get the lessons for Yoga
        List<Lesson> lessonsByType = timetable.getLessonsByType("Yoga");

        // Assert that the correct lessons were returned
        assertEquals(2, lessonsByType.size());
        assertTrue(lessonsByType.contains(new Lesson(yoga.getName(), yoga.getType(), 10, monday.getName(), yoga.getSpaces())));
        assertTrue(lessonsByType.contains(new Lesson(yoga.getName(), yoga.getType(), 10, tuesday.getName(), yoga.getSpaces())));
        assertFalse(lessonsByType.contains(new Lesson(spin.getName(), spin.getType(), 10, monday.getName(), spin.getSpaces())));
    }
}