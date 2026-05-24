package module4Objects.exercises.petShop;

import module4Objects.exercises.antiqueCollection.Antique;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Animal> soldAnimals = new ArrayList<>();
    ArrayList<Owner> owners = new ArrayList<>();

    public void quickShowAnimals() {
        for (Animal animal : animals) {
            if (animal instanceof Dog) System.out.println(animal);
        }

        for (Animal animal : animals) {
            if (animal instanceof Cat) System.out.println(animal);
        }

        for (Animal animal : animals) {
            if (animal instanceof Bird) System.out.println(animal);
        }

        for (Animal animal : animals) {
            if (animal instanceof Rat) System.out.println(animal);
        }

        System.out.println("************************************************************");
    }

    public void sellAnimal(int ean) {
        float finalPrice = 0;

        for (int i = 0; i < animals.size(); i++) {
            if (ean == animals.get(i).getEan()) {
                Animal animal = animals.get(i);
                finalPrice = animal.getPrice();
                soldAnimals.add(animal);
                animals.remove(animal);
                break;
            }
        }

        System.out.println("The final price is: " + finalPrice);
        System.out.println("************************************************************");
    }

    public void showTotalAnimalsSold() {
        int totalSoldAnimals = 0;

        for (Animal animal : soldAnimals) {
            totalSoldAnimals += 1;
        }

        System.out.println("Number of sold animals: " + totalSoldAnimals);
        System.out.println("************************************************************");

    }

    public void showTotalPetsAvailable() {
        int totalPetsAvailable = 0;

        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                totalPetsAvailable += 1;
            }
        }

        System.out.println("Number of available pets: " + totalPetsAvailable);
        System.out.println("************************************************************");
    }

    public void showTotalAvailableAnimalsIndividually() {
        int totalAvailableDogs = 0, totalAvailableCats = 0, totalAvailableBirds = 0, totalAvailableRats = 0;

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                totalAvailableDogs += 1;
            } else if (animal instanceof Cat) {
                totalAvailableCats += 1;
            } else if (animal instanceof Bird) {
                totalAvailableBirds += 1;
            } else if (animal instanceof Rat) {
                totalAvailableRats += 1;
            }
        }

        System.out.println("Number of available dogs: " + totalAvailableDogs);
        System.out.println("Number of available cats: " + totalAvailableCats);
        System.out.println("Number of available birds: " + totalAvailableBirds);
        System.out.println("Number of available rats: " + totalAvailableRats);
        System.out.println("************************************************************");
    }

    public void showPetOwnerByDni(String dni) {
        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                if (((Pet) animal).getOwner().getDni().equals(dni)) {
                    System.out.println("OWNER -> " + ((Pet) animal).getOwner().toString());
                }
            }
        }
        System.out.println("************************************************************");
    }

    public void showNumberAndChipOfPetByName(String petName) {
        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                if (((Pet) animal).getName().equals(petName)) {
                    System.out.println(animal.toString());
                }
            }
        }
        System.out.println("************************************************************");
    }

    public void showAnimalCharacteristicsByEan(int ean) {
        for (Animal animal : animals) {
            if (animal.getEan() == ean) {
                System.out.println(animal);
            }
        }
        System.out.println("************************************************************");
    }

    public void showIfCanMateByChip(String chip1, String chip2) {
        Animal pet1 = null, pet2 = null;

        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                if (((Pet) animal).getChip().equals(chip1)) pet1 = animal;
                if (((Pet) animal).getChip().equals(chip2)) pet2 = animal;
            }
        }

        if (pet1 == null || pet2 == null) {
            System.out.println("A chip number was wrong!");
            return;
        }

        if (!pet1.getClass().equals(pet2.getClass())) {
            System.out.println("They have to be the same species");
            return;
        }

        if (pet1.getSex() == pet2.getSex()) System.out.println("They are the same sex. They cant mate!");
        else System.out.println("They can mate!");

        System.out.println("************************************************************");
    }

    public void showAnimalLikedFood() {
        boolean dogShown = false, catShown = false, birdShown = false, ratShown = false;

        for (Animal animal : animals) {
            if (animal instanceof Dog && !dogShown) {
                System.out.println(animal.getClass().getSimpleName() + " likes: " + Arrays.toString(animal.assignAnimalsFood()));
                dogShown = true;
            }
            else if (animal instanceof Cat && !catShown) {
                System.out.println(animal.getClass().getSimpleName() + " likes: " + Arrays.toString(animal.assignAnimalsFood()));
                catShown = true;
            }
            else if (animal instanceof Bird && !birdShown) {
                System.out.println(animal.getClass().getSimpleName() + " likes: " + Arrays.toString(animal.assignAnimalsFood()));
                birdShown = true;
            }
                else if (animal instanceof Rat && !ratShown) {
                System.out.println(animal.getClass().getSimpleName() + " likes: " + Arrays.toString(animal.assignAnimalsFood()));
                ratShown = true;
            }
        }
        System.out.println("************************************************************");
    }

    /*
    ========== SUPPORT METHODS ==========
     */

    public String createUniquePetName () {
        String nameRegex = "^[A-Z][a-z]{2}$";
        String petName;
        boolean isUnique;

        do {
            int length = 3 + (int) (Math.random() * 8);
            StringBuilder sb = new StringBuilder();

            sb.append((char) ('A' + (int) (Math.random() * 26)));
            for (int i = 1; i < length; i++) {
                sb.append((char) ('a' + (int) (Math.random() * 26)));
            }
            petName = sb.toString();

            isUnique = true;
            for (Animal animal : animals) {
                if (animal instanceof Pet) {
                    if (((Pet) animal).getName().equals(petName)) {
                        isUnique = false;
                        break;
                    }
                }
            }

        } while (!petName.matches(nameRegex) && !isUnique);

        return petName;
    }

    public int createUniqueEan() {
        int ean;
        boolean isUnique;

        do {
            ean = (int) Math.round(Math.random() * 1000);
            isUnique = true;

            for (Animal animal : animals) {
                if (animal.getEan() == ean) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        return ean;
    }

    public String createUniqueChip() {
        String chipChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String chip;
        boolean isUnique;

        do {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 4; i++) sb.append(chipChars.charAt((int) (Math.random() * chipChars.length())));
            sb.append('-');
            for (int i = 0; i < 4; i++) sb.append(chipChars.charAt((int) (Math.random() * chipChars.length())));
            chip = sb.toString();

            isUnique = true;
            for (Animal animal : animals) {
                if (animal instanceof Pet) {
                    Pet pet = (Pet) animal;
                    if (pet.getChip().equals(chip)) {
                        isUnique = false;
                        break;
                    }
                }
            }
        } while (!isUnique);
        return chip;
    }

    public String createUniqueOwnerName() {
        String nameRegex = "^[A-Z][a-z]{2}$";
        String ownerName;
        boolean isUnique;

        do {
            int length = 3 + (int) (Math.random() * 8);
            StringBuilder sb = new StringBuilder();

            sb.append((char) ('A' + (int) (Math.random() * 26)));
            for (int i = 1; i < length; i++) {
                sb.append((char) ('a' + (int) (Math.random() * 26)));
            }
            ownerName = sb.toString();

            isUnique = true;
            for (Owner owner : owners) {
                if (owner.getName().equals(ownerName)) {
                    isUnique = false;
                    break;
                }
            }

        } while (!ownerName.matches(nameRegex) && !isUnique);
        return ownerName;
    }

    public String createUniqueOwnerSurname() {
        String surnameRegex = "^[A-Z][a-z]{2}$";
        String ownerSurname;
        boolean isUnique;

        do {
            int length = 3 + (int) (Math.random() * 8);
            StringBuilder sb = new StringBuilder();

            sb.append((char) ('A' + (int) (Math.random() * 26)));
            for (int i = 1; i < length; i++) {
                sb.append((char) ('a' + (int) (Math.random() * 26)));
            }
            ownerSurname = sb.toString();

            isUnique = false;
            for (Owner owner : owners) {
                if (owner.getSurname().equals(ownerSurname)) {
                    isUnique = false;
                    break;
                }
            }
        } while (!ownerSurname.matches(surnameRegex) && !isUnique);
        return ownerSurname;
    }

    public String createUniqueDni() {
        String dni;
        boolean isUnique;

        do {
            isUnique = true;
            int number = (int)(Math.random() * 100000000);
            char letter = (char)('A' + (int)(Math.random() * 26));
            dni = String.format("%08d%c", number, letter);

            for (Owner owner : owners) {
                if (owner.getDni().equals(dni)) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        return dni;
    }
}
