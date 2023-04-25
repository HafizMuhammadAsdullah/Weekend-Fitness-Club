package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import WFC.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {

    @Test
    void main() {
        // Set up input stream for user input
        String input = "1\n1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        Main.main(new String[]{});

        // Assert that the output is as expected
        String expectedOutput = "Please choose a day:\n1. Saturday\n2. Sunday\nSPIN at 9:00 - Cardio (10 spaces available)\nYOGA at 10:00 - Flexibility (10 spaces available)\nBODYSCULPT at 11:00 - Strength (10 spaces available)\nZUMBA at 12:00 - Cardio (10 spaces available)\n";
        Lesson outContent = null;
        assertEquals(expectedOutput, outContent.toString());
    }
}