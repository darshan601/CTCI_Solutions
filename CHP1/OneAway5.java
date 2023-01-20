package CHP1;

public class OneAway5 {
    public static boolean check(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 2) {
            return false;
        }

        if (str1.length() > str2.length()) {
            for (int i = 0; i < str2.length(); i++) {
                if (!str1.contains(str2.charAt(i) + "")) {
                    return false;
                }
            }
            return true;
        }
        if (str2.length() > str1.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (!str2.contains(str1.charAt(i) + "")) {
                    return false;
                }
            }
            return true;
        }
        int diff = 0;
        if (str2.length() == str1.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (!str2.contains(str1.charAt(i) + "")) {
                    diff++;
                }
            }
            return true;
        }
        if (diff > 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("False", "Dalse"));
        System.out.println(check("True", "Tru"));
        System.out.println(check("null", "dulll"));
    }
}
