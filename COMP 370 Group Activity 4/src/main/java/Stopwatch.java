import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {

    public static void main(String[] args) {
        /*
        JFrame and JLabel for creating countdown display objects
         */
        JFrame jframe= new JFrame();
        JLabel jlabel = new JLabel();
        jframe.setLayout(new FlowLayout());
        jframe.setBounds(250, 250, 500, 250);

        jframe.add(jlabel);
        jframe.setVisible(true);
    /*
    Set timer object
    */
        Timer timer = new Timer();
        /*
        Set new TimerTask object
         */
        timer.scheduleAtFixedRate(new TimerTask() {
            int time = 45;
            /*
            time in seconds to count down from, need to see how this can be passed as parameter
             */
            public void run() {
                jlabel.setText("Time left: " + time);
                time--;

                if (time < 0) {
                    timer.cancel();
                    jlabel.setText("Time Over!");
                }
            }

        }, 0, 1000);

    }
}
