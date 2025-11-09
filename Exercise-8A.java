package LAB;
import java.util.Scanner;

class WordThread implements Runnable {
    String text;

    WordThread(String text) {
        this.text = text;
    }

    public void run() {
        String[] words = text.split("\\s+");
        for (String w : words) {
            System.out.println("Word: " + w);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

class VowelThread implements Runnable {
    String text;

    VowelThread(String text) {
        this.text = text;
    }

    public void run() {
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                System.out.println("Vowel: " + c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        }
    }
}

public class EXERCISE_8A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String para = sc.nextLine();

        Thread t1 = new Thread(new WordThread(para));
        Thread t2 = new Thread(new VowelThread(para));

        t1.start();
        t2.start();
    }
}
