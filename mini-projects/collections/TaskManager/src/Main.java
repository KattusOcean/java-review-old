import domain.enums.PriorityLevels;
import domain.enums.ProcessStatus;
import domain.exceptions.InvalidAttributeException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public record Task(int tid, String title, PriorityLevels priority, ProcessStatus status, LocalDateTime createdAt) {}

    static void main() {
        Map<Integer, Task> map = new LinkedHashMap<>();
        Deque<Map<Integer, Task>> taskDeque = new ArrayDeque<>();

        // Menu
        int option, tid = 1000;
        do {
            option = showMenu();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    createTask(tid, map, taskDeque);
                }
                case 2 -> listTasks(taskDeque);
                case 3 -> changeTaskStatus(taskDeque, tid);
                case 4 -> deleteTask(taskDeque);
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
            tid++;
        } while (true);
    }

    public static int showMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Create task");
        System.out.println("2. List tasks");
        System.out.println("3. Change status");
        System.out.println("4. Delete task");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        return sc.nextInt();
    }

    public static void createTask(int tid, Map<Integer, Task> map, Deque<Map<Integer, Task>> taskDeque) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime dateTime = localDateTime.truncatedTo(ChronoUnit.MINUTES);

        String title, priorityInput;
        ProcessStatus status;
        System.out.print("Title: ");
        title = sc.nextLine();
        System.out.print("Priority: ");
        priorityInput = sc.nextLine();

        PriorityLevels priority = null;
        try {
            priority = PriorityLevels.valueOf(priorityInput.toUpperCase());
        } catch (InvalidAttributeException e) {
            System.out.println("Available priorities: HIGH, MEDIUM, LOW");
        }

        status = ProcessStatus.PENDING;

        Task task = new Task(tid, title, priority, status, dateTime);
        map.put(tid, task);
        taskDeque.offer(map);
    }

    public static void listTasks(Deque<Map<Integer, Task>> taskDeque) {
        System.out.println("=== LIST ===");

        // THIS IS AWFULLY COMPLEX AND UNNECESSARY, BUT ITS FOR EDUCATIONAL PURPOSES
        Iterator<Map<Integer, Task>> dequeIterator = taskDeque.iterator();
        while (dequeIterator.hasNext()) {
            Map<Integer, Task> map = dequeIterator.next();

            Iterator<Map.Entry<Integer, Task>> mapIterator = map.entrySet().iterator();
            while (mapIterator.hasNext()) {
                Map.Entry<Integer, Task> entry = mapIterator.next();
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            System.out.println();
        }
    }

    public static void changeTaskStatus(Deque<Map<Integer, Task>> taskDeque, int tid) {
        Map<Integer, Task> map = taskDeque.peekFirst();
        if (map == null) return;

        Task oldTask = map.get(tid);
        if (oldTask == null) return;

        Task updatedTask = new Task(oldTask.tid(), oldTask.title(), oldTask.priority(), oldTask.status(), oldTask.createdAt());
        map.put(tid, updatedTask);
    }

    public static void deleteTask(Deque<Map<Integer, Task>> taskDeque) {
        taskDeque.remove();
    }
}
