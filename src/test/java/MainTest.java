import java.io.*;
import java.util.Scanner;


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
    public void assertGetIntNotNull(){
        // To test before to make sure object is not null?
        int answer = Main.getInt(new Scanner("1"));
        assertEquals(1, answer);

        answer = Main.getInt(new Scanner("-1"));
        assertEquals(-1, answer);

        answer = Main.getInt(new Scanner("0"));
        assertEquals(0, answer);

        answer = Main.getInt(new Scanner("zero 1 two"));
        assertEquals(1, answer);
    }

    @Test
    //the \r is to fix line issues with Windows OS
    public void assertUserInputNegative() throws InterruptedException {
        Main.userInput(new Scanner("-1 2"));
        String expectedOutput = """
                Input the number of seconds: Input the number of seconds (>= 0): 
                2
                1
                0
                Time's up!
                """;
        Thread.sleep(2050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void assertUserInputNormal() throws InterruptedException {
        Main.userInput(new Scanner("2 3"));
        String expectedOutput = """
                Input the number of seconds: 2\r
                1\r
                0\r
                Time's up!\r
                """;
        Thread.sleep(2050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test0Second() throws InterruptedException {
        String expectedOutput = """
                0\r
                Time's up!\r
                """;
        Main.runTimer(0);
        Thread.sleep(50);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test1Second() throws InterruptedException {
        String expectedOutput = """
                1\r
                1\r
                0\r
                Time's up!\r
                """;
        Main.runTimer(1);
        Thread.sleep(1050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test5Seconds() throws InterruptedException {
        String expectedOutput = """
                5\r
                4\r
                3\r
                2\r
                1\r
                0\r
                Time's up!\r
                """;
        Main.runTimer(5);
        Thread.sleep(5050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test10Seconds() throws InterruptedException {
        String expectedOutput = """
                10\r
                9\r
                8\r
                7\r
                6\r
                5\r
                4\r
                3\r
                2\r
                1\r
                0\r
                Time's up!\r
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
