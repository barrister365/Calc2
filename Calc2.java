import java.util.*;
public class Calc2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");

        String input = scanner.nextLine();
        String result = calc(input);

        System.out.println("Результат: " + result);
    }

    public static String calc(String input) {
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неверное выражение");
        }

        String number1 = tokens[0];
        String operator = tokens[1];
        String number2 = tokens[2];

        int operand1 = 0;
        int operand2 = 0;

        StringBuilder sb = new StringBuilder();
        if (isRomanNumber(number1) && isRomanNumber(number2)) {
            int result = evaluateRomanExpression(number1, operator, number2);
//            sb.append(romanNumberToString(result));
            sb.append(RomanNumber.toRoman(result));
        } else if (!isRomanNumber(number1) && !isRomanNumber(number2)) {
        try {
            operand1 = Integer.parseInt(number1);
            operand2 = Integer.parseInt(number2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неподходящие числа");
        }

        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

            int result = evaluateArabicExpression(operand1, operator, operand2);
            sb.append(result);
        } else {
            throw new IllegalArgumentException("Нельзя использовать одновременно арабские и римские числа");
        }

        return sb.toString();
    }

    public static boolean isRomanNumber(String number) {
        return number.matches("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$");
    }

    public static int evaluateArabicExpression(int operand1, String operator, int operand2) {
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Неподходящая операция");
        }
        return result;
    }

    public static int evaluateRomanExpression(String number1, String operator, String number2) {
        int operand1 = RomanToArabicConverter.convertRomanToArabic(number1);
        int operand2 = RomanToArabicConverter.convertRomanToArabic(number2);
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Неподходящая операция");
        }
        return result;
    }}