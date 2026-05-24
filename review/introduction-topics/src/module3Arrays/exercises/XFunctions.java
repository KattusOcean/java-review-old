package module3Arrays.exercises;

import utils.XMathLibrary;

import java.util.Scanner;

public class XFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Capicua method
        System.out.print("Introduce a number: ");
        int capicuaNum = sc.nextInt();
        XMathLibrary.isCapicua(capicuaNum);

        // Prime method
        System.out.print("Introduce a number: ");
        int primeNum = sc.nextInt();
        XMathLibrary.isPrime(primeNum);

        // Count digits in a number
        System.out.print("Introduce a number: ");
        int numToDivide = sc.nextInt();
        XMathLibrary.digits(numToDivide);

        // Flips a number
        System.out.print("Introduce a number: ");
        int numToFlip = sc.nextInt();
        XMathLibrary.flip(numToFlip);

        // Returns the digit in 'N' position
        System.out.print("Introduce a number: ");
        int num = sc.nextInt();
        XMathLibrary.digitN(num);

        // Gives the digit when an occurrence happen
        System.out.print("Introduce a number: ");
        int num2 = sc.nextInt();
        XMathLibrary.digitPosition(num2);

        // Removes the number behind the one selected
        System.out.print("Introduce a  number: ");
        int rawNumber = sc.nextInt();
        System.out.printf("Select a position (0 - %d)", (rawNumber-1));
        int position = sc.nextInt();
        XMathLibrary.removeByBehind(rawNumber, position);

        // Adds a digit for a number behind
        System.out.print("Introduce a  number: ");
        int rawNumber2 = sc.nextInt();
        System.out.printf("Select a position (0 - %d)", (rawNumber2-1));
        int position2 = sc.nextInt();
        System.out.print("Introduce a number to add: ");
        int numToAdd = sc.nextInt();
        XMathLibrary.removeByBehind(rawNumber2, position2, numToAdd);

        // Takes the start and end positions as parameters within a number and returns the corresponding chunk
        System.out.print("Introduce a number: ");
        int rawNumber3 = sc.nextInt();
        System.out.print("Introduce a start point: ");
        int startPoint = sc.nextInt();
        System.out.print("Introduce an end point: ");
        int endPoint = sc.nextInt();
        XMathLibrary.numberSnippet(rawNumber3, startPoint, endPoint);

        // Glue two numbers
        System.out.print("Introduce a number: ");
        int firstNum = sc.nextInt();
        System.out.print("Introduce another number: ");
        int secondNumber = sc.nextInt();
        XMathLibrary.numbersTogether(firstNum, secondNumber);
    }
}
