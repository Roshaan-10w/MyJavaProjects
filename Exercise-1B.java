

import java.util.Scanner;

public class Electricity{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] units = new int[12];
        int total = 0;

        System.out.println("Enter electricity usage for 12 months:");

        for (int i = 0; i < 12; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            units[i] = sc.nextInt();
            total += units[i];
        }

        double average = total / 12.0;

        System.out.println("\nTotal Units Consumed: " + total);
        System.out.println("Average Monthly Usage: " + average);

        if (average > 500) {
            System.out.println("High Consumption Alert!");
        }
        sc.close();
    }
}






