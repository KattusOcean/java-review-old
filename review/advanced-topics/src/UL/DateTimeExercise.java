package UL;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExercise {
    static void main() {

        // Date and time objects
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant = Instant.now();

        // Prints basic date and time objects
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(instant);

        // Custom format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newDateTime = dateTime.format(formatter);

        // Prints formatted dateTime
        System.out.println(newDateTime);

        // Custom date
        LocalDate date1 = LocalDate.of(2025, 12, 3);
        LocalDateTime dateTime1 = LocalDateTime.of(2025, 12, 3, 12, 0, 30);
        System.out.println(date1);
        System.out.println(dateTime1);

        // Compare dates
        if (date.isBefore(date1)) {
            System.out.println(date + " is earlier than " + date1);
        } else if (date.isAfter(date1)) {
            System.out.println(date1 + " is earlier than " + date);
        } else if (date.isEqual(date1)) {
            System.out.println(date + " and " + date1 + " are the same");
        }
    }
}
