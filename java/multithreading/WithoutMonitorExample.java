package multithreading;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class WithoutMonitorExample
{
    public static void main(String[] args)
    {
        MyData myData = new MyData();

        MyThread1 myThread1 = new MyThread1(myData);
        MyThread2 myThread2 = new MyThread2(myData);

        LocalDateTime timestart = LocalDateTime.now();
        System.out.println("Time start: " + timestart);

        myThread1.start();
        myThread2.start();

        LocalDateTime timeEnd = LocalDateTime.now();
        System.out.println("\nTime End: " + timeEnd);


        System.out.println("Duration: " + Duration.between(timestart, timeEnd));

    }
}
