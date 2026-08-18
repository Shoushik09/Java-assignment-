import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        // 1. Word count
        System.out.println("Word Count : " + words.length);

        // 2. First and last word using substring
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        // Demonstrating substring()
        firstWord = firstWord.substring(0, firstWord.length());
        lastWord = lastWord.substring(0, lastWord.length());

        System.out.println("First Word : " + firstWord);
        System.out.println("Last Word : " + lastWord);

        // 3. First and last occurrence of J
        int firstIndex = sentence.indexOf('J');
        int lastIndex = sentence.lastIndexOf('J');

        System.out.println("First 'J' index : " + firstIndex);
        System.out.println("Last 'J' index : " + lastIndex);

        // 4. Lexicographic comparison
        int comparison = firstWord.compareTo(lastWord);

        System.out.println("Comparison (first vs last word) : " + comparison);

        // 5. Convert sentence to character array
        char[] characters = sentence.toCharArray();

        char firstCharacter = characters[0];

        // String.valueOf() demonstration
        String firstCharString = String.valueOf(firstCharacter);

        // charAt() demonstration
        char sameCharacter = sentence.charAt(0);

        System.out.println("First Character : " + firstCharString);
        System.out.println("ASCII Value : " + (int) sameCharacter);
    }
}