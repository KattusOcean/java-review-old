package module3Arrays.exercises.begginerPlus;

public class Exercise2 {
    public static void main(String[] args) {
//        2º.- Realiza un ejercicio que inicialice dos arrays de 150 elementos enteros al azar entre 0 y
//        100. Debes crear un tercer array, compuesto de la siguiente forma: en los elementos de índice
//        impar del tercer array debes copiar los elementos de índice impar del primer array; en los
//        elementos de índice par del tercer array debes copiar los elementos de índice par del segundo
//        array. Debes realizar el ejercicio mediante un método que admita los arrays como argumentos y
//        realice la acción pedida. Cabecera del método 'public static int[] creaTercerArray (int a1[], int
//        a2[])'

        int[] array1 = new int[15], array2 = new int[array1.length];

        System.out.println("--- Array 1 ---");
        for (int i = 0; i < array1.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array1[i] = rand;
            System.out.print(array1[i] + "\t");
        }

        System.out.println("\n--- Array 2 ---");
        for (int i = 0; i < array2.length; i++) {
            int rand = (int) Math.round(Math.random() * 100);
            array2[i] = rand;
            System.out.print(array2[i] + "\t");
        }

        System.out.println("\n--- Array 3 ---");
        mergeArraysByOddEvenIndexes(array1, array2);
    }

    public static int[] mergeArraysByOddEvenIndexes(int[] a1, int[] a2) {
        int[] array3 = new int[a1.length];

        for (int i = 0; i < array3.length; i++) {
            if (i % 2 == 0) array3[i] = a1[i];
            else array3[i] = a2[i];
            System.out.print(array3[i] + "\t");
        }

        return array3;
    }
}
