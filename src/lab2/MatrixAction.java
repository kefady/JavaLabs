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

    public static int[] calculateSum(short[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int[] result = new int[2];
        for (int i = 0; i < columnCount; i++) {
            short value = matrix[0][i];
            for (int j = 1; j < rowCount; j++) {
                if (i % 2 == 0) {
                    if (value > matrix[j][i]) value = matrix[j][i];
                } else {
                    if (value < matrix[j][i]) value = matrix[j][i];
                }
            }
            if (i % 2 == 0) result[0] += value;
            else result[1] += value;
        }
        return result;
    }

    public static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
                if (j == row.length - 1) System.out.print("]");
            }
            System.out.println();
        }
    }
}
