import java.util.Scanner;

public class TextNormalizer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // 1. Remove leading and trailing whitespace
        String cleaned = str.trim();

        // Demonstrating strip()
        cleaned = cleaned.strip();

        // 2. Check if empty
        if (cleaned.isEmpty()) {
            System.out.println("EMPTY STRING");
            return;
        }

        // 3. Check for reserved word
        if (cleaned.equalsIgnoreCase("admin")) {
            System.out.println("RESERVED WORD");
            return;
        }

        // 4. Replace underscore with space
        cleaned = cleaned.replace("_", " ");

        // 5. Check startsWith and endsWith
        String lower = cleaned.toLowerCase();

        if (lower.startsWith("temp") && lower.endsWith("user")) {
            cleaned = cleaned.concat(" FLAGGED");
        }

        // 6. Final result
        System.out.println(cleaned);
    }
}