package CHP1;

public class IsRotation9 {
    public static boolean isSubstring(String s1, String s2) {
        // check for substring

        if (s1.length() != s2.length())
            return false;

        StringBuilder builder = new StringBuilder();

        builder.append(s1);
        builder.append(s1);

        System.out.println(builder);

        if (builder.toString().indexOf(s2) == -1)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubstring("null", "lnul"));
    }
}
