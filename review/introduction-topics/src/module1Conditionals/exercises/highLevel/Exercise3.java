package module1Conditionals.exercises.highLevel;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        3o.- Realiza un programa que resuelva lo siguientes puntos:
//        a.- Que muestre un menú en pantalla con opciones para:
//            1. Cálculo de la hipotenusa de un triángulo.
//            2. Cálculo de la superficie de una circunferencia.
//            3. Cálculo del perímetro de una circunferencia.
//            4. Cálculo del área de un rectángulo.
//            5. Cálculo del área de un triángulo.
//
//        g.- Si la opción no fuese "0", "1", "2", "3", "4" o "5", el programa deberá dar el
//        mensaje de "opción incorrecta".

        Scanner sc = new Scanner(System.in);

        System.out.println("=== MENU ===");
        System.out.println("1.- Triangle hypotenuse");
        System.out.println("2.- Circumference surface");
        System.out.println("3.- Circumference perimeter");
        System.out.println("4.- Rectangle area");
        System.out.println("5.- Triangle area");
        System.out.println("0.- Exit");
        System.out.print("Select an option: ");
        int option = sc.nextInt();
        System.out.println("---------------------------");

        switch (option) {
            case 1:
                calculateTriangleHypotenuse();
                break;
            case 2:
                calculateCircumferenceArea();
                break;
            case 3:
                calculateCircumferencePerimeter();
                break;
            case 4:
                calculateRectangleArea();
                break;
            case 5:
                calculateTriangleArea();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void calculateTriangleHypotenuse() {
//        b.- En la opción "1" debe pedir dos datos, correspondientes a las longitudes de los
//        dos catetos de un triángulo. Se debe imprimir la longitud de la hipotenusa. Recuerda que
//        Hipotenusa al cuadrado = cateto1 al cuadrado + cateto2 al cuadrado.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce a cathetus: ");
        float cathetus1 = sc.nextInt();
        System.out.print("Introduce the other cathetus: ");
        float cathetus2 = sc.nextInt();

        float hypotenuse = (float) Math.sqrt((float) Math.pow(cathetus1, 2) + (float) Math.pow(cathetus2, 2));

        System.out.println("The hypotenuse is " + hypotenuse);
    }

    public static void calculateCircumferenceArea() {
//        c.- En la opción "2" debe pedir la longitud del radio de una circunferencia e imprimir
//        la superficie de la misma. Recuerda que el área es igual a PI por el radio al cuadrado.
//        Recuerda también que PI es igual a 3,1416.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the radius length: ");
        float radio = sc.nextInt();

        float area = (float) (Math.PI * (float) Math.pow(radio, 2));

        System.out.println("The area is " + area);
    }

    public static void calculateCircumferencePerimeter() {
//        d.- En la opción "3" debe pedir la longitud del radio de una circunferencia e imprimir
//        la longitud del perímetro de la misma. Recuerda que la longitud de la circunferencia = 2 por
//        PI por el radio.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the length of the radius: ");
        float radius = sc.nextInt();

        float perimeter = 2 * (float) Math.PI * radius;

        System.out.println("The perimeter is " + perimeter);
    }

    public static void calculateRectangleArea() {
//        e.- En la opción "4" debe pedir las longitudes de la base y la altura de un
//        rectángulo, e imprimir el área de dicho rectángulo. Recuerda que el área del rectángulo es
//        igual a la base por la altura.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the base length: ");
        float base = sc.nextFloat();
        System.out.print("Introduce the height length: ");
        float height = sc.nextFloat();

        float area = base * height;

        System.out.println("The area is " + area);
    }

    public static void calculateTriangleArea() {
//        f.- En la opción "5" debe pedir la base y la altura de un tríangulo e imprimir el área
//        del mismo. Recuerda que el área del triángulo es la mitad del área del rectángulo de igual
//        base y altura.

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce the base: ");
        float base = sc.nextFloat();
        System.out.print("Introduce the height: ");
        float height = sc.nextFloat();

        float area = (base * height) / 2;

        System.out.println("The area is " + area);
    }
}
