package ExceptionsExamples;

public class ThrowExample {
    static void main() {
        String codification = "clicks = 30, pages = 10, sessions = 5";

        // Needed when we use "throws Exception" on a method
        try {
            sendToServer(codification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendToServer(String codification) throws Exception {
        if (codification == null || codification.isEmpty()) {
            // Exception exception = new Exception("Codification is empty!");
            // throw exception;

            throw new Exception("Codification is empty");
        }
    }
}
