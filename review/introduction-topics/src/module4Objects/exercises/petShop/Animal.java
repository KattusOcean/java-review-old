package module4Objects.exercises.petShop;

public class Animal {
    protected char sex;
    protected int age;
    protected int ean;
    protected float price;
    protected String[] food;

    public Animal(Shop shop) {
        this.sex = assignAnimalsSex();
        this.age = assignAnimalsAge();
        this.ean = assignAnimalsEan(shop);
        this.price = assignAnimalsPrice();
        this.food = assignAnimalsFood();
    }

    public Animal(char sex, int age, int ean, float price) {
        this.sex = sex;
        this.age = age;
        this.ean = ean;
        this.price = price;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\tSex: " + assignAnimalsSex() + "\n" +
                "\tAge: " + age + "\n" +
                "\tEAN: " + ean + "\n" +
                "\tPrice: " + price + "\n";
    }

    /*
    ========== METHODS TO GENERATE ANIMALS ==========
     */
    public char assignAnimalsSex() {
        int sex = (int) Math.round(Math.random());
        return (sex == 1) ? 'M' : 'F';
    }

    public int assignAnimalsAge() {
        age = (int) Math.round(Math.random() * 13);
        return age;
    }

    public int assignAnimalsEan(Shop shop) {
        ean = shop.createUniqueEan();
        return ean;
    }

    public float assignAnimalsPrice() {
        if (this instanceof Dog) {
            Dog dog = (Dog) this; // To have access to the "isDogPedigree" method
            if (dog.isDogPedigree().equals("Yes")) {
                price = 200;
            } else {
                price = 100;
            }

        } else if (this instanceof Cat) {
            price = 50;

        } else if (this instanceof Bird) {
            price = 10;

        } else if (this instanceof Rat) {
            Rat rat = (Rat) this;
            if (rat.getWeight() > 200 && rat.getSize() > 5) price = 2;
        }

        return price;
    }

    public String[] assignAnimalsFood() {
        if (this instanceof Dog) food = new String[] {"Meat", "Bones", "Feed"};
        else if (this instanceof Cat) food = new String[] {"Fish", "Feed"};
        else if (this instanceof Bird) food = new String[] {"Feed"};
        else if (this instanceof Rat) food = new String[] {"-"};

        return food;
    }
}
