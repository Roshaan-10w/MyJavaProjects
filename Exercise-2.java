1. Develop a program to store given N numbers in an Array. Find out the sum of all the odd numbers and even numbers separately from the array and display the same.
Example: -
Enter the numbers: 4892110 34 31
Output: Even-58 Odd = 41


import java.util.*;

public class SumOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int evenSum = 0, oddSum = 0;

        for (int num : arr) {
            if (num % 2 == 0)
                evenSum += num;
            else
                oddSum += num;
        }

        System.out.println("Even = " + evenSum + "  Odd = " + oddSum);
        sc.close();
    }
}


