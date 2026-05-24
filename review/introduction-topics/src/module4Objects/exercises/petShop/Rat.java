package module4Objects.exercises.petShop;

public class Rat extends Animal {
    private float weight;
    private float size;

    public Rat(Shop shop) {
        super(shop);
        this.weight = assignRatsWeight();
        this.size = assignRatsSize();
    }

    public Rat(char sex, int age, int ean, float price, float weight, float size) {
        super(sex, age, ean, price);
        this.weight = weight;
        this.size = size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "RAT ->\n" +
                super.toString() +
                "\tWeight: " + weight + "kg\n" +
                "\tSize: " + size + "cm\n";
    }

    /*
    ========== METHODS TO GENERATE RATS ==========
     */

    public float assignRatsWeight() {
        return 5 + (int) Math.round(Math.random() * 11);
    }

    public float assignRatsSize() {
        return 200 + (int) Math.round(Math.random() * 301);
    }
}
