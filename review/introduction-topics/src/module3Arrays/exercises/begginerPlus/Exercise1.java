package module3Arrays.exercises.begginerPlus;

public class Exercise1 {
    public static void main(String[] args) {
//        1º.- Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre -100 y
//        100. Debes conseguir que todos los números pares del array cambien de signo, los positivos
//        deben pasar a negativos y viceversa. Debes realizar el ejercicio mediante un método que
//        admita el array como argumento y realice la acción pedida. Cabecera del método 'public static
//        void cambiaSignoEnValores(int array[])

        int[] array = new int[10];
        int maxRand = 5, minRand = -5;

        System.out.println("--- Untouched Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * (maxRand - minRand) + minRand);
            array[i] = rand;
            System.out.print(array[i] + "\t");
        }

        System.out.println("\n--- Changed Array ---");
        changeOddsSign(array);
    }

    public static void changeOddsSign(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) array[i] *= -1;
            System.out.print(array[i] + "\t");
        }
    }
}
