import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию.");
        String primer = s.nextLine();
        System.out.println(calc(primer));

    }
    public static String calc(String input)
    {
        String rezG = "";
        String[] oper = {"\\+", "-", "/", "\\*"};
        String[] PrimerMas = {""};
        int i = 0;
        int z = 0;
        while ((z < 2) && (i < 4)) {
            PrimerMas = input.split(oper[i]);
            i = i + 1;
            z = PrimerMas.length;
        }
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int arab1 = 0;
        int arab2 = 0;
        int rim1 = 0;
        int rim2 = 0;
        if (PrimerMas.length == 2) {
            for (int ip = 0; ip < 10; ip++) {
                if (PrimerMas[0].equals(arab[ip])) {
                    arab1 = ip + 1;
                }
                if (PrimerMas[1].equals(arab[ip])) {
                    arab2 = ip + 1;
                }
                if (PrimerMas[0].equals(rim[ip])) {
                    rim1 = ip + 1;
                }
                if (PrimerMas[1].equals(rim[ip])) {
                    rim2 = ip + 1;
                }
            }
            int a1 = arab1 * arab2;
            int a2 = rim1 * rim2;
            String rezult = "";

            if (a1 != 0) {
                switch (i) {
                    case 1:
                        rezult = "" + (arab1 + arab2);
                        break;
                    case 2:
                        rezult = "" + (arab1 - arab2);
                        break;
                    case 3:
                        rezult = "" + (arab1 / arab2);
                        break;
                    case 4:
                        rezult = "" + (arab1 * arab2);
                        break;
                }

            }
            int rez = 0;
            if (a2 != 0) {
                switch (i) {
                    case 1:
                        rez = rim1 + rim2;
                        break;
                    case 2:
                        rez = rim1 - rim2;
                        break;
                    case 3:
                        rez = rim1 / rim2;
                        break;
                    case 4:
                        rez = rim1 * rim2;
                        break;
                }
                if (rez < 1) {
                    System.out.println("в римской системе нет отрицательных чисел");
                } else {
                    rezult = rim[rez - 1];
                }
            }
            rezG = rezult;
        }


        if (PrimerMas.length == 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
        if (PrimerMas.length > 2) {

            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }
        if (((arab1 * arab2) == 0) && ((rim1 * rim2) == 0) && (PrimerMas.length == 2)) {
            System.out.println("используются одновременно разные системы счисления");
        }

        return rezG;

    }


}