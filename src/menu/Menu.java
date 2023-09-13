package menu;

import manager.*;
import products.Product;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Validate validate = new Validate();
    ProductManager productManager = new ProductManager();
    PriceSortUp priceSortUp = new PriceSortUp();
    PriceSortDown priceSortDown = new PriceSortDown();
    Scanner scanner =new Scanner(System.in);
    public void menu(){
        do {
        System.out.println("MENU");
        System.out.println("1. Display Product");
        System.out.println("2. Create Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Sort Up By Price");
        System.out.println("6. Sort Down By Price");
        System.out.println("7. Find Expensive Product");
        System.out.println("8. Write Product From File");
        System.out.println("9. Read Product To File");
        System.out.println("0. Exit");
        System.out.println("Choice ");
        int choice = validate.number(scanner);
        switch (choice) {
            case 1:
                productManager.displayProduct();
                break;
            case 2:
               productManager.createProduct();
                break;
            case 3:
                productManager.updateProduct();
                break;
            case 4:
                productManager.deleteProduct();
                break;
            case 5:
                productManager.sortByPriceUp(priceSortUp);
                break;
            case 6:
                productManager.sortByPriceDown(priceSortDown);
                break;
            case 7:
                productManager.findExpensiveProduct(priceSortUp);
                break;
            case 8:
                productManager.exportData();
                break;
            case 9:
                productManager.importData();
                break;
            case 0:
                System.exit(0);
        }
        }while (true);
    }
}