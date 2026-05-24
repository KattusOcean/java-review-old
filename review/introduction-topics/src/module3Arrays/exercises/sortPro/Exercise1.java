package module3Arrays.exercises.sortPro;

public class Exercise1 {
    public static void main(String[] args) {
//        1º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y
//        1.000. Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenación
//        llamado "Burbuja", con el objetivo de ordenar el array completamente. Puedes consultar el
//        siguiente enlace http://lwh.free.fr/pages/algo/tri/tri_bulle_es.htm

        int[] array = new int[25];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 1000);
            array[i] = rand;
        }
        showArray(array);

        System.out.println("\n--- Ordered Array ---");
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        int temp = 0;
        boolean ordered = true;

        while (ordered) {
            ordered = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    ordered = true;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        showArray(array);
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
    }
}
