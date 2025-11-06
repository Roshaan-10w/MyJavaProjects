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


2. Given an integer array with unique and duplicate numbers. Find all the unique numbers and count those numbers. Finally display all the unique numbers and display the count also.
Example Input: Enter the numbers: 2621 45 3 1 X=5
Output: Count=3 Unique numbers are = 6,45,3


import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Display unique numbers
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                uniqueList.add(num);
            }
        }

        System.out.println("Count = " + uniqueList.size());
        System.out.print("Unique numbers are = ");
        for (int i = 0; i < uniqueList.size(); i++) {
            System.out.print(uniqueList.get(i));
            if (i < uniqueList.size() - 1)
                System.out.print(", ");
        }

        sc.close();
    }
}



