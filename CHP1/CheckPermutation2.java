package CHP1;

public class CheckPermutation2 {
    public static boolean checkPermutation(String str1, String str2) {
        // checking for bigger string
        char[] small;
        String big;
        if (str1.length() >= str2.length()) {
            big = str1;
            small = str2.toCharArray();
        } else {
            big = str2;
            small = str1.toCharArray();
        }

        // check if chars of small in big
        for (char c : small) {
            if (big.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "Darshan";
        String str2 = "Darsh";

        System.out.println(checkPermutation(str1, str2));
    }
}
