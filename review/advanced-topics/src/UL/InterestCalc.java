package UL;

import java.util.Scanner;

public class InterestCalc {
    static void main() {
        Scanner sc = new Scanner(System.in);

        double principal, amount;
        int rate, timesCompounded, years;

        System.out.print("Enter the principal amount: ");
        principal = sc.nextFloat();
        System.out.print("Enter the interest rate (in %): ");
        rate = sc.nextInt() / 100;
        System.out.print("Enter the # of times compounded per year: ");
        timesCompounded = sc.nextInt();
        System.out.print("Enter the # of years: ");
        years = sc.nextInt();

        amount = principal * Math.pow((1 + (rate / timesCompounded)), (timesCompounded * years));
        System.out.println("The amount after " + years + " year = " + amount);

        sc.close();
    }
}
