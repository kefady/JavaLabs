package lab2;

public class MatrixAction {
    public static short[][] createMatrixB(int rowCount, int columnCount) {
        short[][] matrix = new short[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] = (short) (Math.random() * 20 - 10);
            }
        }
        return matrix;
    }

    public static short[][] multMatrixByConst(short[][] matrix, short number) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        short[][] resultMatrix = new short[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                resultMatrix[i][j] = (short) (matrix[i][j] * number);
            }
        }
        return resultMatrix;
    }

    public static int calculateMaxSum(short[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        boolean onlyOneBiggest = true;
        int result = 0;
        for (int i = 1; i < columnCount; i += 2) {
            short value = matrix[0][i];
            for (int j = 1; j < rowCount; j++) {
                if (value == matrix[j][i]) {
                    onlyOneBiggest = false;
                } else if (value < matrix[j][i]) {
                    value = matrix[j][i];
                    onlyOneBiggest = true;
                }
            }
            if (onlyOneBiggest) {
                result += value;
            }
            onlyOneBiggest = true;
        }
        return result;
    }

    public static int calculateMinSum(short[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        boolean onlyOneLeast = true;
        int result = 0;
        for (int i = 0; i < columnCount; i += 2) {
            short value = matrix[0][i];
            for (int j = 1; j < rowCount; j++) {
                if (value == matrix[j][i]) {
                    onlyOneLeast = false;
                } else if (value > matrix[j][i]) {
                    value = matrix[j][i];
                    onlyOneLeast = true;
                }
            }
            if (onlyOneLeast) {
                result += value;
            }
            onlyOneLeast = true;
        }
        return result;
    }

    public static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
                if (j == row.length - 1) {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
    }

    public static boolean isMatrixGear(short[][] matrix) {
        int length = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != length) {
                return true;
            }
        }
        return false;
    }
}
