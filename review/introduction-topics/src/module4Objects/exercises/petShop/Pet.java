package module4Objects.exercises.petShop;

public class Pet extends Animal {
    protected String chip;
    protected String name;
    protected Owner owner;

    public Pet(Shop shop) {
        super(shop);
        this.chip = assignPetsChip(shop);
        this.name = assignPetsName(shop);
        this.owner = assignPetsOwner(shop);
    }

    public Pet(char sex, int age, int ean, float price, String chip, String name, Owner owner) {
        super(sex, age, ean, price);
        this.chip = chip;
        this.name = name;
        this.owner = owner;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tChip: " + chip + "\n" +
                "\tName: " + name + "\n";
    }

    /*
    ========== METHODS TO GENERATE PETS ==========
     */
    public String assignPetsChip(Shop shop) {
        chip = shop.createUniqueChip();
        return chip;
    }

    public String assignPetsName(Shop shop) {
        name = shop.createUniquePetName();
        return name;
    }

    public Owner assignPetsOwner(Shop shop) {
        Owner owner = new Owner(shop);
        return owner;
    }
}
