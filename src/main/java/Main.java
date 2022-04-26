import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        userInput(new Scanner (System.in));
    }

    public static int getInt(Scanner keyboard){
        System.out.print("Input the number of seconds: ");
        //to handle if value is not integer
        while(!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("Not an integer, try again");
        }
        return keyboard.nextInt();
    }

    public static void userInput(Scanner keyboard) {
        Scanner keyboard = new Scanner(System.in);
        int input = getInt(keyboard);
        //to handle accidental or malicious negative values
        while (input < 0) {
            System.out.println("Input the number of seconds (>= 0): ");
            input = keyboard.nextInt();
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
