package MiniProjects.BankSim;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebQuery implements Runnable {
    private final Client client;

    public WebQuery(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            Logger.log("[ " + startTime + " ] " + client.getName() + " started a web search.");

            int latency = (int) (Math.random() * 1000) + 500; // Delay between 1000 - 1500ms
            Thread.sleep(latency);

            String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            Logger.log("[ " + endTime + " ] " + client.getName() + " performed a web search in: "
                    + latency + "ms.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
