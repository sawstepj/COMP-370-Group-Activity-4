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
    //the \n is to fix next line issues with Linux vs Windows
    public void assertUserInputNegative() throws InterruptedException {
        Main.userInput(new Scanner("-1 2"));
        String expectedOutput = "Input the number of seconds: Input the number of seconds (>= 0): \n2\n1\n0\nTime's up!\n";
        Thread.sleep(2050);
        assertEquals(expectedOutput, outContent.toString());
        
    }

    @Test
    public void assertUserInputNormal() throws InterruptedException {
        Main.userInput(new Scanner("2 3"));
        String expectedOutput = "Input the number of seconds: 2\n1\n0\nTime's up!\n";
        Thread.sleep(2050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test0Second() throws InterruptedException {
        String expectedOutput = "0\nTime's up!\n";
        Main.runTimer(0);
        Thread.sleep(50);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test1Second() throws InterruptedException {
        String expectedOutput = "1\n0\nTime's up!\n";
        Main.runTimer(1);
        Thread.sleep(1050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test5Seconds() throws InterruptedException {
        String expectedOutput = "5\n4\n3\n2\n1\n0\nTime's up!\n";
        Main.runTimer(5);
        Thread.sleep(5050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void test10Seconds() throws InterruptedException {
        String expectedOutput = "10\n9\n8\n7\n6\n5\n4\n3\n2\n1\n0\nTime's up!\n";
        Main.runTimer(10);
        Thread.sleep(10050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
