package Utils;

import java.util.Arrays;

public class StringAnalyzer {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return false;
        String clean = s.replaceAll("[^A-Za-z]", "").toLowerCase();
        return new StringBuilder(clean).reverse().toString().equals(clean);
    }

    public int countVowels(String s) {
        if (s == null)
            return 0;
        int count = 0;
        String lower = s.toLowerCase();
        for (char c : lower.toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                count++;
        }
        return count;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return false;
        String clean1 = s1.replaceAll("\\s", "").toLowerCase();
        String clean2 = s2.replaceAll("\\s", "").toLowerCase();
        if (clean1.length() != clean2.length())
            return false;

        char[] arr1 = clean1.toCharArray();
        char[] arr2 = clean2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}