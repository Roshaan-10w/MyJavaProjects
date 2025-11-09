
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



