
import java.util.Scanner;

public class q6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String encoded = ""; 
        int count = 1;       
        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++; 		// if same letter then  increase count
            } else {
                encoded = encoded + str.charAt(i - 1) + count; 		// Add char and count
                count = 1; 		// Reset count
            }}
        System.out.println("Encoded string:  " + encoded);
        sc.close();
    }}
