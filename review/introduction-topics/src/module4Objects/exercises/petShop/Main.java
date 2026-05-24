package module4Objects.exercises.petShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option, ean;
        String dni, petName, chip1, chip2;

        Shop shop = new Shop();

        for (int i = 0; i < 5; i++) {
            shop.animals.add(new Dog(shop));
            shop.animals.add(new Cat(shop));
            shop.animals.add(new Bird(shop));
            shop.animals.add(new Rat(shop));
        }

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("0. Show available animals");
            System.out.println("1. Sell animal and show price");
            System.out.println("2. Show total animals sold");
            System.out.println("3. Show total pets available");
            System.out.println("4. Show total animals sold individually");
            System.out.println("5. Show pet owner with the DNI");
            System.out.println("6. Show chip number and name of a pet by its name");
            System.out.println("7. Show animal characteristics by EAN");
            System.out.println("8. Show if two pets can mate by the chip");
            System.out.println("9. Show animals liked food");
            System.out.println("10. Exit");
            System.out.print("Select an option: ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("************************************************************");

            switch (option) {
                case 0:
                    shop.quickShowAnimals();
                    break;

                case 1:
                    System.out.print("Introduce the EAN: ");
                    ean = sc.nextInt();
                    sc.nextLine();
                    shop.sellAnimal(ean);
                    break;

                case 2:
                    shop.showTotalAnimalsSold();
                    break;

                case 3:
                    shop.showTotalPetsAvailable();
                    break;

                case 4:
                    shop.showTotalAvailableAnimalsIndividually();
                    break;

                case 5:
                    System.out.print("Introduce the owner DNI: ");
                    dni = sc.nextLine();
                    shop.showPetOwnerByDni(dni);
                    break;

                case 6:
                    System.out.print("Introduce pet name: ");
                    petName = sc.nextLine();
                    shop.showNumberAndChipOfPetByName(petName);
                    break;

                case 7:
                    System.out.print("Introduce the EAN: ");
                    ean = sc.nextInt();
                    sc.nextLine();
                    shop.showAnimalCharacteristicsByEan(ean);
                    break;

                case 8:
                    System.out.print("Introduce the first chip: ");
                    chip1 = sc.nextLine();
                    System.out.print("Introduce the second chip: ");
                    chip2 = sc.nextLine();
                    shop.showIfCanMateByChip(chip1, chip2);
                    break;

                case 9:
                    shop.showAnimalLikedFood();
                    break;

                case 10:
                    System.out.println("Terminating process...!");
                    return;
            }
        }
    }
}
