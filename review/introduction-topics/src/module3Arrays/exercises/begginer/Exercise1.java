package module3Arrays.exercises.begginer;

public class Exercise1 {
//    1º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
//    Debes mostrar el array en pantalla y obtener la suma, la media, el menor y el mayor de todos
//    los números que aparecen en el array.

    public static void main (String[] args) {
        int[] numbers = new int[150];
        int biggest = 0, lowest = 100;
        int sum = 0;
        int avg = 0;

        for (int i = 0; i < numbers.length; i++) {
            int rand = (int) Math.round(Math.random() * (100));
            numbers[i] = rand;
            System.out.printf("%d.- %d\n", i, numbers[i]);

            sum += numbers[i];
            avg = sum / numbers.length;

            if (numbers[i] > biggest) {
                biggest = numbers[i];

            } else if (numbers[i] < lowest) {
                lowest = numbers[i];
            }
        }

        System.out.println("------------------------");
        System.out.printf("Total = %d\n", sum);
        System.out.printf("Average = %d\n", avg);
        System.out.printf("Biggest num = %d\n", biggest);
        System.out.printf("Lowest num = %d", lowest);
    }
}
