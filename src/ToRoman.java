

public class ToRoman {
    public static String toRoman(int number) throws Exception {
        if (number <= 0 || number > 4000) {
        throw new Exception("Невозможно приобразовать число в римский символ");
        }

        StringBuilder result = new StringBuilder();
        int [] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < value.length; i++) {
            while(number >= value[i]){
                result.append(numerals[i]);
                number = number - value[i];
            }

        }
        return result.toString();
    }
}
