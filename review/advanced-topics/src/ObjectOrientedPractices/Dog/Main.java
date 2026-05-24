package ObjectOrientedPractices.Dog;

public class Main {
    static void main() {
        Dog dog = new Dog("rex", 4);

        System.out.println(dog);
        System.out.println(dog.addAge(5));
    }
}
