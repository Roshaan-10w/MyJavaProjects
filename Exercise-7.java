package LAB;
import java.util.Scanner;

class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}


class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

class IdException extends Exception {
    public IdException(String message) {
        super(message);
    }
}

class Employee {
    String name;
    int id;
    int age;

    public Employee(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void display() {
        System.out.println("\n Employee Object Created Successfully!");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
    }
}

public class EXERCISE_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();

            if (name.matches("\\d+") || name.trim().isEmpty()) {
                throw new NameException(" Invalid Name: Name cannot be a number or empty!");
            }

            if (id <= 0) {
                throw new IdException(" Invalid ID: ID must be greater than zero!");
            }

            if (age < 18 || age > 50) {
                throw new AgeException(" Invalid Age: Age must be below 50!");
            }

            Employee emp = new Employee(name, id, age);
            emp.display();

        } catch (NameException | AgeException | IdException e) {
            System.out.println("\nException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nInvalid Input! " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
