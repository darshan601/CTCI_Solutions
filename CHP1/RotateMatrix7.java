package CHP1;

public class RotateMatrix7 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] new_res = new int[matrix.length][matrix.length];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // rotating 90 degree
                // 11 12 -> 21 11
                // 21 22 -> 22 12
                new_res[i][j] = matrix[len - j - 1][i];
            }
        }

        // System.out.println(new_res);
        // printing out the new matrix
        for (int[] is : new_res) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { { 11, 12, 13 },
                { 21, 22, 23 },
                { 31, 32, 33 } };

        rotate(matrix);
    }
}
