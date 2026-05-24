package MiniProjects.BankSim;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BankSimMain {
    static void main() throws InterruptedException {
        BlockingQueue<Client> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 1_000_000; i++) {
            queue.add(new Client(List.of("deposit", "check", "web", "retire")));
        }

        for (int i = 0; i < 4; i++) {
            Teller teller = new Teller("Teller", queue);
            new Thread(teller).start();
        }

        Teller teller1 = new Teller("t1", queue);
        Teller teller2 = new Teller("t2", queue);

        Thread thread1 = new Thread(teller1);
        Thread thread2 = new Thread(teller2);

        thread1.start();
        thread2.start();
    }
}
