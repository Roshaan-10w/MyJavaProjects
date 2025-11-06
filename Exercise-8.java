//Q1)

import java.util.Scanner;

class WordThread implements Runnable {
    private String text;

    WordThread(String text) {
        this.text = text;
    }

    public void run() {
        String[] words = text.split("\\s+");
        for (String word : words) {
            System.out.println(word);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class VowelThread implements Runnable {
    private String text;

    VowelThread(String text) {
        this.text = text;
    }

    public void run() {
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                System.out.println(c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String paragraph = sc.nextLine();

        Thread t1 = new Thread(new WordThread(paragraph));
        Thread t2 = new Thread(new VowelThread(paragraph));

        t1.start();
        t2.start();
        sc.close();
    }
}



//Q2)

import java.util.Scanner;

// Thread 1: Prints even numbers
class EvenThread extends Thread {
    int[] numbers;

    EvenThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        for (int n : numbers) {
            if (n % 2 == 0) {
                System.out.println("Even: " + n);
                try {
                    Thread.sleep(2000); // 2 seconds delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

// Thread 2: Prints odd numbers
class OddThread extends Thread {
    int[] numbers;

    OddThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        for (int n : numbers) {
            if (n % 2 != 0) {
                System.out.println("Odd: " + n);
                try {
                    Thread.sleep(2000); // 2 seconds delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        EvenThread even = new EvenThread(numbers);
        OddThread odd = new OddThread(numbers);

        even.start();
        odd.start();

        sc.close();
    }
}



//Q3)

import java.util.Scanner;

class TableAndDivisorThread extends Thread {
    int num;

    TableAndDivisorThread(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            // Print divisor
            System.out.println("Divisor: " + i);

            // Print multiplication table
            System.out.println(num + " x " + i + " = " + (num * i));

            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        TableAndDivisorThread t1 = new TableAndDivisorThread(num);
        t1.start(); // Start the single combined thread

        sc.close();
    }
}

