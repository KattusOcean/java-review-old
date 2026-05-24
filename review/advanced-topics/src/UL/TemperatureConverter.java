package UL;

import java.util.Scanner;

public class TemperatureConverter {
    static void main() {

        Scanner sc = new Scanner(System.in);
        float temp, newTemp;
        char unit;

        System.out.print("Convert to Celsius or Fahrenheit (C or F): ");
        unit = sc.next().toUpperCase().charAt(0);
        System.out.print("Introduce the temperature: ");
        temp = sc.nextFloat();

        newTemp = (unit == 'C') ? ((temp - 32) * 5 / 9) : (temp * 9 / 5) + 32;
        System.out.println("The new temperature is " + newTemp + "º" + unit);

        sc.close();
    }
}
