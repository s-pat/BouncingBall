
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.Timer;


public class BouncingDriver {

    private static Bouncer bouncer;
    private static int delay = 10;
    private static ExecutorService executor;
    private static int height = 400;
    private static Timer timer;
    private static int width = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Concurrent Bouncing Ball");
        BouncingDriver.bouncer = new Bouncer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(BouncingDriver.bouncer.getBall());
        frame.setSize(BouncingDriver.width, BouncingDriver.height);
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
                BouncingDriver.timer.start();
            }
        });

        BouncingDriver.executor = Executors.newCachedThreadPool();
        BouncingDriver.timer = new Timer(BouncingDriver.delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BouncingDriver.executor.execute(BouncingDriver.bouncer);
            }

        });
    }

}
