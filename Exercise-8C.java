package LAB;
import java.util.Scanner;

class TableThread extends Thread {
    int num;

    TableThread(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

class DivisorThread extends Thread {
    int num;

    DivisorThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Factors of " + num + " are:");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        }
    }
}

public class EXERCISE_8C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        TableThread t1 = new TableThread(n);
        DivisorThread t2 = new DivisorThread(n);

        t1.start();
        t2.start();
    }
}
