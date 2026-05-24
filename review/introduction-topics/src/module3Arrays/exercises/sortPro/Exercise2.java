package module3Arrays.exercises.sortPro;

public class Exercise2 {
    public static void main(String[] args) {
//        2º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y
//        1.000. Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenación
//        llamado "Inserción directa", con el objetivo de ordenar el array completamente. Puedes
//        consultar el siguiente enlace http://lwh.free.fr/pages/algo/tri/tri_insertion_es.html

        int[] array = new int[25];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 1000);
            array[i] = rand;
        }
        showArray(array);

        System.out.println("\n--- Ordered Array ---");
        insertionSort(array);
    }

    public static void insertionSort (int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
        showArray(array);
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
    }
}
