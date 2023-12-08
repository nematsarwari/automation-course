package com.solvd.laba.oopPractice.threadPractice;

public class RunnableThreadExample {
    public static void main(String[] args) {
        // Create instances of the Runnable class
        MyRunnable myRunnable1 = new MyRunnable("Thread 1");
        MyRunnable myRunnable2 = new MyRunnable("Thread 2");

        // Create Thread instances and pass the Runnable instances to them
        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
