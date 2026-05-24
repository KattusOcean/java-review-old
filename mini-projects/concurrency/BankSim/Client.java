package MiniProjects.BankSim;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Client {

    /* === VARIABLES === */
    private String actionTime;
    private static int count = 0;

    /* === ATTRIBUTES === */
    private String name;
    private double balance;
    private List<String> actions;

    /* === CONSTRUCTOR === */
    public Client(List<String> actions) {
        this.name = assignName();
        this.balance = assignBalance();
        this.actionTime = assignTime();
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    /* ===== METHODS ===== */
    public String assignName() {
        String name = "Client " + count;
        count++;
        return name;
    }

    public double assignBalance() {
        double balance = (double) Math.random() * 5000;
        return balance;
    }

    public String assignTime() {
        String time =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return time;
    }
}
