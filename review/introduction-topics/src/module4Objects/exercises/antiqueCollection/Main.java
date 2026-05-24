package module4Objects.exercises.antiqueCollection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option, code;
        String fabricationDate, origin, material, author, brand, technique;
        float price;

        AntiqueCollection antiqueCollection = new AntiqueCollection();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Add antique");
            System.out.println("2. List antiques");
            System.out.println("3. Search antique");
            System.out.println("4. Edit antique");
            System.out.println("5. Remove antique");
            System.out.println("0. Exit");

            System.out.print("Select an option: ");
            option = sc.nextInt();
            System.out.println("********************************");
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("--- ANTIQUE OPTIONS ---");
                    System.out.println("1. Jewel");
                    System.out.println("2. Book");
                    System.out.println("3. Watch");
                    System.out.println("4. Painting");
                    System.out.print("Select and option: ");
                    int antiqueOption = sc.nextInt();
                    sc.nextLine();

                    System.out.println("********************************");

                    if (antiqueOption == 1) {
                        System.out.println("~~~ JEWEL DATA ~~~");
                        System.out.print("Fabrication date: ");
                        fabricationDate = sc.nextLine();
                        System.out.print("Origin: ");
                        origin = sc.nextLine();
                        System.out.print("Price: ");
                        price = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Material: ");
                        material = sc.nextLine();

                        code = antiqueCollection.generateCode();
                        Jewel jewel = new Jewel(code, fabricationDate, origin, price, material);
                        antiqueCollection.addAntique(jewel);
                        System.out.println("********************************");
                        break;

                    } else if (antiqueOption == 2) {
                        System.out.println("~~~ BOOK DATA ~~~");
                        System.out.print("Fabrication date: ");
                        fabricationDate = sc.nextLine();
                        System.out.print("Origin: ");
                        origin = sc.nextLine();
                        System.out.print("Price: ");
                        price = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Author: ");
                        author = sc.nextLine();

                        code = antiqueCollection.generateCode();
                        Book book = new Book(code, fabricationDate, origin, price, author);
                        antiqueCollection.addAntique(book);
                        System.out.println("********************************");
                        break;

                    } else if (antiqueOption == 3) {
                        System.out.println("~~~ WATCH DATA ~~~");
                        System.out.print("Fabrication date: ");
                        fabricationDate = sc.nextLine();
                        System.out.print("Origin: ");
                        origin = sc.nextLine();
                        System.out.print("Price: ");
                        price = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Brand: ");
                        brand = sc.nextLine();

                        code = antiqueCollection.generateCode();
                        Watch watch = new Watch(code, fabricationDate, origin, price, brand);
                        antiqueCollection.addAntique(watch);
                        System.out.println("********************************");
                        break;

                    } else if (antiqueOption == 4) {
                        System.out.println("~~~ PAINTING DATA ~~~");
                        System.out.print("Fabrication date: ");
                        fabricationDate = sc.nextLine();
                        System.out.print("Origin: ");
                        origin = sc.nextLine();
                        System.out.print("Price: ");
                        price = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Technique: ");
                        technique = sc.nextLine();

                        code = antiqueCollection.generateCode();
                        Painting painting = new Painting(code, fabricationDate, origin, price, technique);
                        antiqueCollection.addAntique(painting);
                        System.out.println("********************************");
                        break;
                    }

                case 2:
                    antiqueCollection.listAntiques();
                    System.out.println("********************************");
                    break;

                case 3:
                    System.out.print("Introduce the code: ");
                    code = Integer.parseInt(sc.nextLine());
                    antiqueCollection.searchAntique(code);
                    System.out.println("********************************");

                    break;

                case 4:
                    System.out.print("Introduce the code: ");
                    code = Integer.parseInt(sc.nextLine());
                    antiqueCollection.editAntique(code);
                    System.out.println("********************************");
                    break;

                case 5:
                    System.out.print("Introduce the code: ");
                    code = Integer.parseInt(sc.nextLine());
                    antiqueCollection.removeAntique(code);
                    System.out.println("********************************");
                    break;

                case 0:
                    System.out.println("Terminating process...");
                    sc.close();
                    return;
            }
        }
    }
}
