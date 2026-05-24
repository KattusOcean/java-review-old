package module4Objects.exercises.petShop;

public class Cat extends Pet {
    private String color;
    private String breed;
    private String hair;

    public Cat(Shop shop) {
        super(shop);
        this.color = assignCatsColor();
        this.breed = assignCatsBreed();
        this.hair = assignCatsHair();
    }

    public Cat(char sex, int age, int ean, float price, String chip, String name, Owner owner, String color, String breed, String hair) {
        super(sex, age, ean, price, chip, name, owner);
        this.color = color;
        this.breed = breed;
        this.hair = hair;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @Override
    public String toString() {
        return "CAT ->\n" +
                super.toString() +
                "\tColor: " + color + "\n" +
                "\tBreed: " + breed + "\n" +
                "\tHair: " + hair + "\n" +
                "\tOwner -> " + owner + "\n";
    }

    /*
    ========== METHODS TO GENERATE CATS ==========
     */
    public String assignCatsColor() {
        String[] colorList = new String[] {"Black", "White", "Brown", "Beige", "Gray", "Golden", "Brindle", "Merle", "Chocolate"};
        color = colorList[(int) (Math.random() * colorList.length)];
        return color;
    }

    public String assignCatsBreed() {
        String[] breedList = new String[] {"Siamese", "Persian", "Maine Coon", "Ragdoll", "Bengal", "Sphynx",
                "British Shorthair", "Scottish Fold", "Abyssinian", "Russian Blue",
                "Norwegian Forest", "Oriental Shorthair", "Turkish Angora", "Birman",
                "Exotic Shorthair", "Savannah"};
        breed = breedList[(int) (Math.random() * breedList.length)];
        return breed;
    }

    public String assignCatsHair() {
        String[] hairList = new String[] {"Short", "Medium", "Long", "Curly", "Smooth"};
        hair = hairList[(int) (Math.random() * hairList.length)];
        return hair;
    }
}
