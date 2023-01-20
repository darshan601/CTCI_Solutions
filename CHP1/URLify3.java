package CHP1;

public class URLify3 {
    private static String toURL(String str) {
        StringBuffer stringBuffer = new StringBuffer();

        for (Character c : str.toCharArray()) {
            if (c == ' ') {
                stringBuffer.append('%');
                stringBuffer.append('2');
                stringBuffer.append('0');
            } else {
                stringBuffer.append(c);
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "Mr. Darshan Mistry.";

        System.out.println(toURL(s));
    }
}
