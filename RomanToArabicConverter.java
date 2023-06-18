import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToArabicConverter {

    // Создаем словарь для хранения соответствия римских цифр и их арабских эквивалентов
    private static final Map<Character, Integer> romanToArabicMap = new HashMap<>();

    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public static int convertRomanToArabic(String romanNumber) {
        int result = 0;
        int previousValue = 0;

        // Проходим по символам римского числа справа налево
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char ch = romanNumber.charAt(i);
            int value = romanToArabicMap.get(ch);

            // Если текущее значение больше предыдущего значения, вычитаем его из результата
            if (value < previousValue) {
                result -= value;
            }
            // Иначе, прибавляем его к результату
            else {
                result += value;
                previousValue = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // тестим
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");

        String romanNumber = scanner.nextLine();
        int arabicNumber = convertRomanToArabic(romanNumber);
        System.out.println(romanNumber + " в арабских цифрах: " + arabicNumber);
    }
}