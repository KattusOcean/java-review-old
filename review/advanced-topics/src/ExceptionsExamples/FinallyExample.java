package ExceptionsExamples;

public class FinallyExample {
    static void main() throws CustomException {
        System.out.println(correctDivide());
        System.out.println("------------------");
//        System.out.println(correctDivide());

    }

    private static int incorrectDivide() {
        try  {
            int a = 5, b = 0;
            int divResult = a / b;
            return divResult;

        } catch (ArithmeticException e) {
            System.out.println("Something went wrong");
            throw e;

        } finally {
            System.out.println("Something went soooo wrong!");
        }

    }

    private static int correctDivide() throws CustomException {
        try {
          int a = 6, b = 2;
          int divResult = a / b;
          return divResult;

        } catch (ArithmeticException | NullPointerException e) {
            throw new CustomException("Oh no", new RuntimeException());

        } finally {
            System.out.println("Showing the result...");
        }
    }
}
