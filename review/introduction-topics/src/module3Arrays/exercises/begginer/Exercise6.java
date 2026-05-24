package module3Arrays.exercises.begginer;

public class Exercise6 {
    public static void main(String[] args) {
//        6º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//        Debes mostrar al usuario la suma de los elementos cuyo índice sea par

        int[] array = new int[150];
        int totalSumEvenIndex = 0;

        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
            System.out.print(array[i] + "\t");

            if (i % 2 == 0) {
                totalSumEvenIndex += array[i];
            }
        }

        System.out.printf("\nSum of even indexes = %d", totalSumEvenIndex);
    }
}
