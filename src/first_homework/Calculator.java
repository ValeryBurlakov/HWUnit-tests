package first_homework;

public class Calculator {
    public static int calculation(int variable_1, int variable_2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = variable_1 + variable_2;
                break;
            case '-':
                result = variable_1 - variable_2;
                break;
            case '*':
                result = variable_1 * variable_2;
                break;
            case '/':
                if (variable_2 != 0) {
                    result = variable_1 / variable_2;
                    break;
                } else {
                    throw new ArithmeticException("Деление на ноль невозможно");
                }
            default:
                throw new IllegalStateException("несоответствующий оператор: " + operator);
        }
        return result;
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (purchaseAmount <= 0)
            throw new ArithmeticException("Сумма покупки до применения скидки не может быть меньше или равной нулю.");
        if (discountAmount < 0 || discountAmount > 100)
            throw new ArithmeticException("Размер скидки должен быть в диапазоне [0,100]");
        return purchaseAmount-(purchaseAmount* discountAmount/100); // Метод должен возвращать сумму покупки со скидкой
    }
}