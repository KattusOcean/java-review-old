package module4Objects.exercises.edibleShop;

public class Shop {

    Products[] products = new Products[4];

    public Shop() {
    }

    public Shop(Products[] products) {
        this.products = products;
    }

    public void addProduct(Products p) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = p;
                break;
            }
        }
    }

    public void listProducts() {
        for (int i = 0; i < products.length; i++) {
            System.out.println("--- PRODUCT Nº" + (i+1) + " ---");
            System.out.println(products[i].toString());
        }
    }
}
