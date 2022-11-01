package lab2;

import java.util.Scanner;

/**
 * C5 = 0 (Дія з матрицею "C=a×B, a - const")
 * C7 = 2 (Тип елементів матриці 'short')
 * C11 = 7 (Дія з матрицею С "Обчислити суму найбільших елементів в стовпцях матриці з непарними номерами та найменших
 * елементів в стовпцях матриці з парними номерами")
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість рядків матриці 'B': ");
        short rowCount = inputValue(scanner, (short) 1, Short.MAX_VALUE);
        System.out.print("Введіть кількість стовпців матриці 'B': ");
        short columnCount = inputValue(scanner, (short) 1, Short.MAX_VALUE);
        System.out.print("Введіть значення константи 'a': ");
        short constA = inputValue(scanner, (short) -3000, (short) 3000);

        short[][] matrixB = MatrixAction.createMatrixB(rowCount, columnCount);
        System.out.println("\nМатриця 'B'");
        MatrixAction.printMatrix(matrixB);

        if (!MatrixAction.isMatrixNormal(matrixB)) {
            return;
        }

        short[][] matrixC = MatrixAction.multMatrixByConst(matrixB, constA);
        System.out.println("\nМатриця 'C'");
        MatrixAction.printMatrix(matrixC);

        int maxSum = MatrixAction.calculateMaxSum(matrixC);
        int minSum = MatrixAction.calculateMinSum(matrixC);
        System.out.println("\nСума найбільших елементів в стовпцях матриці з непарними номерами: " + maxSum);
        System.out.println("Сума найменших елементів в стовпцях матриці з парними номерами: " + minSum);

        System.out.println("Program finished");
    }

    private static short inputValue(Scanner scanner, short from, short to) {
        String value;
        while (true) {
            value = scanner.next();
            if (isShort(value) && (Short.parseShort(value) >= from && Short.parseShort(value) <= to)) {
                break;
            }
            else {
                System.out.print("Помилка вводу -> Допустимий діапазон: від " + from + " до " + to + ". Спробуйте ще раз: ");
            }
        }
        return Short.parseShort(value);
    }

    private static boolean isShort(String value) {
        try {
            Short.parseShort(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
