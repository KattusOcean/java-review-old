package module4Objects.exercises.petShop;

public class Bird extends Animal {
    private String color;
    private String type;

    public Bird(Shop shop) {
        super(shop);
        this.color = assignBirdsColor();
        this.type = assignBirdsType();
    }

    public Bird(char sex, int age, int ean, float price, String color, String type) {
        super(sex, age, ean, price);
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BIRD ->\n" +
                super.toString() +
                "\tColor: " + color + "\n" +
                "\tType: " + type + "\n";
    }

    /*
    ========== METHODS TO GENERATE BIRDS ==========
     */
    public String assignBirdsColor() {
        String[] colorList = new String[] {"Black", "White", "Brown", "Beige", "Gray", "Golden", "Brindle", "Merle", "Chocolate"};
        color = colorList[(int) (Math.random() * colorList.length)];
        return color;
    }

    public String assignBirdsType() {
        String[] typeList = new String[] {"Canary", "Budgerigar", "Lovebird", "African Grey Parrot", "Cockatoo", "Cockatiel", "Amazon Parrot", "Zebra Finch"};
        type = typeList[(int) (Math.random() * typeList.length)];
        return type;
    }
}
