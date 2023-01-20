package CHP1;

import java.util.HashMap;

public class PalindromePermutation4 {
    public static boolean check(String s) {

        HashMap<Character, Integer> hMap = new HashMap<>();

        s = s.toLowerCase();

        for (Character c : s.toCharArray()) {
            // check for empty space
            if (c == ' ') {
                continue;
            }
            // if char not exists in hashmap
            try {
                hMap.put(c, hMap.get(c) + 1);
            } catch (Exception e) {

                hMap.put(c, 1);
            }
        }

        System.out.println(hMap);

        int odd = 0;
        int even = 0;

        for (Integer i : hMap.values()) {
            if (i % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        if (odd > 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("margOA"));
    }
}
