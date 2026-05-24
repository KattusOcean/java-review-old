package module1Conditionals.exercises.highLevel;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
//        1o.- Realiza un ejercicio que califique la nota obtenida por un alumno/a en un examen. El
//        ejercicio pedirá al usuario la nota numérica, y se imprimirá en pantalla su traducción a nota
//        de texto: muy deficiente, insuficiente, suficiente, bien, notable y sobresaliente. Debes
//        realizar el ejercicio a través de una sentencia switch, no de if anidados.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the score: ");
        int score = sc.nextInt();

        if(score == 0 || score == 1 || score == 2) {
            System.out.println("The score is deficient");

        } else if (score == 3 || score == 4) {
            System.out.println("The score is insufficient");

        } else if (score == 5) {
            System.out.println("The score is sufficient");

        } else if (score == 6) {
            System.out.println("The score is good");

        } else if (score == 7 || score == 8) {
            System.out.println("The score is notable");

        } else if (score == 9 || score == 10) {
            System.out.println("The score is excellent");

        } else {
            System.out.println("Incorrect score");
        }
    }
}
