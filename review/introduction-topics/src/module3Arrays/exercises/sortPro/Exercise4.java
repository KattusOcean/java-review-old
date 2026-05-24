package module3Arrays.exercises.sortPro;

public class Exercise4 {
    public static void main(String[] args) {
//        4º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y
//        1.000. Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenación
//        llamado "Selección", con el objetivo de ordenar el array completamente. Puedes consultar el
//        siguiente enlace http://lwh.free.fr/pages/algo/tri/tri_selection_es.html

        int[] array = new int[15];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
        }
        showArray(array);

        System.out.println("\n--- Sorted Array ---");
        selectionSort(array);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        showArray(array);
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
    }
}
