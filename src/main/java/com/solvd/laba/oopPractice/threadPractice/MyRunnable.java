package com.solvd.laba.oopPractice.threadPractice;

public class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + ": Count " + i);
            try {
                // Adding a short delay to make it easier to observe the interleaving of threads
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
