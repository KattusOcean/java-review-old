package ObjectOrientedPractices.InnerClasses;

public class OuterClass {

    public class InnerClass {
        public void display() {
            System.out.println("I'm an inner class!");
        }
    }

    public void innerMessage () {
        InnerClass in = new InnerClass();
        in.display();
    }

}
