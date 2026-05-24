package module3Arrays.exercises.master;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
//        1.- Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los
//        almacene en un array. El programa debe ser capaz de pasar todos los números pares a las
//        primeras posiciones del array (del 0 en adelante) y todos los números impares a las celdas
//        restantes. Utiliza arrays auxiliares si es necesario.

        int[] array = new int[10];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array[i] = rand;
        }
        showArray(array);

        System.out.print("\n--- Sorted Array By Parity ---\n");
        sortArrayByParity(array);

        // EXTRA
//        System.out.print("\n--- Sorted Array By Parity And Order ---\n");
//        sortArrayByParityAndOrder(array);
    }

    public static void sortArrayByParity(int[] array) {
        int n = array.length;

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];

            for (int j = n - 1; j > i; j--) {
                if (array[i] % 2 != 0 && array[j] % 2 == 0) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        showArray(array);
    }

    public static void showArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " | ");
        }
    }

    // EXTRA
    public static void sortArrayByParityAndOrder(int[] array) {
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        // Adds the even and odd numbers in their respective array lists
        for (int num : array) {
            if (num % 2 == 0) evens.add(num);
            else odds.add(num);
        }

        quickSort(evens,0, odds.getLast());
        quickSort(odds, 0, odds.getLast());

        int index = 0;
        for (int num : evens) array[index++] = num;
        for (int num : odds) array[index++] = num;

        showArray(array);
    }

    // Sorts the array lists
    public static void quickSort(ArrayList<Integer> list, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(list, start, end);
            quickSort(list, start, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, end);
        }
    }


    // Divides the array lists
    public static int partition(ArrayList<Integer> list, int start, int end) {
        int mid = (start + end) / 2;

        int first = list.getFirst();
        int middle = list.get(mid);
        int last = list.getLast();

        if (first > middle) { int temp = first; first = middle; middle = temp; }
        if (first > last) { int temp = first; first = last; last = temp; }
        if (middle > last) { int temp = middle; middle = last; last = temp; }

        int pivot = middle;

        int pivotIndex = mid;
        swap(list, pivotIndex, end);

        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, end);
        return i+1;
    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);

    }

}
