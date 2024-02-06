import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите число над которым надо провести арифметические выражения от 1 до 10 римскими или арабскимим цифрами ");
        String string = scanner.nextLine();
        //X+III или 3 + 5
        try {
            String result = operation(string);
            System.out.println("Ответ: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка!" + e.getMessage());
        }
    }

    public static String operation(String input) throws Exception {
        String[] strArray = input.split(" ");
        if (strArray.length != 3) {
            throw new Exception("Неверный формат");
        }
        String operand1 = strArray[0].trim();
        String operator = strArray[1].trim();
        String operand2 = strArray[2].trim();

        int num1, num2;
            try {
                num1 = isRoman(operand1) ? RomanToArabic.romanToArabic(operand1) : getNumber(operand1);
                num2 = isRoman(operand2) ? RomanToArabic.romanToArabic(operand2) : getNumber(operand2);
            } catch (Exception e) {
                throw new Exception("Ошибка в числах " + e.getMessage());
            }
            if (num1 <=0 || num1 > 10 || num2 <= 0 || num2 > 10){
                throw new Exception("Введенные числа должны быть от 1 до 10 включительно.");
            }

            int result;
            switch (operator) {

                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new Exception("Деление на ноль не допустимо!");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("Недопустимый оператор: " + operator);
            }



        if (isRoman(operand1) && isRoman(operand2)){
            if(result <= 0){
                throw new Exception("Операции не могут проводиться с отрицательними числами!");
            }
            return ToRoman.toRoman(result);
        }else{
            return Integer.toString(result);
        }
    }
    public static int getNumber(String operand) throws Exception{
        try{
            return Integer.parseInt(operand);
        }catch (NumberFormatException e){
            throw new Exception("Неверный формат числа " + operand);
        }
    }
    private static boolean isRoman(String input){
        return input.matches("[IVXLCDM]+");
    }

}
