package ConcurrencyTests;

public class ThreadTestMain {
    static void main() {
        ThreadTests threadTests = new ThreadTests();
        threadTests.startThreads();
        threadTests.startVirtualThreads();
        threadTests.startThreadLocal();
    }
}