package ConcurrencyTests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadTests {

    public void startThreads() {
        for (int i = 0; i < 100_000; i++) {
            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            Thread thread = new Thread("Thread " + i);
            thread.start();

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("[ " + formattedDateTime + " ] Running: " + thread.getName());
        }
    }

    public void startVirtualThreads() {
        for (int i = 0; i < 1_000_000; i++) {
            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            Runnable runnable = () -> {

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                String threadName = Thread.currentThread().getName();
                System.out.println("[ " + formattedDateTime + " ] Running: " + threadName);
            };

            Thread vThread = Thread.ofVirtual().name("Virtual Thread " + i).start(runnable);

            try {
                vThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startThreadLocal() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread( () -> {
            threadLocal.set("Thread 1");
            String value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(value + " (previously 'Thread1')");
        });

        Thread thread2 = new Thread( () -> {
            threadLocal.set("Thread 2");
            String value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(value + " (previously 'Thread2')");
        });

        thread1.start();
        thread2.start();
    }
}
