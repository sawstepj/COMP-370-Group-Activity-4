import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        userInput(new Scanner (System.in));
    }

    public static void userInput(Scanner keyboard) {
        int input = 0;
        while (input <= 0) {
            System.out.print("Input the number of seconds (> 0): ");
            if (!keyboard.hasNextInt()) {
                System.out.println("Please enter a integer. Try again");
                keyboard.nextLine();
            } else {
                input = keyboard.nextInt();
                if (input < 0) {
                    System.out.println("Please enter a number > 0. Try again");
                    keyboard.nextLine();
                }
            }
        }
        runTimer(input);
    }

    public static void runTimer (int seconds){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int time = seconds;

            public void run() {
                System.out.println(time);
                time--;

                if (time < 0) {
                    timer.cancel();
                    System.out.println("Time's up!");
                }
            }
        }, 0, 1000);
    }

}
