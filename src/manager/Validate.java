package manager;

import java.util.Scanner;

public class Validate {
    public Validate(){

    }
    public int number(Scanner scanner){
        int choice = 0;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter number:");
            }
            if (choice < 0){
                choice = 0;
                System.out.println("Number > 0 ");
            }
        }while (choice == 0);
        return choice;
    }
    public double priceProduct(Scanner scanner){
        double price = 0;
        do {
            try {
                price = Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Enter number:");
            }
            if(price < 0){
                price = 0;
                System.out.println("Enter price > 0:");
            }
        }while (price == 0);
        return price;
    }
}
