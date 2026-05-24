package ObjectOrientedPractices.InnerClasses;

public class Main {
    static void main() {
        OuterClass out = new OuterClass();
        out.innerMessage();

        OuterClass.InnerClass in = out.new InnerClass();

    }
}
