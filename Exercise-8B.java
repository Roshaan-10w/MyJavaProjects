package LAB;
import java.util.Scanner;

class EvenThread extends Thread {
    int[] arr;

    EvenThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.println("Even: " + num);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class OddThread extends Thread {
    int[] arr;

    OddThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int num : arr) {
            if (num % 2 != 0) {
                System.out.println("Odd: " + num);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class Exercise_8B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 numbers:");  // visible prompt
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();

        EvenThread even = new EvenThread(numbers);
        OddThread odd = new OddThread(numbers);

        even.start();
        odd.start();

        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
