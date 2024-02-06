import java.util.HashMap;

public class RomanToArabic {
        public static int romanToArabic(String roman) {
            int result = 0;

            // Определите сопоставление римских цифр с соответствующими значениями
            HashMap<Character, Integer> romanValues = new HashMap<>();
            romanValues.put('I', 1);
            romanValues.put('V', 5);
            romanValues.put('X', 10);
            romanValues.put('L', 50);
            romanValues.put('C', 100);
            romanValues.put('D', 500);
            romanValues.put('M', 1000);

            int prevValue = 0;

            // Перебрать строку римских цифр в обратном порядке
            for (int i = roman.length() - 1; i >= 0; i--) {
                char currentChar = roman.charAt(i);

                // Получить значение текущей римской цифры
                int currentValue = romanValues.getOrDefault(currentChar, 0);

                // Проверьте, меньше ли текущее значение предыдущего значения
                if (currentValue < prevValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }

                // Обновите предыдущее значение для следующей итерации
                prevValue = currentValue;
            }

            return result;
        }
    }

