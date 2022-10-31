import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main2 {
    static class NetRimOtris extends Exception {}
    static class DveRazlSist extends Exception {}
    static class NeMatOper extends Exception {}

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию."); // Это Важно222
        String primer = s.nextLine();
        try {
            System.out.println(calc(primer));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }catch (ArithmeticException e){
            System.out.println("Cтрока не является математической операцией");
        }catch (NetRimOtris e) {
            System.out.println("В римской системе нет отрицательных чисел");
        }catch (DveRazlSist e) {
            System.out.println("Используются одновременно разные системы счисления");
        }catch (NeMatOper e) {
            System.out.println("Строка не является математической операцией");
        }
    }
    public static String calc(String input) throws ArrayIndexOutOfBoundsException, ArithmeticException, NetRimOtris, DveRazlSist, NeMatOper {
        String rezG = "";           // для хранения итогов результата, возвращаемого методом
        char []  oper={'+','-','/','*'};
        String[] PrimerMas = {""};     // для хранения сплита строки
        char[] znOper=new char[1];     // для хранения найденных знаков оперций в введенной строке
        int z=0;
        int i;
        for (int j = 0; j<4;j++) {
            i=1;
            while (i<(input.length()-1)) {
                if (oper[j]==input.charAt(i)) {
                    znOper[z]=oper[j];
                  z++;
                 }
                i++;
            }

        }
        z=z/z; // Исскуственно вызывает исклюение, если в строке не нашли знаков операций
        String znOperStr;
        znOperStr="\\"+String.valueOf(znOper[0]);
        PrimerMas = input.split(znOperStr);
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
            String rezult = "";

            if ((arab1*arab2) != 0) {
                switch (znOper[0]) {
                    case '+':
                        rezult = "" + (arab1 + arab2);
                        break;
                    case '-':
                        rezult = "" + (arab1 - arab2);
                        break;
                    case '/':
                        rezult = "" + (arab1 / arab2);
                        break;
                    case '*':
                        rezult = "" + (arab1 * arab2);
                        break;
                }

            }
            int rez = 0;
            if ((rim1*rim2) != 0) {
                switch (znOper[0]) {
                    case '+':
                        rez = rim1 + rim2;
                        break;
                    case '-':
                        rez = rim1 - rim2;
                        break;
                    case '/':
                        rez = rim1 / rim2;
                        break;
                    case '*':
                        rez = rim1 * rim2;
                        break;
                }
                if (rez < 1) {
                        throw new NetRimOtris();
                } else {
                    rezult = rim[rez - 1];
                }
            }
            rezG = rezult;
        }
        if (((arab1!=0)&&((rim1!=0)||(rim2!=0)))||((arab2!=0)&&((rim1!=0)||(rim2!=0)))) {
           throw new DveRazlSist();
        }
        if (((arab1==0)&&(rim1==0))||((arab2==0)&&(rim2==0))){
        throw new NeMatOper();
        }
        return rezG;
    }
}