import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testUserInputNormal() throws InterruptedException {
        Main.userInput(new Scanner("2"));
        String expectedOutput = "Input the number of seconds (> 0): 2\n1\n0\nTime's up!\n";
        Thread.sleep(2050);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testUserInputIsNotInt(){
        assertThrows(NoSuchElementException.class, () -> Main.userInput(new Scanner("test")));
    }

    @Test
    public void testUserInputNegative() {
        assertThrows(NoSuchElementException.class, () -> Main.userInput(new Scanner("-1")));
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
