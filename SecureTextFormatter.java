import java.util.Scanner;

public class SecureTextFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine().strip();

        System.out.print("Enter email: ");
        String email = sc.nextLine().strip();

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine().strip();

        // 1. Title Case
        String[] nameWords = fullName.toLowerCase().split("\\s+");

        String formattedName = "";

        for (String word : nameWords) {
            formattedName += word.substring(0, 1).toUpperCase()
                    + word.substring(1) + " ";
        }

        formattedName = formattedName.strip();

        // 2. Mask email
        int atIndex = email.indexOf("@");

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex);

        String maskedUsername;

        if (username.length() > 3) {
            maskedUsername = username.substring(0, 3)
                    + "*".repeat(username.length() - 3);
        } else {
            maskedUsername = "*".repeat(username.length());
        }

        String maskedEmail = maskedUsername + domain;

        // 3. Email validation
        boolean validEmail = email.matches(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        );

        // 4. Reverse each word
        String[] words = sentence.split("\\s+");
        String reversedSentence = "";

        for (String word : words) {
            String reversed = new StringBuilder(word)
                    .reverse()
                    .toString();

            reversedSentence += reversed + " ";
        }

        reversedSentence = reversedSentence.strip();

        // 5. Count vowels
        int vowelCount = 0;

        char[] chars = sentence.toLowerCase().toCharArray();

        for (char ch : chars) {
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        // 6. == and equals()
        String str1 = new String("Java");
        String str2 = new String("Java");

        System.out.println("Formatted Name : " + formattedName);
        System.out.println("Masked Email : " + maskedEmail);
        System.out.println("Valid Email : " + validEmail);
        System.out.println("Reversed Words : " + reversedSentence);
        System.out.println("Vowel Count : " + vowelCount);

        System.out.println("Using == : " + (str1 == str2));
        System.out.println("Using equals() : " + str1.equals(str2));
    }
}