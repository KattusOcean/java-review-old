package module4Objects.exercises.petShop;

public class Dog extends Pet {
    private String color;
    private String breed;
    private String hair;
    private int isPedigree;

    public Dog(Shop shop) {
        super(shop);
        this.color = assignDogsColor();
        this.breed = assignDogsBreed();
        this.hair = assignDogsHair();
        this.isPedigree = (int) (Math.round(Math.random()));
        this.price = (isPedigree == 1) ? 200 : 100;
    }

    public Dog(char sex, int age, int ean, float price, String chip, String name, Owner owner, String color, String breed, String hair, int isPedigree) {
        super(sex, age, ean, price, chip, name, owner);
        this.color = color;
        this.breed = breed;
        this.hair = hair;
        this.isPedigree = isPedigree;
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

    public int getIsPedigree() {
        return isPedigree;
    }

    public void setIsPedigree(int isPedigree) {
        this.isPedigree = isPedigree;
    }

    @Override
    public String toString() {
        return "DOG ->\n" +
                super.toString() +
                "\tColor: " + color + "\n" +
                "\tBreed: " + breed + "\n" +
                "\tHair: " + hair + "\n" +
                "\tPedigree: " + isDogPedigree() + "\n" +
                "\tOwner -> " + owner + "\n";
    }

    /*
    ========== METHODS TO GENERATE DOGS ==========
     */
    public String assignDogsColor() {
        String[] colorList = new String[] {"Black", "White", "Brown", "Beige", "Gray", "Golden", "Brindle", "Merle", "Chocolate"};
        color = colorList[(int) (Math.random() * colorList.length)];
        return color;
    }

    public String assignDogsBreed() {
        String[] breedList = new String[] {"Labrador Retriever", "German Shepherd", "Golden Retriever", "Bulldog", "Rottweiler", "Siberian Husky", "Boxer",
                "Chihuahua", "Pug", "Border Collie", "Shiba Inu", "Doberman", "Great Dane", "Maltese", "Pit Bull", "Yorkshire Terrier"};
        breed = breedList[(int) (Math.random() * breedList.length)];
        return breed;
    }

    public String assignDogsHair() {
        String[] hairList = new String[] {"Short", "Medium", "Long", "Curly", "Smooth"};
        hair = hairList[(int) (Math.random() * hairList.length)];
        return hair;
    }

    public String isDogPedigree() {
        return (isPedigree == 1) ? "Yes" : "No";
    }
}
