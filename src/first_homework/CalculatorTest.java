package first_homework;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе сложения");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе вычитания");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе умножения");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе деления");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
//         try {
//             first_homework.Calculator.calculation(8, 4, '&');
//         } catch (IllegalStateException e) {
//             if (!e.getMessage().equals("Unexpected value operator: ")) {
//                 throw new AssertionError("Ошибка в методе, неправильные аргументы");
//             }
//         }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '?')
        ).isInstanceOf(IllegalStateException.class);

        /**
         * Проверка метода calculateDiscount().
         */
        // проверка на нормальных данных
        assertThat(Calculator.calculateDiscount(100,100)).isEqualTo(0.0);
        assertThat(Calculator.calculateDiscount(100,50)).isEqualTo(50.0);
        assertThat(Calculator.calculateDiscount(100,0)).isEqualTo(100.0);
//        assertThat(Calculator.calculateDiscount(100,-8)); // ArithmeticException, выход из диапазона скидки 0-100

    }
}
