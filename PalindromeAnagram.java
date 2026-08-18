import java.util.Arrays;
import java.util.Scanner;

public class PalindromeAnagram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        System.out.print("Enter third string: ");
        String str3 = sc.nextLine();

        // Remove spaces and punctuation
        String cleaned1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 1. Palindrome check
        String reverse = new StringBuilder(cleaned1)
                .reverse()
                .toString();

        boolean palindrome = cleaned1.equals(reverse);

        // 2. Anagram check
        String a = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String b = str3.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean anagram = Arrays.equals(arr1, arr2);

        // 3. Regex validation
        boolean valid = cleaned1.matches("[a-zA-Z0-9]+");

        // 4. Contains substring
        boolean containsPlan = cleaned1.contains("plan");

        // 5. String.format()
        String report = String.format(
                "Palindrome : %b | Anagram : %b",
                palindrome, anagram
        );

        // String.join()
        String finalReport = String.join("\n",
                "Palindrome Check : " + str1 + " -> " + palindrome,
                "Anagram Check : " + str2 + " & " + str3 + " -> " + anagram,
                "Formatted Report : [ " + report + " ]",
                "Contains 'plan' : " + containsPlan
        );

        System.out.println(finalReport);

        // 6. String pool demonstration
        String s1 = new String("Java");
        String s2 = new String("Java");

        String i1 = s1.intern();
        String i2 = s2.intern();

        System.out.println(
                "HashCodes equal for interned strings : "
                + (i1.hashCode() == i2.hashCode())
        );
    }
}