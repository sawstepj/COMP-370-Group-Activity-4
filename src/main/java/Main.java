import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        System.out.print("Input the number of seconds: ");
        if (keyboard.hasNextInt()) {
            input = keyboard.nextInt();
        }
        runTimer(input);
    }

    public static void runTimer(int seconds) {
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
