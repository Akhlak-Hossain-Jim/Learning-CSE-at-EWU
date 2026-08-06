package Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringAnalyzerTest {
    private final StringAnalyzer analyzer = new StringAnalyzer();

    @Test
    @DisplayName("Test Palindrome with mixed case and spaces")
    void testIsPalindromeValid() {
        assertTrue(analyzer.isPalindrome("RaceCar"));
    }

    @Test
    @DisplayName("Test Palindrome with null and empty inputs")
    void testIsPalindromeEdgeCases() {
        assertFalse(analyzer.isPalindrome(null));
        assertFalse(analyzer.isPalindrome(""));
    }

    @Test
    @DisplayName("Test Vowel Counter for various scenarios")
    void testCountVowels() {
        assertEquals(3, analyzer.countVowels("Hello World"));
        assertEquals(0, analyzer.countVowels("rhythm"));
        assertEquals(0, analyzer.countVowels(null));
    }

    @Test
    @DisplayName("Test Anagram with case-insensitivity")
    void testIsAnagramValid() {
        assertTrue(analyzer.isAnagram("Listen", "Silent"));
    }

    @Test
    @DisplayName("Test Anagram with invalid inputs")
    void testIsAnagramInvalid() {
        assertFalse(analyzer.isAnagram("hello", "world"));
        assertFalse(analyzer.isAnagram(null, "test"));
    }
}