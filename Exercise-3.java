
import java.util.Scanner;
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = sc.nextLine();
        char firstChar = str.charAt(0); 
        String restOfString = str.substring(1); 
        String modifiedRest = restOfString.replace(firstChar, '$'); 
        String newStr = firstChar + modifiedRest; 
        System.out.println(newStr); 
        sc.close();
    }
}

