package org.clock;
import java.util.Timer;
import java.util.TimerTask;

public class Seconds extends TimerTask {
    private static int i = 0;
    public void run() {
        i++;
    }
    public int getSeconds(){
        return i;
    }
}

//public class Main{
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        TimerTask task = new Seconds();
//        timer.schedule(task, 0, 1000);
//    }
//}
