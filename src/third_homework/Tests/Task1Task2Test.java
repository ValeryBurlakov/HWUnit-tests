package third_homework.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import third_homework.Task1Task2.Task1Task2;


public class Task1Task2Test {
    private Task1Task2 mainHW;

    @BeforeEach
    void setup() {mainHW = new Task1Task2();}

    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * переданное число четным или нечетным
     */

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void evenOddNumberTrue(int n) {
        assertTrue( mainHW.evenOddNumber( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void evenOddNumberFalse(int n) {
        assertFalse( mainHW.evenOddNumber( n ) );
    }


    /**
     * Разработайте и протестируйте метод numberInInterval, который проверяет,
     * попадает ли переданное число в интервал (25;100)
     */

    @ParameterizedTest
    @ValueSource(ints = {26, 99, 50})
    void numbersInsideInterval(int n) {
        assertTrue( mainHW.numberInInterval( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, 8, 300})
    void numbersOutsideInterval(int n) {
        assertFalse( mainHW.numberInInterval( n ) );
    }
}
