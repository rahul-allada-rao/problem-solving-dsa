package multithreading;

import java.time.Duration;
import java.time.LocalDateTime;

public class MonitorExample
{
    public static void main(String[] args)
    {
        MySynchronizedData mySynchronizedData = new MySynchronizedData();

        MyThread1 myThread1 = new MyThread1(mySynchronizedData);
        MyThread2 myThread2 = new MyThread2(mySynchronizedData);

//        LocalDateTime timestart = LocalDateTime.now();
//        System.out.println("Time start: " + timestart);

        myThread1.start();
        myThread2.start();

//        LocalDateTime timeEnd = LocalDateTime.now();
//        System.out.println("\nTime End: " + timeEnd);
//
//
//        System.out.println("Duration: " + Duration.between(timestart, timeEnd));

    }
}
