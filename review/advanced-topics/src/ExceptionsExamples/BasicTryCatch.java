package ExceptionsExamples;

public class BasicTryCatch {
    static void main() {
        try {
            int result = calc();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Algo ha fallado");
            System.out.println(e.getMessage());
        }

    }

    public static int calc() {
        int x = 5 / 0;
        return x;
    }
}
