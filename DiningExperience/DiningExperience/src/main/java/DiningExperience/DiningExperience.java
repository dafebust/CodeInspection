package DiningExperience;

import java.util.Scanner;

public class DiningExperience {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCost = 5; // base cost for a dining experience
        int mealCount = 0;
        int mealQuantity = 0;
        int maxOrderQuantity = 100;
        int specialOfferDiscount = 0;

        // Define the menu and prices
        String[] menu = {"Burger", "Pizza", "Pasta", "Salad"};
        int[] prices = {10, 12, 15, 8};

        // Display the menu
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + ". " + menu[i] + " - $" + prices[i]);
        }

        // Take user input for meal selection and quantity
        while (true) {
            System.out.print("Enter the meal number (1-" + menu.length + ") or 0 to exit: ");
            int mealNumber = scanner.nextInt();
            if (mealNumber == 0) {
                break;
            } else if (mealNumber < 1 || mealNumber > menu.length) {
                System.out.println("Invalid meal number. Please try again.");
                continue;
            }
            System.out.print("Enter the quantity: ");
            mealQuantity = scanner.nextInt();
            if (mealQuantity <= 0) {
                System.out.println("Invalid quantity. Please try again.");
                continue;
            } else if (mealQuantity > maxOrderQuantity) {
                System.out.println("Maximum order quantity is " + maxOrderQuantity + ". Please try again.");
                continue;
            }
            mealCount += mealQuantity;
            totalCost += mealQuantity * prices[mealNumber - 1];
        }

        // Calculate the cost based on the meal count
        if (mealCount > 5 && mealCount <= 10) {
            totalCost *= 0.9;
        } else if (mealCount > 10) {
            totalCost *= 0.8;
        }

        // Check for special offer discounts
        if (totalCost > 50 && totalCost <= 100) {
            specialOfferDiscount = 10;
        } else if (totalCost > 100) {
            specialOfferDiscount = 25;
        }
        totalCost -= specialOfferDiscount;

        // Display the order summary and ask for confirmation
        System.out.println("Order Summary:");
        for (int i = 0; i < menu.length; i++) {
            if (prices[i] > 0) {
                System.out.println(menu[i] + " x " + mealCount(menu[i]) + " - $" + mealCount(menu[i]) * prices[i]);
            }
        }
        System.out.println("Total Cost: $" + totalCost);
        System.out.print("Confirm order (Y/N)? ");
        String confirmation = scanner.next();
        if (confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Order confirmed. Total cost: $" + totalCost);
        } else {
            System.out.println("Order canceled.");
            totalCost = -1;
        }
    }

    // Method to count the number of times a meal appears in the order
    public static int mealCount(String meal) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the quantity of " + meal + ": ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please try again.");
                continue;
            }
            count = quantity;
            break;
        }
        return count;
    }
}
