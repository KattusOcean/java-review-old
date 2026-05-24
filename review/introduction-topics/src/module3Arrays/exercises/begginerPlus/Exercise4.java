package module3Arrays.exercises.begginerPlus;

public class Exercise4 {
    public static void main(String[] args) {
//        4º.- Realiza un ejercicio en que inicialice un array de 5 elementos enteros al azar entre 0 y 100.
//        Debes conseguir que se desplacen los números un lugar a su derecha, de manera que el
//        desplazamiento sea circular, si un número sale por la derecha volverá a entrar por la izquierda.
//        Ejemplo: 1 2 3 4 5 pasa a ser 5 1 2 3 4 que pasa a ser 4 5 1 2 3. Debes realizar el ejercicio
//        mediante un método que admita el array como argumento y realice la acción pedida. Cabecera
//        del método 'public static void desplazaCiclicoDerecha (int a[])'.

        int[] array = new int[8];

        System.out.println("--- Original Array ---");
        for (int i = 0; i < array.length; i++) {
            int rand = (int) Math.round(Math.random() * 10);
            array[i] = rand;
            System.out.print(array[i] + "\t");
        }

        System.out.println("\n--- Modified Array ---");
        arrayElementToRight(array);
    }

    public static void arrayElementToRight(int[] array) {

        int  lastNum = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastNum;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
