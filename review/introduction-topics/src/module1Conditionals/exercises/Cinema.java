package module1Conditionals.exercises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
//        Make a program that calculates the price of movie tickets based on the number of people
//        and the day of the week. The base price of a ticket is 8 euros. On Wednesday (spectator's
//        day), the base price is 5 euros. Thursdays are the couple's day, so admission for two costs 11
//        euros. With the Student card you get a 10% discount.
//
//        For example, if a Thursday, a Group of 6 people buy tickets, the total price would be 33 euros
//        already which are 3 couples; but if it is a group of 7, they will pay 3 more couple tickets 1
//        individual which is 41 euros (33 + 8).
//
//        Example1:
//        ----Sales ticketsmart----
//        No tickets→ 4
//        Day of the week-> Tuesday
//        Student Card-> no
//        TOTAL-> 32€

//        Example2:
//        ----Sales ticketsmart----
//        No tickets→ 4
//        Day of the week-> Friday
//        Student Card-> yes
//        TOTAL-> 28,8€
//
//        Example3:
//        ----Sales ticketsmart----
//        No tickets→ 5
//        Day of the week-> Thursday
//        Student Card-> yes
//        TOTAL-> 27€
//
//        Example4:
//        ----Sales ticketsmart----
//        No tickets→ 5
//        Day of the week-> Wednesday
//        Student Card-> yes
//        TOTAL-> 22,50€

        Scanner sc = new Scanner(System.in);

        float basePrice = 8, total = 0;

        System.out.println("=== DAY OF THE WEEK ===");
        System.out.println("1.- Monday");
        System.out.println("2.- Tuesday");
        System.out.println("3.- Wednesday");
        System.out.println("4.- Thursday");
        System.out.println("5.- Friday");
        System.out.println("6.- Saturday");
        System.out.println("7.- Sunday");
        System.out.print("Select a day: ");
        int day = sc.nextInt();

        System.out.println("------------------------");

        System.out.print("How many people are going? -> ");
        int people = sc.nextInt();

        if(day == 3) {
            total = 5 * people;

        } else if(day == 4) {
            int couples = people / 2;
            int single = people % 2;
            total = (couples * 11) + (single * basePrice);

        } else if(day == 1 || day == 2 || day == 5 || day == 6 || day == 7) {
            total = basePrice * people;
        }

        System.out.println("------------------------");

        System.out.print("Do you have a student card? -> ");
        String isStudent = sc.next();

        if(isStudent.equalsIgnoreCase("yes")) {
            total *= 0.90f;

        } else if(isStudent.equalsIgnoreCase("no")) {

        } else {
            System.out.println("Answer yes or no");
        }

        System.out.println("-------------------");
        System.out.println("Tickets -> " + people);
        System.out.println("Day of the week -> " + day);
        System.out.println("Student card -> " + isStudent);
        System.out.println("Total -> " + total);

    }
}
