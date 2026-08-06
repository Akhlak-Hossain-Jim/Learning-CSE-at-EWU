package grader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SStudentGradeCalculatorTest {

    private final StudentGradeCalculator calculator = new StudentGradeCalculator();

    @Test
    void calculateAverageReturnsAverageOfThreeScores() {
        assertEquals(90.0, calculator.calculateAverage(85, 90, 95));
    }


    @Test
    void getLetterGradeReturnsAForNinety() {
        assertEquals('A', calculator.getLetterGrade(90.0));
    }

    @Test
    void getLetterGradeReturnsBForJustBelowNinety() {
        assertEquals('B', calculator.getLetterGrade(89.9));
    }
    
    @Test
    void isPassingReturnsTrueForA() {
        assertTrue(calculator.isPassing('A'));
    }

    @Test
    void isPassingChecksCGradePassesAndFFails() {
        assertTrue(calculator.isPassing('C'));
        assertFalse(calculator.isPassing('F'));
    }

    @Test
    void getLetterGradeThrowsForAverageAboveOneHundred() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateAverage(101, 50, 75));
    }

}