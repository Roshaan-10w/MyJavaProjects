Program
1.	A cinema offers discount based on age and day of booking
•	Age < 5: Free
•	Age 5–18: 40% discount
•	Age 19–60: Full price
•	Age > 60: 30% discount
•	Also, if the customer is booking during weekdays (Mon–Fri) – Additional 10% discount.
Develop a program that takes the user’s age, day of booking and prints the ticket price message accordingly. Assume the base ticket price is ₹200.

import java.util.Scanner;

public class Ticket_booking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter day of booking (1-7): ");
        int day = sc.nextInt();

        if (age < 5) {
            System.out.println("The Ticket is free");
        } 
        else if (age >= 5 && age <= 18 && day >= 1 && day <= 5) {
            double price = 200 - (0.5 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age >= 5 && age <= 18 && day >= 6 && day <= 7) {
            double price = 200 - (0.4 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age >= 19 && age <= 60 && day >= 1 && day <= 5) {
            double price = 200 - (0.1 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age > 60 && day >= 1 && day <= 5) {
            double price = 200 - (0.4 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age > 60 && day >= 6 && day <= 7) {
            double price = 200 - (0.3 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else {
            System.out.println("The Ticket costs 200");
        }

        sc.close();
    }
}






2.	A customer uses electricity for 12 months. 
•	Accept unit usage for each month.
•	Calculate the total units and average monthly usage.
•	If average monthly usage > 500 units, print a warning: "High Consumption Alert!"
Develop a Java program to read monthly electricity usage (in units), calculate the total and average, and display the same with a warning if needed.

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






3.	Design a simple ATM system that allows the user to perform banking operations. The system should repeatedly offer the following operations: (Assume Bank Balance is 100000)
i.	Check account balance 
ii.	Deposit money
iii.	Withdraw money
iv.	Exit the application

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        double balance = 10000.0;
        int choice;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check account balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: Rs. " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Amount deposited successfully.");
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Please collect your cash.");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        System.out.println("Invalid withdrawal amount!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
















4.	The system randomly selects a number between 1 to 100. The user keeps guessing until they get it right. After each guess, display:
•	"Too High"
•	"Too Low"
•	"Correct Guess!"
Develop a program that implements this guessing game. (Use Random class from java.util package for generating random numbers)

import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int numberToGuess = rand.nextInt(100) + 1;
        int guess, attempts = 0;
        System.out.println("Guess the number between 1 and 100:");
        while (true) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess > numberToGuess) {
                System.out.println("Too High");
            } else if (guess < numberToGuess) {
                System.out.println("Too Low");
            } else {
                System.out.println("Correct Guess in " + attempts + " attempts!");
                break;
            }
        }
    }
}

