package module3Arrays.exercises.begginer;

public class Exercise5 {
//    5º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//    Debes obtener la suma de los números pares y los impares en variables separadas

    public static void main(String[] args) {
        int[] array = new int[150];
        int totalEven = 0, totalOdd = 0;

        System.out.println("--- Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
            System.out.print(array[i] + "\t");
        }

        for (int num : array) {
            if (num % 2 == 0) {
                totalEven += num;
            } else {
                totalOdd += num;
            }
        }

        System.out.println("\n--- Operations ---");
        System.out.printf("The sum of even numbers = %d\n", totalEven);
        System.out.printf("The sum of odd numbers = %d", totalOdd);
    }
}
