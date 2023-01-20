package CHP1;

import java.util.Arrays;

class IsUnique1 {
    public static boolean checkUnique(String str) {
        char arr[] = str.toCharArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Darshn";

        System.out.println(checkUnique(s));
    }
}