package lab1;

import java.util.Scanner;

/**
 * C2 = 1 (Операція O1 "-")
 * C3 = 1 (Константа C = 1)
 * C5 = 0 (Операція O2 "*")
 * C7 = 2 (Тип індексів i та j "byte")
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");
        byte a, b, n, m;
        double res = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть значення 'a': ");
            a = inputValue(scanner);
            System.out.print("Введіть значення 'n': ");
            n = inputValue(scanner);
            System.out.print("Введіть значення 'b': ");
            b = inputValue(scanner);
            System.out.print("Введіть значення 'm': ");
            m = inputValue(scanner);
            System.out.println("a = " + a + "; n = " + n + "; b = " + b + "; m = " + m);
            if (a >= n) System.out.println("Помилка! 'a' має бути менше за 'n'.");
            else if (b >= m) System.out.println("Помилка! 'b' має бути менше за 'm'.");
            else break;
        }

        for (byte i = a; i <= n; i++) {
            for (byte j = b; j <= m; j++) {
                res += (double) (i * j) / (i - 1);
            }
        }
        if (res == Double.NEGATIVE_INFINITY || res == Double.POSITIVE_INFINITY)
            System.out.println("Ділення на нуль!");
        else System.out.println("Відповідь: " + res);

        System.out.println("Program finished");
    }

    private static byte inputValue(Scanner scanner) {
        String value;
        while (true) {
            value = scanner.next();
            if (isByte(value) && Byte.parseByte(value) >= 0) break;
            else
                System.out.print("Ви ввели значення, що не являється типом 'byte' або менше нуля. Спробуйте ще раз: ");
        }
        return Byte.parseByte(value);
    }

    private static boolean isByte(String value) {
        try {
            Byte.parseByte(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
