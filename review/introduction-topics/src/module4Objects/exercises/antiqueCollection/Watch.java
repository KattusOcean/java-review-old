package module4Objects.exercises.antiqueCollection;

public class Watch extends Antique {
    private String brand;

    public Watch(int code, String fabricationDate, String origin, float price, String brand) {
        super(code, fabricationDate, origin, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Object: Watch | " + super.toString() + " | Brand: " + brand;
    }
}
