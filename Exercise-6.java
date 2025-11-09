import java.util.Scanner;

// Step 1: Create Interface
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    void viewBalance();
    void viewAccountDetails();
}

// Step 2: Create Abstract Class
abstract class Account {
    String acc_name;
    String acc_no;
    double balance;

    Account(String acc_name, String acc_no, double balance) {
        this.acc_name = acc_name;
        this.acc_no = acc_no;
        this.balance = balance;
    }
}

// Step 3: Create Bank Class implementing Transaction and inheriting Account
class Bank extends Account implements Transaction {

    Bank(String acc_name, String acc_no, double balance) {
        super(acc_name, acc_no, balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void viewBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void viewAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder Name : " + acc_name);
        System.out.println("Account Number       : " + acc_no);
        System.out.println("Balance              : ₹" + balance);
    }
}

// Step 4: Main Class for Menu Driven Operations
public class MainBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        Bank b = new Bank(name, accNo, bal);

        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    b.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    b.withdraw(wd);
                    break;

                case 3:
                    b.viewBalance();
                    break;

                case 4:
                    b.viewAccountDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using our Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
