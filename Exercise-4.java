import java.util.Scanner;

class FoodOrder {
    int orderID;
    String foodItem;
    double price;
    int quantity;

    // Constructor
    FoodOrder(int orderID, String foodItem, double price, int quantity) {
        this.orderID = orderID;
        this.foodItem = foodItem;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total bill
    double calculateTotal() {
        double total = (price * quantity) + 50; // + ₹50 delivery charge
        return total;
    }
}

public class FoodOrderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First order
        System.out.println("Enter details for Order 1:");
        System.out.print("Order ID: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Food Item: ");
        String item1 = sc.nextLine();
        System.out.print("Price: ");
        double price1 = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty1 = sc.nextInt();

        // Second order
        System.out.println("\nEnter details for Order 2:");
        System.out.print("Order ID: ");
        int id2 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Food Item: ");
        String item2 = sc.nextLine();
        System.out.print("Price: ");
        double price2 = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty2 = sc.nextInt();

        // Create two FoodOrder objects
        FoodOrder order1 = new FoodOrder(id1, item1, price1, qty1);
        FoodOrder order2 = new FoodOrder(id2, item2, price2, qty2);

        // Display total bill for each
        System.out.println("\n--- BILL DETAILS ---");
        System.out.println("Order ID: " + order1.orderID + " | Food: " + order1.foodItem + " | Total Bill = ₹" + order1.calculateTotal());
        System.out.println("Order ID: " + order2.orderID + " | Food: " + order2.foodItem + " | Total Bill = ₹" + order2.calculateTotal());

        sc.close();
    }
}
