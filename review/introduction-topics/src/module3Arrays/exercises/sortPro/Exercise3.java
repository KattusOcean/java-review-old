package module3Arrays.exercises.sortPro;

public class Exercise3 {
    public static void main(String[] args) {
//        3º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y
//        1.000. Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenación
//        llamado "Shell", con el objetivo de ordenar el array completamente. Puedes consultar el
//        siguiente enlace http://lwh.free.fr/pages/algo/tri/tri_shell_es.html

        int[] array = new int[15];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
        }
        showArray(array);

        System.out.println("\n--- Modified Array ---");
        shellSort(array);
    }

    public static void shellSort(int[] array) {
        int n = array.length;

        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
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
