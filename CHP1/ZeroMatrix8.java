package CHP1;

import java.util.ArrayList;

public class ZeroMatrix8 {

    public static void addZeros(int[][] matrix) {

        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        // Insert all zeros into an array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // aList.add()
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(Integer.valueOf(i));
                    list.add(Integer.valueOf(j));

                    aList.add(list);
                }
            }
        }

        // System.out.println(aList);

        // convert to 0
        for (ArrayList<Integer> arrayList : aList) {
            // System.out.println(arrayList);

            int i = arrayList.get(0);
            int j = arrayList.get(1);

            for (int k = 0; k < m; k++) {
                matrix[k][j] = 0;
            }
            for (int k = 0; k < n; k++) {
                matrix[i][k] = 0;
            }

        }

        System.out.println();
        // print matrix
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 2, 2, 0 },
                { 0, 4, 5 }
        };
        addZeros(matrix);
    }

}
