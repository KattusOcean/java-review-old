package module4Objects.exercises.antiqueCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class AntiqueCollection {
    Scanner sc = new Scanner(System.in);
    ArrayList<Antique> antiques = new ArrayList<>();

    // Adds an object to the arraylist
    public void addAntique(Antique antique) {
        antiques.add(antique);
        System.out.println("Antiqued added correctly");
    }

    // Shows the current objects in the arraylist
    public void listAntiques() {
        int count = 1;
        for (Antique antique : antiques) {
            System.out.println("--- ANTIQUE Nº" + (count++) + " ---");
            System.out.println(antique.toString());
        }
    }

    // Allows the user to edit the objects characteristics
    public void editAntique(int code) {
        boolean isFound = false;

        while (true) {
            for (Antique antique : antiques) {
                // Creates the menu
                if (code == antique.getCode()) {
                    System.out.println("~~~ EDIT OPTIONS ~~~");
                    System.out.println("1. Fabrication date");
                    System.out.println("2. Origin");
                    System.out.println("3. Price");

                    // Depending on the objects show its unique characteristic
                    switch (antique) {
                        case Jewel jewel -> System.out.println("4. Material");
                        case Book book -> System.out.println("4. Author");
                        case Watch watch -> System.out.println("4. Brand");
                        case Painting painting -> System.out.println("4. Technique");
                        default -> System.out.println("Invalid option!");
                    }

                    System.out.println("0. Go back");
                    System.out.print("Select an option: ");
                    int editOption = sc.nextInt();
                    sc.nextLine();

                    // Allows the user to modify the editable characteristics
                    switch (editOption) {
                        case 1:
                            System.out.print("New fabrication date: ");
                            String newFabricationDate = sc.nextLine();
                            antique.setFabricationDate(newFabricationDate);
                            break;

                        case 2:
                            System.out.print("New origin: ");
                            String newOrigin = sc.nextLine();
                            antique.setOrigin(newOrigin);
                            break;

                        case 3:
                            System.out.print("New price: ");
                            float newPrice = sc.nextFloat();
                            antique.setPrice(newPrice);
                            sc.nextLine();
                            break;

                        case 4:
                            if (antique instanceof Jewel) {
                                System.out.print("New material: ");
                                String newMaterial = sc.nextLine();
                                ((Jewel) antique).setMaterial(newMaterial);

                            } else if (antique instanceof Book) {
                                System.out.print("New author: ");
                                String newAuthor = sc.nextLine();
                                ((Book) antique).setAuthor(newAuthor);

                            } else if (antique instanceof Watch) {
                                System.out.print("New brand: ");
                                String newBrand = sc.nextLine();
                                ((Watch) antique).setBrand(newBrand);

                            } else if (antique instanceof Painting) {
                                System.out.print("New technique: ");
                                String newTechnique = sc.nextLine();
                                ((Painting) antique).setTechnique(newTechnique);
                            }
                            break;

                        case 0:
                            System.out.println("Going back...");
                            return;

                        default:
                            System.out.println("Introduce a valid option!");
                            break;
                    }
                }
            }

            if (!isFound) {
                System.out.println("Antique not found. Introduce another code!");
            }
        }
    }

    // Search an object by its unique code
    public void searchAntique(int code) {
        boolean isFound = false;

        for (Antique antique : antiques) {
            if (code == antique.getCode()) {
                System.out.println(antique);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Antique not found. Introduce another code!");
        }
    }

    // Remove an object by its unique code
    public void removeAntique(int code) {
        boolean isFound = false;

        for (int i = 0; i < antiques.size(); i++) {
            if (code == antiques.get(i).getCode()) {
                antiques.remove(i);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Antique not found. Introduce another code!");
        }
    }

    // Generates an unique code for every new object
    public int generateCode() {
        int code;
        boolean exists;

        do {
            code = (int) Math.round(Math.random() * 1000);
            exists = false;

            for (Antique antique : antiques) {
                if (code == antique.getCode()) {
                    exists = true;
                    break;
                }
            }
        } while (exists);

        return code;
    }
}
