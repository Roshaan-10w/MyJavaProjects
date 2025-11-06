import java.util.Scanner;

// Base class
class Worker {
    String name;
    double salaryRate;

    Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    double computePay(int hours) {
        return hours * salaryRate;
    }
}

// Subclass 1: DailyWorker
class DailyWorker extends Worker {
    int no_of_days;

    DailyWorker(String name, double salaryRate, int no_of_days) {
        super(name, salaryRate);
        this.no_of_days = no_of_days;
    }

    @Override
    double computePay(int hours) {
        return no_of_days * salaryRate;
    }
}

// Subclass 2: SalariedWorker
class SalariedWorker extends Worker {
    int no_of_hours;

    SalariedWorker(String name, double salaryRate, int no_of_hours) {
        super(name, salaryRate);
        this.no_of_hours = no_of_hours;
    }

    @Override
    double computePay(int hours) {
        // Salaried worker always gets paid for 40 hours per week
        return 40 * salaryRate;
    }
}

// Main class with menu-driven polymorphism
public class WorkerInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker worker = null;

        while (true) {
            System.out.println("\n--- Worker Pay Calculation Menu ---");
            System.out.println("1. Daily Worker");
            System.out.println("2. Salaried Worker");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            sc.nextLine(); // consume newline
            System.out.print("Enter Worker Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Salary Rate (per hour/day): ");
            double rate = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of days worked: ");
                    int days = sc.nextInt();
                    worker = new DailyWorker(name, rate, days);
                    break;

                case 2:
                    System.out.print("Enter number of hours worked: ");
                    int hours = sc.nextInt();
                    worker = new SalariedWorker(name, rate, hours);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            // Run-time Polymorphism: computePay() called based on actual object type
            double pay = worker.computePay(0);
            System.out.println("\nWorker Name: " + worker.name);
            System.out.println("Total Weekly Pay: ₹" + pay);
        }

        sc.close();
    }
}
