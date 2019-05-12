package com.soft1841.Join;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo  {
    public static void main(String[] args) {
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date( ));
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task1,0,1000);
        timer.schedule(task2,0,500);

    }
}
