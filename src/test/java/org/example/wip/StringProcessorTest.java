package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    @Test
    void reverse_withSimpleString_returnsReversed() {
        // Arrange
        var processor = new StringProcessor();
        var input = "hello";

        // Act
        var result = processor.reverse(input);

        // Assert
        assertEquals("olleh", result); 
    }

    @Test
    void reverse_withNull_throwsException() {
        // Arrange
        var processor = new StringProcessor();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.reverse(null);
        });
    }

    @Test
    void isPalindrome_withValidPalindrome_returnsTrue() {
        // Arrange
        var processor = new StringProcessor();
        var input = "racecar";

        // Act
        var result = processor.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    @Test
    void isPalindrome_withNonPalindrome_returnsFalse() {
        // Arrange
        var processor = new StringProcessor();
        var input = "hello";

        // Act
        var result = processor.isPalindrome(input);

        // Assert
        assertFalse(result);
    }

    @Test
    void isPalindrome_withNull_returnsFalse() {
        // Arrange
        var processor = new StringProcessor();

        // Act
        var result = processor.isPalindrome(null);

        // Assert
        assertFalse(result);
    }

    @Test
    void countVowels_withLowercase_countsCorrectly() {
        // Arrange
        var processor = new StringProcessor();
        var input = "hello world";

        // Act
        var result = processor.countVowels(input);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void countVowels_withNull_returnsZero() {
        // Arrange
        var processor = new StringProcessor();

        // Act
        var result = processor.countVowels(null);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void capitalizeWords_withLowercase_capitalizesCorrectly() {
        // Arrange
        var processor = new StringProcessor();
        var input = "hello world";

        // Act
        var result = processor.capitalizeWords(input);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    void capitalizeWords_withNull_returnsNull() {
        // Arrange
        var processor = new StringProcessor();

        // Act
        var result = processor.capitalizeWords(null);

        // Assert
        assertNull(result);
    }

    @Test
    void isNumeric_withDigits_returnsTrue() {
        // Arrange
        var processor = new StringProcessor();
        var input = "12345";

        // Act
        var result = processor.isNumeric(input);

        // Assert
        assertTrue(result);
    }

    @Test
    void isNumeric_withLetters_returnsFalse() {
        // Arrange
        var processor = new StringProcessor();
        var input = "123abc";

        // Act
        var result = processor.isNumeric(input);

        // Assert
        assertFalse(result);
    }

    @Test
    void isNumeric_withNull_returnsFalse() {
        // Arrange
        var processor = new StringProcessor();

        // Act
        var result = processor.isNumeric(null);

        // Assert
        assertFalse(result);
    }
}