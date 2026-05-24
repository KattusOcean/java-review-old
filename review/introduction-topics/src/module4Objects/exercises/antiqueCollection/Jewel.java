package module4Objects.exercises.antiqueCollection;

public class Jewel extends Antique {
    private String material;

    public Jewel(int code, String fabricationDate, String origin, float price, String material) {
        super(code, fabricationDate, origin, price);
        this.material = material;
    }


    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Object: Jewel | " + super.toString() + " | Material: " + material;
    }
}
