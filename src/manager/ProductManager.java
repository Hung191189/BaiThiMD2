package manager;

import products.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productsList;
    Scanner scanner;
    Validate validate;
    public ProductManager() {
        productsList = new ArrayList<>();
        scanner = new Scanner(System.in);
        validate = new Validate();
    }

    public void createProduct() {
        System.out.println("Enter product code:");
        int code = validate.number(scanner);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        double price = validate.priceProduct(scanner);
        System.out.println("Enter product quantity: ");
        int quantity = validate.number(scanner);
        System.out.println("Enter product status: ");
        String status = scanner.nextLine();
        Product product = new Product(code, name, price, quantity, status);
        productsList.add(product);

    }

    public void importData() {
        ArrayList<String[]> listData = new ArrayList<>();
        try {
           File file = new File("src/products.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listData.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        for (int i = 0; i < listData.size(); i++) {
            int id = Integer.parseInt(listData.get(i)[0]);
            String name = listData.get(i)[1];
            double price = Double.parseDouble(listData.get(i)[2]);
            int quantity = Integer.parseInt(listData.get(i)[3]);
            String description = listData.get(i)[4];
            Product product = new Product(id, name, price, quantity, description);
            productsList.add(product);
        }
    }
    public void exportData() {
        try {
            File fileProducts = new File("src/products.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileProducts));
            for (Product p : productsList) {
                bw.write(p.getCode() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity()+ ","  + p.getStatus() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public void displayProduct() {
        for (Product item : productsList) {
            System.out.println(item);
        }
    }

    public Product findByCode() {
        int code = validate.number(scanner);
        for (Product item : productsList) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

    public void updateProduct() {
        System.out.println("Enter product code you want to update: ");
        Product product = findByCode();
        if (product == null) {
            System.out.println("Not found product!!!");
        } else {
            System.out.println("Enter new product code:");
            int newCode = validate.number(scanner);
            System.out.println("Enter new product name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new product price: ");
            double newPrice = validate.priceProduct(scanner);
            System.out.println("Enter new product quantity: ");
            int newQuantity = validate.number(scanner);
            System.out.println("Enter new product status: ");
            String newStatus = scanner.nextLine();
            product.setCode(newCode);
            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            product.setStatus(newStatus);
            System.out.println("Update successfully!!!");
        }
    }

    public void deleteProduct() {
        System.out.println("Enter product code you want to delete: ");
        displayProduct();
        Product product = findByCode();
        if (product == null) {
            System.out.println("Not found product!!!");
        } else {
            System.out.println("Press 'Y' to delete product");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                productsList.remove(product);
                System.out.println("Delete successfully!!!");
            }
        }
    }
    public void sortByPriceUp(PriceSortUp priceSortUp){
        productsList.sort(priceSortUp);
    }
    public void sortByPriceDown(PriceSortDown priceSortDown){
        productsList.sort(priceSortDown);
    }
    public Product findExpensiveProduct(PriceSortUp priceSortUp){
        sortByPriceUp(priceSortUp);
        return productsList.get(productsList.size() -1);
    }

}
