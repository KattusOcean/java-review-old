package module4Objects.exercises.edibleShop;

public class NonPerishable extends Products{

    public NonPerishable(String code, String name, float price) {
        super(code, name, price);
    }

    @Override
    public String toString() {
        return super.toString() + " | Non perishable";
    }
}
