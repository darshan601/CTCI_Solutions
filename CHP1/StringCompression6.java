package CHP1;

public class StringCompression6 {
    public static String compress(String str) {
        // aabcccccaaa
        StringBuilder builder = new StringBuilder();
        // appending extra character to original string
        StringBuilder appendBuilder = new StringBuilder();
        appendBuilder.append(str);
        appendBuilder.append('0');

        // convert string builder to char Array
        char[] str1 = appendBuilder.toString().toCharArray();

        int count = 1;

        for (int index = 0; index < str1.length - 1; index++) {
            // System.out.println(index);
            // System.out.println(builder);

            if (str1[index] == str1[index + 1]) {
                count++;
            } else {
                builder.append(str1[index]);
                builder.append(String.valueOf(count));
                count = 1;
            }

        }
        if (builder.toString().length() >= str.length()) {
            return str;
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        // aabcccccaaa

        System.out.println(compress(args[0]));
    }
}
