package MiniProjects.BankSim;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;

public class Teller implements Runnable {

    /* === VARIABLES === */
    private static int count = 0;

    /* === ATTRIBUTES === */
    private String name;
    private BlockingQueue<Client> queue;

    /* === CONSTRUCTOR === */
    public Teller(String name, BlockingQueue queue) {
        this.name = assignName();
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlockingQueue getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    /* ===== METHODS ===== */
    @Override
    public void run() {
        try {
            while (true) {
                Client client = queue.take();
                Logger.log(name + " attending: " + client.getName());

                for (String action : client.getActions()) {
                    Thread.ofVirtual().start( () -> {

                        String logTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                        switch (action) {
                            case "deposit" -> Logger.log("[ " + logTime + " ] " + client.getName() + " has deposited money.");
                            case "check" -> Logger.log("[ " + logTime + " ] " + client.getName() + " has checked its balance.");
                            case "retire" -> Logger.log("[ " + logTime + " ] " + client.getName() + " has retired money.");
                            case "web" -> new WebQuery(client).run();
                        }

                        // Acts as a delay between actions
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " has been interrupted.");
        }
    }

    public String assignName() {
        String name = "Teller " + count;
        count++;
        return name;
    }
}
