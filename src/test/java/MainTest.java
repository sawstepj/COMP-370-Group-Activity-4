import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test1Second() throws InterruptedException {
        String expectedOutput = """
                1
                0
                Time's up!
                """;
        Main.runTimer(1);
        Thread.sleep(1050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test10Seconds() throws InterruptedException {
        String expectedOutput = """
                10
                9
                8
                7
                6
                5
                4
                3
                2
                1
                0
                Time's up!
                """;
        Main.runTimer(10);
        Thread.sleep(10050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
